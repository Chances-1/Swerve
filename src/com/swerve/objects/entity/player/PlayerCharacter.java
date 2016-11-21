package com.swerve.objects.entity.player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.swerve.objects.entity.BaseRectEntity;
import com.swerve.objects.entity.bullet.Bullet;
import com.swerve.properties.Direction;

public class PlayerCharacter extends BaseRectEntity {

	private int speed = 3;

	private ArrayList<Bullet> bullets;

	private int currentCooldown = 0;
	
	private int cooldown = 10;
	
	private int maxBullets = 20;

	/**
	 * Construction
	 */

	public PlayerCharacter(int x, int y, int width, int height, int windowWidth, int windowHeight) {
		super(windowWidth, windowHeight);

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.bullets = new ArrayList<Bullet>();
	}

	/**
	 * Updating and drawing
	 */

	public void updatePlayerCharacter(Direction d) {
		movePlayer(d);
		moveBullets();
		if (currentCooldown > 0) {
			currentCooldown--;
		}
	}

	public void draw(Graphics2D g2d) {
		drawPlayerCharacter(g2d);
		drawBullets(g2d);
	}

	private void drawPlayerCharacter(Graphics2D g2d) {
		g2d.setColor(Color.ORANGE);
		g2d.fill(this);
	}

	private void drawBullets(Graphics2D g2d) {
		for (Bullet b : bullets) {
			b.draw(g2d);
		}
	}

	public void fireBullet() {
		if (bullets.size() < maxBullets && currentCooldown == 0) {
			bullets.add(new Bullet((int) (this.getX() + this.getWidth()), (int) this.getCenterY(), windowWidth,
					windowHeight));
			currentCooldown = cooldown;
		}
	}

	/**
	 * movement and speed
	 */

	private void movePlayer(Direction d) {
		this.x += this.speed * d.getxDirection();
		this.y += this.speed * d.getyDirection();

		// set bounds
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;

		if (x + width > windowWidth)
			x = windowWidth - width;
		if (y + height > windowHeight)
			y = windowHeight - height;
	}

	private void moveBullets() {
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).move(Direction.EAST);
			if (bullets.get(i).isOutOfBounds()) {
				bullets.remove(i);
				i--;
			}
		}
	}

}
