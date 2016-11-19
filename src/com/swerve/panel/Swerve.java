package com.swerve.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import com.swerve.objects.player.PlayerCharacter;
import com.swerve.objects.stars.Starfield;
import com.swerve.properties.Direction;

public class Swerve extends BaseGame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8549395005042709209L;

	private PlayerCharacter player;
	private Starfield starfield;

	// temporary space for controls
	private int xDirection = 0;
	private int yDirection = 0;

	public Swerve() {

		this.setPreferredSize(new Dimension(windowWidth, windowHeight));

		// initialize starfield
		initStarfield();

		// TODO: initialize enemyFactory;

		// initialize player character
		// initPlayerCharacter();

		// initialize game controls
		initKeyboardControls();

		// start the game proper
		initEventListener();
		initTimer();
	}

	/**
	 * Timer Control
	 */

	private void initEventListener() {

		eventListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentFrame++;
				if (currentFrame == 60)
					currentFrame = 0;
				if (null != starfield)
					updateStarfield();
				if (null != player)
					updatePlayerCharacter();
				repaint();
			}
		};
	}

	private void initTimer() {
		fpsTimer.setDelay(msPerFrame);
		fpsTimer.addActionListener(eventListener);
		fpsTimer.start();
	}

	/**
	 * Background methods
	 */

	private void drawBackground(Graphics2D g2d) {
		this.setBackground(Color.BLACK);
	}

	/**
	 * Player methods
	 */

	private void initPlayerCharacter() {

		player = new PlayerCharacter(windowWidth / 2, windowHeight / 2, 30, 30, windowWidth, windowHeight);
	}

	private void updatePlayerCharacter() {

		player.updatePlayerCharacter(Direction.getValue(xDirection, yDirection));
	}

	private void drawPlayerCharacter(Graphics2D g2d) {

		player.drawPlayerCharacter(g2d);
	}

	/**
	 * Starfield methods
	 */

	private void initStarfield() {

		starfield = new Starfield(windowWidth, windowHeight);
	}

	private void updateStarfield() {

		starfield.updateStarfield(Direction.getFlipValue(xDirection, yDirection));
	}

	private void drawStarfield(Graphics2D g2d) {

		drawBackground(g2d);
		starfield.drawStarfield(g2d);
	}

	/**
	 * Overrides
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		if (null != starfield)
			drawStarfield(g2d);
		if (null != player)
			drawPlayerCharacter(g2d);
	}

	/**
	 * Keyboard Controls
	 */

	private void initKeyboardControls() {

		this.setFocusable(true); // set to make sure panel is focused (needed
									// for keyboard controls)
		keyboardControls = new KeyListener() {

			@Deprecated
			@Override
			public void keyTyped(KeyEvent e) {
				// unimplemented
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					xDirection = 0;
					break;
				case KeyEvent.VK_RIGHT:
					xDirection = 0;
					break;
				case KeyEvent.VK_UP:
					yDirection = 0;
					break;
				case KeyEvent.VK_DOWN:
					yDirection = 0;
					break;
				default:
					break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					xDirection = -1;
					break;
				case KeyEvent.VK_RIGHT:
					xDirection = 1;
					break;
				case KeyEvent.VK_UP:
					yDirection = -1;
					break;
				case KeyEvent.VK_DOWN:
					yDirection = 1;
					break;
				default:
					break;
				}
			}
		};

		this.addKeyListener(keyboardControls);
	}
}
