package com.swerve.display;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class BaseGame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8474399743857802104L;

	// Utility Variables
	Random rand = new Random();

	// Basic variables
	public static int windowHeight = 600;
	public static int windowWidth = 800;

	// FPS and timer Variables
	private int FPS = 60;
	protected int currentFrame = 0;
	protected int msPerFrame = 1000 / FPS;
	protected Timer fpsTimer = new Timer(msPerFrame, null);
	
	// Listeners
	protected ActionListener eventListener; // init in your game
	protected KeyListener keyboardControls; // init in your game
	
	protected abstract void initUpdatedEvents();
	
	protected void initUpdater() {
		fpsTimer.setDelay(msPerFrame);
		fpsTimer.addActionListener(eventListener);
		fpsTimer.start();
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

	public ActionListener getEventListener() {
		return eventListener;
	}

	public KeyListener getKeyboardControls() {
		return keyboardControls;
	}
	
	

}
