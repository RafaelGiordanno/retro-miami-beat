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

import java.util.ArrayList;

import com.wordpress.shapeshiftdance.engine.Collectible;
import com.wordpress.shapeshiftdance.engine.Entity.Shape;

public class LevelController {
	
	public ArrayList<Collectible> patterns;
	
	public LevelController() {
		createPatterns();
	}
	
	private void createPatterns() {
		patterns = new ArrayList<>();
		float cx;
		/**
		 * alguns valores para iniciar patterns:
		 * - 3, 27, 51, 75
		cx = 3f;
		cx += 3f;
		cx += 1.75f;
		cx += 2f;
		cx += 2.25f;
		
		// bar 2
		cx += 3f;
		cx += 3f;
		cx += 3f;
		cx += 1.5f;
		cx += 1.5f;
			
		*/
		/*
		patterns.add(new Collectible(3f, 12f, 1.f, Shape.SQUARE));
		patterns.add(new Collectible(9f, 12f, 1.f, Shape.SQUARE));
		patterns.add(new Collectible(15f, 12f, .625f, Shape.SQUARE));
		patterns.add(new Collectible(16.5f, 12f, .625f, Shape.SQUARE));
		patterns.add(new Collectible(21f, 12f, 1.f, Shape.SQUARE));

		// bar 2
		patterns.add(new Collectible(27f, 12f, 1.25f, Shape.SQUARE));
		patterns.add(new Collectible(33f, 12f, 1.25f, Shape.SQUARE));
		patterns.add(new Collectible(39f, 12f, 1.25f, Shape.SQUARE));
		patterns.add(new Collectible(42f, 12f, .5f, Shape.SQUARE));
		patterns.add(new Collectible(45f, 12f, 1.25f, Shape.SQUARE));
		*/
		
		// another set of bars ========================================
		// 1 ======
		cx = 51f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// another set of bars ====================================
		// 2 ============
		cx = 99f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars ===========================================
		// 3 ========
		cx = 147f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		
		// another set of bars ====================================
		// 4 =========
		cx = 195f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 5 =========
		cx = 243f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// another set of bars =========================================
		// 6 ==========
		cx = 291f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 7 ==============
		cx = 339f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 8 ===============
		cx = 387f;
		// bar 1
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));	
		
		// another set of bars =========================================
		// 9 ==============
		cx = 435f;
		// bar 1
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		
		// another set of bars =========================================
		// 10 ============
		cx = 483f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		// END OF FIRST CHECKPOINT =====================================
		
		// 11 is empty ==============
		
		// another set of bars =========================================
		// 12 =============
		cx = 579f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		
		// another set of bars =========================================
		// 13 =================
		cx = 627f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		
		// another set of bars =========================================
		// 14 ==============
		cx = 675f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 15 ==================
		cx = 723f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 16 =============
		cx = 771f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 17 ===================
		cx = 819f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 18 ======================
		cx = 867f;
		// bar 1
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 19 ======================
		cx = 915f;
		// bar 1
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 20 =================
		cx = 963f;
		// bar 1
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 21 ========================
		cx = 1011f;
		// bar 1
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		// 22 ===================
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 23 ==================
		cx = 1059f;
		// bar 1
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 24 =============
		cx = 1107f;
		// bar 1
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 25 ============
		cx = 1155f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 26 ===================
		cx = 1203f;
		// bar 1
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 28 ================
		cx = 1251f;
		// bar 1
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 29 =============
		cx = 1299f;
		// bar 1
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		
		// another set of bars =========================================
		// 30 ==============
		cx = 1347f;
		// bar 1
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 12f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));

		// another set of bars =========================================
		// 31 ==============
		cx = 1395f;
		// bar 1
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));

		// another set of bars =========================================
		// 32 ==============
		cx = 1443f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		

		// another set of bars =========================================
		// 33 ==============
		cx = 1491f;
		// bar 1
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));

		// another set of bars =========================================
		// 34 ==============
		cx = 1539f;
		// bar 1
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));

		// another set of bars =========================================
		// 35 ==============
		cx = 1587f;
		// bar 1
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 10f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		

		// another set of bars =========================================
		// 36 ==============
		cx = 1635f;
		// bar 1
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 2f, 1.25f, Shape.SQUARE));
		

		// another set of bars =========================================
		// 37 ==============
		cx = 1683f;
		// bar 1
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 4f, 1.25f, Shape.CIRCLE));
		cx += 4.5f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		
		// bar 2
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		cx += 6f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 6f, 1.25f, Shape.SQUARE));
		/*
		cx = 3f;
		patterns.add(new Collectible(3f, 12f, 1.f, Shape.SQUARE));
		patterns.add(new Collectible(6f, 12f, 1.f, Shape.SQUARE));
		patterns.add(new Collectible(7.75f, 12f, .625f, Shape.SQUARE));
		patterns.add(new Collectible(9.725f, 12f, .625f, Shape.SQUARE));
		patterns.add(new Collectible(12f, 12f, 1.f, Shape.SQUARE));

		// bar 2
		patterns.add(new Collectible(15f, 12f, 1.25f, Shape.SQUARE));
		patterns.add(new Collectible(18f, 12f, 1.25f, Shape.SQUARE));
		patterns.add(new Collectible(21f, 12f, 1.25f, Shape.SQUARE));
		patterns.add(new Collectible(22.5f, 12f, .5f, Shape.SQUARE));
		patterns.add(new Collectible(24f, 12f, 1.25f, Shape.SQUARE));
		*/
		
		/*
		// another set of bars ========================================
		cx = 27f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.75f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 2f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 2.25f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// and another set of bars ====================================
		cx = 51f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 1.75f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 2f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 2.25f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		// bar 2
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 3f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.SQUARE));
		cx += 1.5f;
		patterns.add(new Collectible(cx, 8f, 1.25f, Shape.CIRCLE));
		
		/*
		patterns.add(new Collectible(39f, 8f, 1.25f, Shape.CIRCLE));
		patterns.add(new Collectible(45f, 8f, 1.25f, Shape.CIRCLE));
		patterns.add(new Collectible(51f, 8f, 1.25f, Shape.CIRCLE));
		patterns.add(new Collectible(57f, 8f, 1.25f, Shape.CIRCLE));
		
		patterns.add(new Collectible(72f, 12f, 1.f, Shape.SQUARE));
		patterns.add(new Collectible(78f, 9f, 1.f, Shape.SQUARE));
		patterns.add(new Collectible(79.75f, 9f, .625f, Shape.SQUARE));
		patterns.add(new Collectible(81.725f, 12f, .625f, Shape.SQUARE));
		patterns.add(new Collectible(84f, 6f, 1.f, Shape.SQUARE));
		*/
	}
}
