package com.swerve.objects.entity.enemy;

import java.awt.Color;

import com.chances_Api.common.game.entity.entities.BaseRectEntity;
import com.chances_Api.common.game.properties.enums.Direction;

public class Enemy extends BaseRectEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5743749154513790285L;

	public Enemy(){
		
	}
	
	@Override
	public void update(){
		move();
	}
	
}
