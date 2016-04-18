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

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.wordpress.shapeshiftdance.controller.GameController;
import com.wordpress.shapeshiftdance.engine.Input;
import com.wordpress.shapeshiftdance.engine.SheetCamera;

public class ShapeShiftDance extends ApplicationAdapter {
	// CONSTANTS =======
	public static final int WIDTH = 384;
	public static final int HEIGHT = 240;
	public static final float TILE_SIZE = 16f;
	
	private GameController controller;
	private GameRenderer renderer;
	
	private SheetCamera camera;
	private Input input;
		
	public void create() {
		// initializing features
		camera = new SheetCamera(WIDTH / TILE_SIZE, HEIGHT / TILE_SIZE);
		input = new Input();
		Gdx.input.setInputProcessor(input);
		
		// initializing the helpers for logic and drawing
		controller = new GameController();
		renderer = new GameRenderer(controller);
	}
	
	public void dispose() {
		controller.dispose();
		renderer.dispose();
	}
	
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		controller.update(dt, input);
		renderer.render(camera);
	}
}
