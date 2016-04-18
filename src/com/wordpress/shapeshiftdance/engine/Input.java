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
package com.wordpress.shapeshiftdance.engine;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor {

	public boolean buttons[];
	// buttons
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public static final int CHANGE_SHAPE = 4;
	public static final int PAUSE = 5;
	public static final int CHECKPOINT = 6;
	
	public static final int MENU = 7;

	// keys
	public static int K_UP    = Keys.W;
	public static int K_DOWN  = Keys.S;
	public static int K_LEFT  = Keys.A;
	public static int K_RIGHT = Keys.D;
	
	public static int K_CHANGE_SHAPE = Keys.SPACE;
	public static int K_PAUSE = Keys.P;
	public static int K_CHECKPOINT = Keys.K;
	public static int K_MENU = Keys.ESCAPE;
	
	public Input() {
		buttons = new boolean[32];
	}
	public boolean keyDown(int keycode) { 
		if      (keycode == K_UP || keycode == Keys.UP)      { buttons[UP]    = true; }
		else if (keycode == K_DOWN || keycode == Keys.DOWN)  { buttons[DOWN]  = true; }
		else if (keycode == K_LEFT || keycode == Keys.LEFT)  { buttons[LEFT]  = true; }
		else if (keycode == K_RIGHT || keycode == Keys.RIGHT) { buttons[RIGHT] = true; }
		
		else if (keycode == K_CHANGE_SHAPE) { buttons[CHANGE_SHAPE] = true; }
		else if (keycode == K_PAUSE) { buttons[PAUSE] = true; }
		
		// debug keys, comment if you don't want it
		else if (keycode == K_CHECKPOINT) { buttons[CHECKPOINT] = true; }
		
		else if (keycode == K_MENU) { buttons[MENU] = true; }
		return true;
	}
	public boolean keyUp(int keycode) { 
		if      (keycode == K_UP || keycode == Keys.UP)      { buttons[UP]    = false; }
		else if (keycode == K_DOWN || keycode == Keys.DOWN)  { buttons[DOWN]  = false; }
		else if (keycode == K_LEFT || keycode == Keys.LEFT)  { buttons[LEFT]  = false; }
		else if (keycode == K_RIGHT || keycode == Keys.RIGHT) { buttons[RIGHT] = false; }
		
		else if (keycode == K_CHANGE_SHAPE) { buttons[CHANGE_SHAPE] = false; }
		else if (keycode == K_PAUSE) { buttons[PAUSE] = false; }
		
		// debug keys, comment if you don't want it
		else if (keycode == K_CHECKPOINT) { buttons[CHECKPOINT] = false; }
		else if (keycode == K_MENU) { buttons[MENU] = false; }
		return true;
	}
	public boolean keyTyped(char character) { return false; }
	public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }
	public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }
	public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }
	public boolean mouseMoved(int screenX, int screenY) { return false; }
	public boolean scrolled(int amount) { return false; }
}