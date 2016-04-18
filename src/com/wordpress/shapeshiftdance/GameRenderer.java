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
package com.wordpress.shapeshiftdance;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.wordpress.shapeshiftdance.controller.GameController;
import com.wordpress.shapeshiftdance.controller.GameController.GameState;
import com.wordpress.shapeshiftdance.engine.Collectible;
import com.wordpress.shapeshiftdance.engine.Entity;
import com.wordpress.shapeshiftdance.engine.Entity.Shape;
import com.wordpress.shapeshiftdance.engine.SheetCamera;

public class GameRenderer {
	GameController con;
	ShapeRenderer sr;
	SpriteBatch sb;
	float previousAudioPeakOffset;
	float audioPeakOffset;
	Color color;
	Color ghostColor;

	FreeTypeFontGenerator fontGenerator;
	FreeTypeFontParameter fontParameter;
	BitmapFont font;
	BitmapFont menuFont;
	
	OrthographicCamera guiCamera;
	
	public GameRenderer(GameController controller) {
		con = controller;
		sr = new ShapeRenderer();
		sb = new SpriteBatch();
		color = new Color(1f, 1f, 1f, 1f);
		ghostColor = new Color(1f, 1f, 1f, .1f);
		
		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("Tr2n.ttf"));
		fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 48;
		// fontParameter.
		font = new BitmapFont(Gdx.files.internal("tr2n.fnt"));
		font.getData().setScale(.5f);
		
		menuFont = new BitmapFont(Gdx.files.internal("retro-wide.fnt"));
		
