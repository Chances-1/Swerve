package com.swerve.objects.entity.enemy;

import java.awt.Color;

import com.swerve.objects.entity.BaseRectEntity;
import com.swerve.properties.Direction;

public class Enemy extends BaseRectEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5743749154513790285L;

	private Color defaultColour = Color.RED;

	public Enemy(int windowWidth, int windowHeight) {
		
		super(windowWidth, windowHeight);
	}

	public Enemy(int windowWidth, int windowHeight, int defaultHeight, int defaultWidth, int defaultSpeed,
			Color defaultColour) {
		
		super(windowWidth, windowHeight);
		setEntityHeight(defaultHeight);
		setEntityWidth(defaultWidth);
		setEntitySpeed(entitySpeed);
		this.entitySpeed = defaultSpeed;
		this.defaultColour = defaultColour;
	}
	
	@Override
	public void update(){
		move();
	}
	
}
