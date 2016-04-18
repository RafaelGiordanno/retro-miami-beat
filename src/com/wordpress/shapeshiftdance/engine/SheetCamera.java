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

import com.badlogic.gdx.graphics.OrthographicCamera;

public class SheetCamera extends OrthographicCamera {
	public Entity target;
	
	public SheetCamera() { super(); }
	public SheetCamera(float w, float h) {
		super(w, h);
		this.position.x = w/2f;
		this.position.y = h/2f;
		this.update();
	}
	
	public void update() {
		if (hasTarget()) {
			this.position.x = getTarget().pos.x;
			this.position.y = getTarget().pos.y;
		}
		super.update();
	}
	
	public void setTarget(Entity other) { target = other; }
	public Entity getTarget() { return target; }
	public boolean hasTarget() { return target != null; }
}