package com.swerve.display;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import com.chances.api.common.game.BaseGame;
import com.chances.api.common.game.properties.constants.GameConstants;
import com.chances.api.common.game.properties.enums.Direction;
import com.chances.api.common.game.properties.enums.Resolution;
import com.swerve.objects.entity.enemy.Enemy;
import com.swerve.objects.entity.player.PlayerCharacter;
import com.swerve.objects.entity.stars.Starfield;

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

	}
	
	/**
	 * Overrides
	 */

	@Override
	public void update() {

		setCurrentFrame(getCurrentFrame()+1);;
		if (getCurrentFrame() == getFPS()) {
			setCurrentFrame(0);
		}
		if (null != starfield)
			updateStarfield();
		if (null != player)
			updatePlayerCharacter();
		if (null != enemies)
			updateEnemies();
		updateResolution();
		repaint();
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
	 * Initializers
	 */

	private void initPlayerCharacter() {

		player = new PlayerCharacter();

		player.setX(100);
		player.setY(getWindowHeight() / 2);
		player.setEntityWidth(30);
		player.setEntityHeight(30);
		// TODO: move closer to source
		player.setEntitySpeed(4);
	}

	private void initStarfield() {

		// TODO: change to getter setter arrangement
		starfield = new Starfield(getWindowHeight() * 3 / 2, getWindowWidth() * 3 / 2);
		// TODO: set common flip for argument Direction d
		starfield.setMovementDirection(Direction.WEST);
	}

	private void initEnemyFactory() {

	}
	
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
				case KeyEvent.VK_N:
					setGameResolution(Resolution.r800x600);
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
				case KeyEvent.VK_N:
					setGameResolution(Resolution.r1024x720);
					break;
				default:
					break;
				}
			}
		};

		this.addKeyListener(keyboardControls);
	}

	/**
	 * Updates
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
	 * Draws
	 */

	private void drawPlayerCharacter(Graphics2D g2d) {

		player.draw(g2d);
	}

	private void drawStarfield(Graphics2D g2d) {

		starfield.draw(g2d, this);
	}

	private void drawEnemies(){
		
	}

}
