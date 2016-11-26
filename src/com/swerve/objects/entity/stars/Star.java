package com.swerve.objects.entity.stars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.chances.api.common.game.entity.entities.BaseRectEntity;
import com.chances.api.common.utils.RNG;

public class Star extends BaseRectEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3388108298828893134L;

	// min/max size
	private int minSize = 1;
	private int maxSize = 2;

	private int defaultLowerSpeed = 2;
	private int defaultUpperSpeed = 10;

	public Star(int x, int y) {
		super();
		setEntityHeight(RNG.selectRandomNumber(minSize, maxSize));
		setEntityWidth(getEntityHeight());
		this.setBounds(x, y, getEntityWidth(), getEntityHeight());
		this.entitySpeed = RNG.selectRandomNumber(defaultLowerSpeed, defaultUpperSpeed);
	}
	
	public Star(int x, int y, int minSize, int maxSize) {
		super();
		setEntityHeight(RNG.selectRandomNumber(minSize, maxSize));
		setEntityWidth(getEntityHeight());
		this.setBounds(x, y, getEntityWidth(), getEntityHeight());
		this.entitySpeed = RNG.selectRandomNumber(defaultLowerSpeed, defaultUpperSpeed);
	}

	public Star(int x, int y, int entitySpeed) {
		super();
		setEntityHeight(RNG.selectRandomNumber(minSize, maxSize));
		setEntityWidth(getEntityHeight());
		this.setBounds(x, y, getEntityWidth(), getEntityHeight());
		this.entitySpeed = entitySpeed;
	}
	
	public void update(){
		move();
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

}
