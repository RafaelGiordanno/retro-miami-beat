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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Collectible extends Entity {
	public boolean collected = false;
	
	public float deathStateTime = 0f;
	public final float MAX_DEATH_STATE_TIME = 1f;
	
	public enum CollectibleType { STRAIGHT, ZIGZAG, PONG, BOUNCE };
	public CollectibleType colType;
	
	public Collectible(float x, float y, float radius, Shape type, CollectibleType colType) {
		pos = new Vector2(x, y);
		vel = new Vector2();
		r = radius;
		
		shape = type;
		
		initialPos = new Vector2(x, y);
		
		this.colType = colType;
	}
	
	public Collectible(float x, float y, float radius, Shape type) {
		this(x, y, radius, type, CollectibleType.STRAIGHT);
	}
	
	public Collectible(float x, float y, float radius) {
		this(x, y, radius, Shape.SQUARE);
	}
	
	public Collectible(float x, float y) {
		this(x, y, 1f, Shape.SQUARE);
	}
	
	public Collectible() {
		this(0f, 0f, 1f, Shape.SQUARE);
	}
	
	public void updateStateTime(float dt) {
		if (collected) { deathStateTime += dt; }
	}
	
	public boolean isDead() {
		if (collected) {
			updateStateTime(Gdx.graphics.getDeltaTime());
		}
		if (deathStateTime > MAX_DEATH_STATE_TIME) {
			return true;
		}
		return false;
	}
}