		guiCamera = new OrthographicCamera(ShapeShiftDance.WIDTH, ShapeShiftDance.HEIGHT);
		guiCamera.position.set(guiCamera.viewportWidth/2f, guiCamera.viewportHeight/2f, 0f);
		guiCamera.update();
	}
	
	public void dispose() {
		fontGenerator.dispose();
		font.dispose();
		sr.dispose();
		sb.dispose();
	}
	
	Vector3 initialColors[] = {
			new Vector3(.1f, .3f, .4f),
			new Vector3(.8f, .2f, .2f),
			new Vector3(.2f, .8f, .4f),
			new Vector3(.5f, .3f, .7f),
	};
	Color bcol[] = {
			new Color(initialColors[0].x, initialColors[0].y, initialColors[0].z, .1f),
			new Color(initialColors[1].x, initialColors[1].y, initialColors[1].z, .11f),
			new Color(initialColors[2].x, initialColors[2].y, initialColors[2].z, .11f),
			new Color(initialColors[3].x, initialColors[3].y, initialColors[3].z, .11f)
	};
	
	float secondsToBlur = .0125f;
	float secondsToBlurTime = 0f;
	public void render(SheetCamera cam) {
		// cam.zoom = 2f;
		// cam.update();
		secondsToBlurTime += Gdx.graphics.getDeltaTime();
		if (secondsToBlurTime > secondsToBlur) {
			secondsToBlurTime = 0f;
			Gdx.gl.glClearColor(0f, 0f, 0f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		}
		audioPeakOffset = con.audioController.getPeakAudioValue();
		previousAudioPeakOffset = con.audioController.getPeakAudioValue();
		// update the viewport
		sr.setProjectionMatrix(cam.combined);
		
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		
		drawBackground(cam.viewportWidth, cam.viewportHeight);
		
		color.a = audioPeakOffset;
		// rendering the player
		sr.setColor(color);
		sr.begin(ShapeType.Line);
		for (Collectible col : con.levelController.patterns) {
			color.a = con.audioController.getPeakAudioValue();
			drawCollectible(col, col.shape, color, audioPeakOffset * .25f);
		}
		color.a = con.audioController.getPeakAudioValue();
		sr.setColor(color);
		drawEntity(con.player, con.player.shape, color, audioPeakOffset * .75f);
		sr.end();
		
		Gdx.gl.glDisable(GL20.GL_BLEND);
		
		// draw the HUD
		if (con.gameState == GameState.MENU) {
			drawMenu();
		} else if (con.gameState == GameState.WIN) { 
			drawWin();
		} else {
			drawGUI();
		}
	}
	
	float backgroundColorStateTime = 0f;
	
	private void drawBackground(float vw, float vh) {
		backgroundColorStateTime += Gdx.graphics.getDeltaTime();
		for (int i = 0; i < bcol.length; i++) {
			bcol[i].r = MathUtils.clamp(initialColors[i].x + (MathUtils.sin(backgroundColorStateTime + (MathUtils.PI * i) * .5f) + 1) * .25f, 0f, 1f);
			bcol[i].g = MathUtils.clamp(initialColors[i].y + (MathUtils.sin(backgroundColorStateTime + (MathUtils.PI * i) * .5f) + 1) * .5f, 0f, 1f);
			bcol[i].b = MathUtils.clamp(initialColors[i].z + (MathUtils.sin(backgroundColorStateTime + (MathUtils.PI * i) * .5f) + 1) * .5f, 0f, 1f);
		}
		sr.begin(ShapeType.Filled);
		sr.rect(0f, 0f, vw, vh, bcol[0], bcol[1], bcol[2], bcol[3]);
		sr.end();
		
	}
	
	int score = 0;
	
	private void drawEntity(Entity ent, Shape shape, Color c, float pOff) {
		sr.setColor(c);
		if (shape == Shape.SQUARE) {
			sr.setColor(c);
			sr.rect(ent.pos.x - ent.r/2f - pOff, ent.pos.y - ent.r/2f - pOff, ent.r + pOff*2f, ent.r + pOff*2f);
		} else if (shape == Shape.CIRCLE) {
			sr.setColor(c);
			sr.circle(ent.pos.x, ent.pos.y, ent.r / 2 + pOff, 32);
		}
	}
	
	private void drawCollectible(Collectible col, Shape shape, Color c, float pOff) {
		sr.setColor(c);
		if (shape == Shape.SQUARE) {
			if (col.collected) {
				c.a = MathUtils.clamp(c.a - col.deathStateTime, 0f, 1f);
				sr.setColor(c);
				sr.rect(col.pos.x - col.r/2f,
						col.pos.y - col.r/2f, 
						col.r + col.deathStateTime * 2f, 
						col.r + col.deathStateTime * 2f);
			} else {
				sr.rect(col.pos.x - col.r/2f - pOff, col.pos.y - col.r/2f - pOff, col.r + pOff*2f, col.r + pOff*2f);
			}
		} else if (shape == Shape.CIRCLE) {
			if (col.collected) {
				c.a = MathUtils.clamp(c.a - col.deathStateTime, 0f, 1f);
				sr.setColor(c);
				sr.circle(col.pos.x, col.pos.y, col.r / 2 + col.deathStateTime * 4f, 48);
			} else {
				sr.circle(col.pos.x, col.pos.y, col.r / 2 + pOff, 48);
			}
		}
	}
	
	boolean renderCheckPointText = true;
	float checkPointStateTime = 0f;
	
	Vector2 checkPointPosition = new Vector2();
	int rendererCurrentCheckPoint = 0;
	
	float checkPointHeight = 0f;
	float comboHeight = 700f;
	
	Color missesColor;
	
	private void drawGUI() {
		// background
		sr.setProjectionMatrix(guiCamera.combined);		
		sr.begin(ShapeType.Filled);
		sr.setColor(Color.BLACK);
		if (checkPointStateTime < 7.8f) {
			checkPointHeight = MathUtils.lerp(checkPointHeight, 24f, .3f);
		} else {
			checkPointHeight = MathUtils.lerp(checkPointHeight, 0f, .3f);
		}
		sr.rect(0f, 0f, guiCamera.viewportWidth, checkPointHeight);
		sr.rect(0f, guiCamera.viewportHeight - 24f, guiCamera.viewportWidth, 24f);
		sr.end();
		
		// are we doing well in this game???
		sr.setColor(
					(con.getCurrentMisses() == 0 ? Color.GREEN : 
					(con.getCurrentMisses() == 1 ? Color.YELLOW :
					(con.getCurrentMisses() == 2 ? Color.ORANGE :
						Color.RED)))
				);
		sr.begin(ShapeType.Line);
		sr.circle(230, guiCamera.viewportHeight - 12, 6f + con.audioController.getPeakAudioValue() * 4f, 32);
		sr.end();
		
		sb.setProjectionMatrix(guiCamera.combined);
		sb.begin();
		float scaleXY = con.audioController.getPeakAudioValue() / 8f + .25f;
		float offset = scaleXY - 0.3f;
		font.getData().setScale(scaleXY);
		font.draw(sb, "Score: " + con.getScore(), guiCamera.viewportWidth-120f - offset * 100f, guiCamera.viewportHeight - 10f + offset * 100f);
		
		// Current score type!
		
		font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, MathUtils.clamp(offset * 27f + .3f, .7f, 1f));
		font.draw(sb, con.currentScoreType.toString(), 12, guiCamera.viewportHeight- 10f + offset * 100f);
		
		// Combo!
		if (con.getCurrentCombo() > 6) {
			comboHeight = MathUtils.lerp(comboHeight, guiCamera.viewportHeight - 10f, .3f);
			font.draw(sb, "Combo: " + con.getCurrentCombo(), 120, comboHeight + offset * 100f);
		} else if (comboHeight < guiCamera.viewportHeight) {
			comboHeight = MathUtils.lerp(comboHeight, guiCamera.viewportHeight + 5f, .3f);
			font.draw(sb, "Combo: " + con.getCurrentCombo(), 120, comboHeight + offset * 100f);
		}
		
		font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, 1f);
		// CheckPoint Stuff
		if (con.checkPointRestart) {
			checkPointStateTime = 0f;
		}
		if (checkPointStateTime < 7.8f) {
			checkPointStateTime += Gdx.graphics.getDeltaTime();
			if (scaleXY > 0.22f) {
				font.draw(sb, "=== CheckPoint Reached! ===", guiCamera.viewportWidth - (checkPointStateTime * (guiCamera.viewportWidth/3.8f) - offset * 240), checkPointHeight - 8f);
				// font.draw(sb, "=== CheckPoint Reached! ===", 80 - offset * 200f, 24f);
			}
		}
		sb.end();
	}
	
	float menuStateTime = 0f;
	
	private void drawMenu() {
		menuStateTime += Gdx.graphics.getDeltaTime();
		float sin = MathUtils.sin(menuStateTime);
		float cos = MathUtils.cos(menuStateTime);
		
		menuFont.getData().setScale(1f);
		// 3 shades of gray lulz
		sb.begin();
		menuFont.setColor(Color.DARK_GRAY);
		menuFont.draw(sb, "Retro Miami\n        Beat",
				118 + MathUtils.cos(menuStateTime) * 8f,
				430 + MathUtils.sin(menuStateTime) * 8f);
		menuFont.setColor(Color.GRAY);
		menuFont.draw(sb, "Retro Miami\n        Beat",
				118 + MathUtils.cos(menuStateTime) * 16f,
				430 + MathUtils.sin(menuStateTime) * 16f);
		menuFont.setColor(Color.WHITE);
		menuFont.draw(sb, "Retro Miami\n        Beat",
				118 + MathUtils.cos(menuStateTime) * 20f,
				430 + MathUtils.sin(menuStateTime) * 20f);
		
		// options
		menuFont.getData().setScale(.34f);
		menuFont.setColor(Color.DARK_GRAY);
		menuFont.draw(sb, "Start Game & Change Shape With <<Space Bar>>", 50 + cos * 4, 230 + sin * 4);
		menuFont.setColor(Color.GRAY);
		menuFont.draw(sb, "Start Game & Change Shape With <<Space Bar>>", 50 + cos * 8, 230 + sin * 8);
		menuFont.setColor(Color.WHITE);
		menuFont.draw(sb, "Start Game & Change Shape With <<Space Bar>>", 50 + cos * 14, 230 + sin * 14);
		
		
		menuFont.setColor(Color.DARK_GRAY);
		menuFont.draw(sb, "Switch Lanes with W / S Or Up / Down Arrows", 48 + cos * 4, 190 + sin * 4);
		menuFont.setColor(Color.GRAY);
		menuFont.draw(sb, "Switch Lanes with W / S Or Up / Down Arrows", 48 + cos * 8, 190 + sin * 8);
		menuFont.setColor(Color.WHITE);
		menuFont.draw(sb, "Switch Lanes with W / S Or Up / Down Arrows", 48 + cos * 14, 190 + sin * 14);
		
		
		menuFont.draw(sb, "Match the Shapes to progress! :D", 138, 150);
		menuFont.draw(sb, "Sorry for ruining your video card for VFX", 68, 110);
		menuFont.draw(sb, "Made in 48h by Rafael Giordanno for LDJAM", 55, 70);
		menuFont.getData().setScale(.2f);
		menuFont.draw(sb, "( r e a l l y  r e a l l y )  T i n y  e p i l e p s y  w a r n i n g . . . ", 140 + MathUtils.sin(menuStateTime) * 120, 25);
		sb.end();
	}
	
	private void drawWin() {
		sb.setProjectionMatrix(guiCamera.combined);
		menuStateTime += Gdx.graphics.getDeltaTime() * 4f;
		float sin = MathUtils.sin(menuStateTime);
		float cos = MathUtils.cos(menuStateTime);
		
		menuFont.getData().setScale(.92f);
		// 3 shades of gray lulz
		sb.begin();
		menuFont.setColor(Color.DARK_GRAY);
		menuFont.draw(sb, "You've \"Beaten\"\n      the Game!!!",
				42 + MathUtils.cos(menuStateTime * 2f) * 8f,
				430 + MathUtils.sin(menuStateTime * 2f) * 8f);
		menuFont.setColor(Color.GRAY);
		menuFont.draw(sb, "You've \"Beaten\"\n      the Game!!!",
				42 + MathUtils.cos(menuStateTime * 2f) * 16f,
				430 + MathUtils.sin(menuStateTime * 2f) * 16f);
		menuFont.setColor(Color.WHITE);
		menuFont.draw(sb, "You've \"Beaten\"\n      the Game!!!",
				42 + MathUtils.cos(menuStateTime * 2f) * 20f,
				430 + MathUtils.sin(menuStateTime * 2f) * 20f);
		
		menuFont.getData().setScale(.34f);
		menuFont.setColor(Color.DARK_GRAY);
		menuFont.draw(sb, "Score: " + con.getScore() + "\nMax Combos: " + con.getMaxCombos(), 138 + cos * 8, 240 + sin * 8);
		menuFont.setColor(Color.GRAY);
		menuFont.draw(sb, "Score: " + con.getScore() + "\nMax Combos: " + con.getMaxCombos(), 138 + cos * 14, 240 + sin * 14);
		menuFont.setColor(Color.WHITE);
		menuFont.draw(sb, "Score: " + con.getScore() + "\nMax Combos: " + con.getMaxCombos(), 138 + cos * 20, 240 + sin * 20);
		
		menuFont.getData().setScale(.34f);
		menuFont.setColor(Color.DARK_GRAY);
		menuFont.draw(sb, "Don't forget to vote for this game :D\nSorry for ending it too quick :/\nI ran out of time for polishing it...\nPress <<SPACE>> to play it again :D", 138 + cos * 8, 160 + sin * 8);
		menuFont.setColor(Color.GRAY);
		menuFont.draw(sb, "Don't forget to vote for this game :D\nSorry for ending it too quick :/\nI ran out of time for polishing it...\nPress <<SPACE>> to play it again :D", 138 + cos * 14, 160 + sin * 14);
		menuFont.setColor(Color.WHITE);
		menuFont.draw(sb, "Don't forget to vote for this game :D\nSorry for ending it too quick :/\nI ran out of time for polishing it...\nPress <<SPACE>> to play it again :D", 138 + cos * 20, 160 + sin * 20);
		/*
		menuFont.draw(sb, "Don't forget to vote for this game :D", 138, 180);
		menuFont.draw(sb, "Sorry for ending it too quick :/", 138, 150);
		menuFont.draw(sb, "I ran out of time for polishing it...", 138, 120);
		menuFont.draw(sb, "Press <<SPACE>> to play it again :D", 138, 90);
		*/
		sb.end();
	}
}
