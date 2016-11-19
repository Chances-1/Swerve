package com.swerve.display;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BaseGame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8474399743857802104L;

	// Utility Variables
	Random rand = new Random();

	// Basic variables
	protected int windowHeight = 600;
	protected int windowWidth = 800;

	// FPS and timer Variables
	protected int FPS = 60;
	protected int currentFrame = 0;
	protected int msPerFrame = 1000 / FPS;
	protected Timer fpsTimer = new Timer(msPerFrame, null);
	
	// Listeners
	protected ActionListener eventListener; // init in your game
	protected KeyListener keyboardControls; // init in your game

}
