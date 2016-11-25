package com.chances_Api.common.game;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.chances_Api.common.game.properties.constants.GameConstants;
import com.chances_Api.common.game.properties.enums.Resolution;

public abstract class BaseGame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8474399743857802104L;

	// Utility Variables
	Random rand = new Random();

	// Basic variables
	private static int windowHeight = 600;
	private static int windowWidth = 800;

	// FPS and timer Variables
	private int FPS = 60;
	protected int currentFrame = 0;
	protected int msPerFrame = 1000 / FPS;
	protected Timer fpsTimer = new Timer(msPerFrame, null);
	private Resolution gameResolution = GameConstants.gameResolution;

	// Listeners
	// protected ActionListener eventListener; // init in your game
	protected KeyListener keyboardControls; // init in your game

	public abstract void update();

	// protected void initUpdater() {
	// fpsTimer.setDelay(msPerFrame);
	// fpsTimer.addActionListener(eventListener);
	// fpsTimer.start();
	// }

	public void updateResolution() {
		GameConstants.gameResolution = gameResolution;
		setPreferredSize(gameResolution.getDimension());
		this.revalidate();
	}

	public Random getRand() {
		return rand;
	}

	public static int getWindowHeight() {
		return windowHeight;
	}

	public static int getWindowWidth() {
		return windowWidth;
	}

	public int getFPS() {
		return FPS;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public int getMsPerFrame() {
		return msPerFrame;
	}

	public Timer getFpsTimer() {
		return fpsTimer;
	}

	public KeyListener getKeyboardControls() {
		return keyboardControls;
	}

	public Resolution getGameResolution() {
		return gameResolution;
	}

	public void setGameResolution(Resolution gameResolution) {
		this.gameResolution = gameResolution;
	}

}
