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

public class ScoreTypes {
	
	public enum Types { PERFECT, GREAT, GOOD, BOO, MISS };
	
	public static final int PERFECT = 8;
	public static final int GREAT   = 4;
	public static final int GOOD    = 2;
	
	public String getScoreString(Types t) {
		if (t == Types.PERFECT) {
			return "PERFECT";
		} else if (t == Types.GREAT) {
			return "GREAT";
		} else if (t == Types.GOOD) {
			return "GOOD";
		} else if (t == Types.MISS) {
			return "BOO";
		}
		return "MISS";
	}
}
