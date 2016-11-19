package com.swerve.objects.entity.enemy;

import java.awt.Color;

import com.swerve.objects.entity.BaseEntity;

public class Enemy extends BaseEntity{
	
	private int defaultHeight = 8;
	private int defaultWidth = 8;
	
	private int defaultSpeed = 5;
	
	private Color defaultColour = Color.BLUE;
	
	public Enemy(int windowHeight, int windowWidth){
		super(windowHeight, windowWidth);
		
	}
}
