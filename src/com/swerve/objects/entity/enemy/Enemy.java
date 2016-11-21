package com.swerve.objects.entity.enemy;

import java.awt.Color;

import com.swerve.objects.entity.BaseRectEntity;
import com.swerve.properties.Direction;

public class Enemy extends BaseRectEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5743749154513790285L;

	private int defaultHeight = 8;
	private int defaultWidth = 8;

	private int defaultSpeed = 5;
	
	private Direction currentDirection;

	private Color defaultColour = Color.BLUE;

	public Enemy(int windowWidth, int windowHeight) {
		
		super(windowWidth, windowHeight);
	}

	public Enemy(int windowWidth, int windowHeight, int defaultHeight, int defaultWidth, int defaultSpeed,
			Color defaultColour) {
		
		super(windowWidth, windowHeight);
		this.defaultHeight = defaultHeight;
		this.defaultWidth = defaultWidth;
		this.defaultSpeed = defaultSpeed;
		this.defaultColour = defaultColour;
	}
}
