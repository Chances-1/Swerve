package com.swerve.objects.entity.stars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.swerve.objects.entity.BaseEntity;
import com.swerve.utils.RNG;

public class Star extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3388108298828893134L;

	// min/max size
	private int minSize = 1;
	private int maxSize = 2;

	// speed of star (default 1)
	private int speed = 5;

	/**
	 * Getters and Setters
	 */

	public Star(int x, int y) {
		super();
		int size = (RNG.randomNumber(minSize, maxSize));
		this.setBounds(x, y, size, size);
	}

	public Star(int x, int y, int speed) {
		super();
		int size = (RNG.randomNumber(minSize, maxSize));
		this.setBounds(x, y, size, size);
		this.speed = speed;
	}
	
	public void drawStar(Graphics2D g2d){
		
		g2d.setColor(Color.WHITE);
		g2d.fill(this);
	}

	public int getMinSize() {
		return minSize;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}


}
