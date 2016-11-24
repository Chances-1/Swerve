package com.swerve.display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import com.swerve.objects.entity.enemy.Enemy;
import com.swerve.objects.entity.player.PlayerCharacter;
import com.swerve.objects.entity.stars.Starfield;
import com.swerve.properties.Direction;

public class Swerve extends BaseGame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8549395005042709209L;

	private static PlayerCharacter player = null;
	private Starfield starfield = null;
	private List<Enemy> enemies = null;

	// temporary space for controls
	private int xDirection = 0;
	private int yDirection = 0;

	public Swerve() {

		this.setPreferredSize(new Dimension(getWindowWidth(), getWindowHeight()));

		// initialize starfield
		initStarfield();

		// TODO: initialize enemies
		initEnemyFactory();

		// initialize player character
		initPlayerCharacter();

		// initialize game controls
		initKeyboardControls();

		// start the game proper
		initUpdatedEvents();
		initUpdater();
	}

	/**
	 * inits
	 */

	protected void initUpdatedEvents() {

		eventListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentFrame++;
				if (currentFrame == getFPS())
					currentFrame = 0;
				if (null != starfield)
					updateStarfield();
				if (null != player)
					updatePlayerCharacter();
				if (null != enemies)
					updateEnemies();
				repaint();
			}
		};
	}

	private void initPlayerCharacter() {

		player = new PlayerCharacter();
		
		player.setX(100);
		player.setY(getWindowHeight()/2);
		player.setEntityWidth(30);
		player.setEntityHeight(30);
		player.setWindowHeight(getWindowHeight());
		player.setWindowWidth(getWindowWidth());
		// TODO: move closer to source
		player.setEntitySpeed(4);
	}

	private void initStarfield() {
		
		// TODO: change to getter setter arrangement
		starfield = new Starfield(getWindowHeight()*3/2, getWindowWidth()*3/2);
		// TODO: set common flip for argument Direction d
		starfield.setMovementDirection(Direction.WEST);
	}

	private void initEnemyFactory() {

	}

	/**
	 * updates
	 */

	private void updatePlayerCharacter() {
		
		player.setEntityMovementDirection(Direction.getValue(xDirection, yDirection));
		player.update();
	}

	private void updateStarfield() {
		
		starfield.update();
	}

	private void updateEnemies() {

	}

	/**
	 * draws
	 */

	private void drawPlayerCharacter(Graphics2D g2d) {

		player.draw(g2d);
	}

	private void drawStarfield(Graphics2D g2d) {

		starfield.draw(g2d, this);
	}

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
				case KeyEvent.VK_SPACE:
					player.setIsFiring(false);
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
				case KeyEvent.VK_SPACE:
					player.setIsFiring(true);
					break;
				default:
					break;
				}
			}
		};

		this.addKeyListener(keyboardControls);
	}
}
