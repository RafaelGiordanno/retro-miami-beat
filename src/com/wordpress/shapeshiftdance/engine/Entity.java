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

import com.badlogic.gdx.math.Vector2;

public class Entity {
	public Vector2 pos;
	public Vector2 vel;
	public float r;
	public Vector2 initialPos;
	
	public enum Shape { SQUARE, CIRCLE };
	public Shape shape;
	
	public Entity(float x, float y, float radius, Shape type) {
		pos = new Vector2(x, y);
		vel = new Vector2();
		r = radius;
		
		shape = type;
		
		initialPos = new Vector2(x, y);
	}
	
	public Entity(float x, float y, float radius) {
		this(x, y, radius, Shape.SQUARE);
	}
	
	public Entity(float x, float y) {
		this(x, y, 1f, Shape.SQUARE);
	}
	
	public Entity() {
		this(0f, 0f, 1f, Shape.SQUARE);
	}
}
