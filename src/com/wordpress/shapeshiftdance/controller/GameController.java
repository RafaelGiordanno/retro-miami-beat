/**
 * Copyright (C) 2016, Rafael Giordanno.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation version 2;
 * 	
 * This program is distributed WITHOUT ANY WARRANTY; 
 * without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License version 2 for more details.
 * You should have received a copy of the GNU General Public License version 2
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.wordpress.shapeshiftdance.controller;

import com.badlogic.gdx.math.MathUtils;
import com.wordpress.shapeshiftdance.ScoreTypes;
import com.wordpress.shapeshiftdance.engine.Collectible;
import com.wordpress.shapeshiftdance.engine.Entity;
import com.wordpress.shapeshiftdance.engine.Entity.Shape;
import com.wordpress.shapeshiftdance.engine.Input;

public class GameController {
	public Entity player;
	
	public AudioController audioController;
	public LevelController levelController;
	
	private float[] checkPoints = { 0.f, 46.f, 80.f, 120f };
	private int currentCheckPointIndex = 0;
	public boolean checkPointRestart = false;
	
	public enum GameplayType { BREAK, SEQUENCE };
	public GameplayType gameplayType = GameplayType.SEQUENCE;
	
	public enum GameState { MENU, GAME, REWINDING, WIN };
	public GameState gameState = GameState.MENU;
	
	float rewindStateTime = 0f;
	final float MAX_REWIND_TIME = 1f;
	float menuStateTime = 0f;
	final float MAX_MENU_TIME = 1f;
	
	public GameController() {
		player = new Entity(2.875f, 8f);
		audioController = new AudioController();
		audioController.returnToCheckPoint(checkPoints[currentCheckPointIndex]);
		levelController = new LevelController();
	}
	
	public void dispose() {
		audioController.dispose();
	}
	
	public void update(float dt, Input input) {
		checkPointRestart = false;
		checkPauseGame(input);
		if (!gamePaused) {
			if (gameState == GameState.GAME) {
				if (!audioController.isPlaying()) {
					audioController.play();
				}
				updateCheckPoint();
				audioController.update();
				handleInput(dt, input);
				updateEntities(dt);
				// if we make mistakes, we go back
				if (currentMisses == maxMisses) {
					returnToCurrentCheckPoint();
				}
				if (audioController.getCurrentTime() > 160) {
					gameState = GameState.WIN;
				}
			} else if (gameState == GameState.REWINDING) {
				rewindStateTime += dt;
				if (audioController.isPlaying()) {
					audioController.pause();
				}
				audioController.rewind(rewindStateTime, checkPoints[currentCheckPointIndex]);
				updateEntities(dt);
				handleInput(dt, input);
				if (rewindStateTime > MAX_REWIND_TIME) {
					rewindStateTime = 0f;
					gameState = GameState.GAME;
					audioController.setPosition(checkPoints[currentCheckPointIndex]);
					currentMisses = 0;
				}
			} else if (gameState == GameState.MENU) {
				if (audioController.isPlaying()) {
					audioController.pause();
					updateEntities(dt);
					audioController.setPosition(checkPoints[currentCheckPointIndex]);
					currentMisses = 0;
				}
				if (input.buttons[Input.CHANGE_SHAPE]) {
					gameState = GameState.REWINDING;
				}
			} else if (gameState == GameState.WIN) {
				if (audioController.isPlaying()) {
					audioController.pause();
					updateEntities(dt);
					audioController.setPosition(checkPoints[currentCheckPointIndex]);
					currentMisses = 0;
					currentCheckPointIndex = 0;
				}
				if (input.buttons[Input.CHANGE_SHAPE]) {
					gameState = GameState.REWINDING;
				}
			} else {
				System.out.println("Where the fuck am i?");
			}
		} else {
			if (audioController.isPlaying()) {
				audioController.pause();
			}
		}
	}
	
	private void updateCheckPoint() {
		boolean checkPointsInBound = currentCheckPointIndex < checkPoints.length-1;
		boolean areWeOnNextCheckpoint = checkPointsInBound && (audioController.getCurrentTime() > checkPoints[currentCheckPointIndex+1]);

		if (checkPointsInBound && areWeOnNextCheckpoint) {
			++currentCheckPointIndex;
			checkPointScore = score;
			checkPointRestart = true;
		}
	}
	
	public int getCurrentCheckPoint() {
		return currentCheckPointIndex;
	}
	
	private void checkPauseGame(Input input) {
		if (input.buttons[Input.PAUSE] && !pausePressed) {
			pausePressed = true;
			gamePaused = !gamePaused;
		} else if (!input.buttons[Input.PAUSE]) {
			pausePressed = false;
		}
	}
	
	private static final float MAX_HOR_VEL = .3f;
	private static final float MAX_VER_VEL = .3f;
	
	boolean changeShapePressed = false;
	boolean checkPointPressed = false;
	boolean pausePressed = false;
	boolean gamePaused = false;
	boolean upPressed = false;
	boolean downPressed = false;
	
	private void handleInput(float dt, Input input) {
		// time to change shape?
		if (input.buttons[Input.CHANGE_SHAPE] && !changeShapePressed) {
			changeShapePressed = true;
			changeShape(player);
		} else if (!input.buttons[Input.CHANGE_SHAPE]) {
			changeShapePressed = false;
		}
		
		if (input.buttons[Input.CHECKPOINT] && !checkPointPressed) {
			checkPointPressed = true;
			returnToCurrentCheckPoint();
		} else if (!input.buttons[Input.CHECKPOINT]) {
			checkPointPressed = false;
		}
		
		player.vel.y = 0f;
		// Check vertical movement
		if (input.buttons[Input.UP] && !upPressed) {
			upPressed = true;
			player.vel.y = 1f;
		} else if (!input.buttons[Input.UP]) {
			upPressed = false;
		}
		
		if (input.buttons[Input.DOWN] && !downPressed) {
			downPressed = true;
			player.vel.y = -1f;
		} else if (!input.buttons[Input.DOWN]) {
			downPressed = false;
		}
		
		// check horizontal movement
		/*
		if (input.buttons[Input.LEFT]) {
			player.vel.x -= acc * dt;
		} else if (input.buttons[Input.RIGHT]) {
			player.vel.x += acc * dt;
		} else {
			player.vel.x = MathUtils.lerp(player.vel.x, 0f, 4f * dt);
		}
		*/
		// we can't pass through the limit speed
		player.vel.set(
				MathUtils.clamp(player.vel.x, -MAX_HOR_VEL, MAX_HOR_VEL),
				MathUtils.clamp(player.vel.y, -MAX_VER_VEL, MAX_VER_VEL)
			);
	}
	
	private void returnToCurrentCheckPoint() {
		checkPointRestart = true;
		currentMisses = 0;
		gameState = GameState.REWINDING;
		score = checkPointScore;
		for (Collectible col : levelController.patterns) {
			col.collected = false;
			col.deathStateTime = 0f;
			col.pos.set(col.initialPos.x, col.initialPos.y);
		}
		audioController.returnToCheckPoint(checkPoints[currentCheckPointIndex]);
	}
	
	private void changeShape(Entity ent) {
		if (ent.shape == Shape.SQUARE) {
			ent.shape = Shape.CIRCLE;
		} else if (ent.shape == Shape.CIRCLE) {
			ent.shape = Shape.SQUARE;
		}
	}
	
	float currX = 0f;
	
	private void updateEntities(float dt) {
		// player.pos.x += player.vel.x;
		if (player.vel.y > 0f && player.pos.y < 12f) {
			player.pos.y += 2f;
		} else if (player.vel.y < 0f && player.pos.y > 2f) {
			player.pos.y -= 2f;
		}
		player.pos.y = MathUtils.clamp(player.pos.y, 2f, 12f);
		// player.pos.y += player.vel.y;
		for (Collectible col : levelController.patterns) {
			if (col.pos.x < -4f && gameState == GameState.GAME) continue; 
			col.updateStateTime(dt);
			if (gameplayType == GameplayType.BREAK && audioController.getPeakAudioValue() == 1) {
				currX = audioController.getCurrentTime();
			} else if (gameplayType == GameplayType.SEQUENCE) {
				currX = audioController.getCurrentTime();
			}
			
			col.pos.x = col.initialPos.x - currX * 12f;
			
			checkCollisionWithPlayer(col);
			
		}
	}
	
	private int score = 0;
	private int checkPointScore = 0;
	private int combo = 0;
	private int maxCombo = 0;
	public ScoreTypes.Types currentScoreType = ScoreTypes.Types.BOO;
	private int maxMisses = 5;
	private int currentMisses = 0;
	
	public int getMaxCombos() {
		return maxCombo;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getCurrentCombo() {
		return combo;
	}
	
	private void checkCollisionWithPlayer(Collectible col) {
		float collidableDst = player.r ;
		float currentDst = player.pos.dst(col.pos);
		if (currentDst < collidableDst && player.shape == col.shape) {
			if (col.collected == false && gameState == GameState.GAME) {
				if (currentDst > .838f) {
					currentScoreType = ScoreTypes.Types.PERFECT;
					score += ScoreTypes.PERFECT;
					incrementCombo();
					changeCurrentMisses(-1);
				} else if (currentDst > .72) {
					currentScoreType = ScoreTypes.Types.GREAT;
					score += ScoreTypes.GREAT;
					incrementCombo();
					changeCurrentMisses(-1);
				} else if (currentDst > .5f) {
					score += ScoreTypes.GOOD;
					currentScoreType = ScoreTypes.Types.GOOD;
					combo = 0;
					changeCurrentMisses(-1);
				} else {
					currentScoreType = ScoreTypes.Types.BOO;
					combo = 0;
					changeCurrentMisses(1);
				}
			}
			// Collided
			if (gameState == GameState.GAME) {
				col.collected = true;
			}
		} else if (col.pos.x < player.pos.x && !col.collected) {
			currentScoreType = ScoreTypes.Types.MISS;
			changeCurrentMisses(1);
			combo = 0;
			if (gameState == GameState.GAME) {
				col.collected = true;
			}
		}
		if (gameState == GameState.REWINDING) {
			col.collected = false;
			col.deathStateTime = 0f;
			// col.pos.set(col.initialPos.x, col.initialPos.y);
		}
	}
	
	public int getCurrentMisses() {
		return currentMisses;
	}
	
	private void changeCurrentMisses(int i) {
		currentMisses += i;
		if (currentMisses > maxMisses) {
			currentMisses = maxMisses;
		} else if (currentMisses < 0) {
			currentMisses = 0;
		}
	}
	
	private void incrementCombo() {
		++combo;
		if (combo > maxCombo) { maxCombo = combo; }
	}
}