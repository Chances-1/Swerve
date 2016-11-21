package com.swerve.objects.entity.bullet;

import java.awt.Color;
import java.awt.Graphics2D;

import com.swerve.objects.entity.BaseRectEntity;
import com.swerve.properties.Direction;

public class Bullet extends BaseRectEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2854793086054089058L;

	// defaults
	private int defaultSize = 3;
	private int defaultSpeed = 6;
	
	private Color defaultColor = Color.BLUE;
	
	public Bullet(int x, int y, int windowWidth, int windowHeight){
		super(windowWidth, windowHeight);
		this.x = x;
		this.y = y;
		this.width = defaultSize;
		this.height = defaultSize;
	}
	
	public void move(Direction d) {
		
		x += d.getxDirection()*defaultSpeed;
		y += d.getyDirection()*defaultSpeed;
		
		
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(defaultColor);
		g2d.fill(this);
	}
	
	public boolean isOutOfBounds(){
		if(x > windowWidth || x < 0 || y < 0 || y > windowWidth){
			return true;
		}
		return false;
	}
	
	

}
