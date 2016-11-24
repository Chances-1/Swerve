package com.swerve.objects.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.swerve.properties.Direction;

public abstract class BaseRectEntity extends Rectangle {

	// base variables for all entities

	/**
	 * 
	 */
	private static final long serialVersionUID = -7680914049413903008L;

	private BufferedImage spritesheet;

	private int currentSpriteFrame;

	protected int windowWidth;

	protected int windowHeight;

	/**
	 * Entity Variables
	 */

	protected int entitySpeed;

	protected Direction entityMovementDirection = Direction.WEST;

	/**
	 * Generic Constructor
	 */

	// nothing
	protected BaseRectEntity() {

	}

	// no image
	protected BaseRectEntity(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	
	/**
	 * Default Methods
	 */
	
	protected void move(){
		// default implementation for move
		this.x += entitySpeed*entityMovementDirection.getxDirection();
		this.y += entitySpeed*entityMovementDirection.getyDirection();
	}

	public boolean isVisible() {
		if (this.x > windowWidth || 				// right border
				(this.x + getEntityWidth()) < 0 || 	// left border
				this.y > windowHeight || 			// bottom
				(this.y + getEntityHeight()) < 0) 	// upper
			return false;
		return true;
	}
	
	/**
	 * Abstract Methods that SHOULD be overriden
	 */
	
	public abstract void update();
	
	/**
	 * Getters and Setters
	 */

	public BufferedImage getSpritesheet() {
		return spritesheet;
	}

	public int getCurrentSpriteFrame() {
		return currentSpriteFrame;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setSpritesheet(BufferedImage spritesheet) {
		this.spritesheet = spritesheet;
	}

	public void setCurrentSpriteFrame(int currentSpriteFrame) {
		this.currentSpriteFrame = currentSpriteFrame;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public int getEntityHeight() {
		return height;
	}

	public void setEntityHeight(int entityHeight) {
		this.height = entityHeight;
	}

	public int getEntityWidth() {
		return width;
	}

	public void setEntityWidth(int entityWidth) {
		this.width = entityWidth;
	}

	public int getEntitySpeed() {
		return entitySpeed;
	}

	public void setEntitySpeed(int entitySpeed) {
		this.entitySpeed = entitySpeed;
	}

	public Direction getEntityMovementDirection() {
		return entityMovementDirection;
	}

	public void setEntityMovementDirection(Direction entityMovementDirection) {
		this.entityMovementDirection = entityMovementDirection;
	}
	
	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

}
