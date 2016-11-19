package com.swerve.objects.player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.swerve.objects.BaseEntity;
import com.swerve.properties.Direction;

public class PlayerCharacter extends BaseEntity{
	
	private int speed = 3;
	
	/**
	 * Construction
	 */
	
	public PlayerCharacter(int x, int y, int width, int height, int windowWidth, int windowHeight){
		super(windowWidth, windowHeight);
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Updating and drawing
	 */
	
	public void updatePlayerCharacter(Direction d){
		move(d);
	}
	
	public void drawPlayerCharacter(Graphics2D g2d){
		g2d.setColor(Color.ORANGE);
		g2d.fill(this);
	}
	
	/**
	 * movement and speed
	 */
	
	private void move(Direction d){
		this.x += this.speed*d.getxDirection();
		this.y += this.speed*d.getyDirection();
		
		// set bounds
		if(x < 0)x = 0;
		if(y < 0)y = 0;
		
		if(x+width > windowWidth)x = windowWidth-width;
		if(y+height > windowHeight)y = windowHeight-height;
	}
}
