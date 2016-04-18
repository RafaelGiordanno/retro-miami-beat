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

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class Assets extends AssetManager {
	public static Assets inst = new Assets();
	
	public static final String MAIN_THEME = "xy_final.ogg";
	public static final String REWIND_EFFECT = "scratch_back.wav";
	public static final String FONT = "Tr2n.ttf";
	
	private Assets() {
		load(MAIN_THEME, Music.class);
		load(REWIND_EFFECT, Sound.class);
		finishLoading();
	}
	
	public synchronized void dispose() {
		super.dispose();
	}
}
