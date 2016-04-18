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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;
import com.wordpress.shapeshiftdance.Assets;

public class AudioController {
	float bpm = 120.0f;
	
	Music currentTheme;
	Sound rollback;
	
	public AudioController() {		
		rollback = Gdx.audio.newSound(Gdx.files.internal("scratch_back.wav"));
		currentTheme = Assets.inst.get(Assets.MAIN_THEME);
		currentTheme.setVolume(1f);
		if (!isPlaying()) {
			play();
		}
	}

	public void dispose() {
		currentTheme.dispose();
		rollback.dispose();
	}
	
	public void play() {
		currentTheme.play();
	}
	
	public void pause() {
		currentTheme.pause();
	}
	
	public boolean isPlaying() {
		return currentTheme.isPlaying();
	}
	
	float maxAudioValue = 0f;
	float previousMaxAudioValue = 0f;
	
	public float getPreviousPeakAudioValue() {
		return previousMaxAudioValue;
	}
	
	public float getPeakAudioValue() {
		return maxAudioValue;
	}
	
	public float getCurrentTime() {
		return currentTheme.getPosition();
	}
	
	public void returnToCheckPoint(float seconds) {
		goalSeconds = seconds;
		subBeatSeconds = seconds -.75f;
		subBeatOffset = true;
		rollback.play();
		currentTheme.setVolume(1f);
	}
	
	private void setThemePosition(float seconds) {
		currentTheme.setPosition(seconds);
	}
	
	float goalSeconds = 0f;
	float subBeatSeconds = -.75f;
	boolean subBeatOffset = true;
	boolean breakdown = false;
	
	public void rewind(float stateTime, float rewindSeconds) {
		float s = currentTheme.getPosition();
		s = MathUtils.lerp(s, rewindSeconds, stateTime);
		System.out.println(s + " - " + rewindSeconds);
		currentTheme.setPosition(s);
	}
	
	public void setPosition(float time) {
		setThemePosition(time);
	}
	
	public void update() {
		// notGoodEnough();
		previousMaxAudioValue = maxAudioValue;
		maxAudioValue = MathUtils.lerp(maxAudioValue, 0.5f, .2f);
		
		if (currentTheme.getVolume() < 1f) {
			currentTheme.setVolume(currentTheme.getVolume() + .02f);
		}
		
		float s = currentTheme.getPosition();
		if (s > goalSeconds) {
			goalSeconds += .5f;
			
			if (!breakdown) { maxAudioValue = 1f; }
		}
		if (s > subBeatSeconds) {
			subBeatSeconds += subBeatOffset ? 1.875f : 2.125f;
			subBeatOffset = !subBeatOffset;
			if (!breakdown) { maxAudioValue = 1f; }
		}
	}
	/*
	private void notGoodEnough() {
		int readSamples = 0;

		// read until we reach the end of the file
		if (playing
				&& (readSamples = decoder.readSamples(samples, 0,
						samples.length)) > 0) {
			// get audio spectrum
			fft.spectrum(samples, spectrum);
			// write the samples to the AudioDevice
			device.writeSamples(samples, 0, readSamples);
			System.out.println("x");
		}
		maxAudioValue = 0;
		for (int i = 0; i < NB_BARS; i++) {
			int histoX = 0;
			if (i < NB_BARS / 2) {
				histoX = NB_BARS / 2 - i;
			} else {
				histoX = i - NB_BARS / 2;
			}

			int nb = (samples.length / NB_BARS) / 2;
			if (avg(histoX, nb) > maxValues[histoX]) {
				maxValues[histoX] = avg(histoX, nb);
			}

			if (avg(histoX, nb) > topValues[histoX]) {
				topValues[histoX] = avg(histoX, nb);
			}
			
			topValues[histoX] -= FALLING_SPEED;
			if (avg(histoX, nb) > maxAudioValue) {
				maxAudioValue = avg(histoX, nb);
			}
		}
	}

	private float avg(int pos, int nb) {
		int sum = 0;
		for (int i = 0; i < nb; i++) {
			sum += spectrum[pos + i];
		}

		return (float) (sum / nb);
	}
	*/
}
