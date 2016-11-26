package com.chances.api.common.game.entity.entities;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.chances.api.common.game.properties.constants.GameConstants;
import com.chances.api.common.game.properties.enums.Direction;

public abstract class BaseRectEntity extends Rectangle {

	// base variables for all entities

	/**
	 * 
	 */
	private static final long serialVersionUID = -7680914049413903008L;

	private BufferedImage spritesheet;

	private int currentSpriteFrame;

	/**
	 * Entity Variables
	 */

	protected int entitySpeed;

	protected Direction entityMovementDirection = Direction.WEST;
	
	protected Color entityColor;

	/**
	 * Generic Constructor
	 */

	// nothing
	protected BaseRectEntity() {

	}
	
	/**
	 * Default Methods
	 */
	
	protected void move(){
		// default implementation for move
		this.x += entitySpeed*entityMovementDirection.getxDirection();
		this.y += entitySpeed*entityMovementDirection.getyDirection();
	}
	
	public void stopCrossBorder(){
		// set bounds
		if (crossedWestBorder())
			stopAtWestBorder();
		if (crossedNorthBorder())
			stopAtNorthBorder();

		if (crossedEastBorder())
			stopAtEastBorder();
		if (crossedSouthBorder())
			stopAtSouthBorder();
	}
	
	public boolean isVisible() {
		if (this.x > GameConstants.gameResolution.getWindowWidth() || 				// right border
				(this.x + getEntityWidth()) < 0 || 	// left border
				this.y > GameConstants.gameResolution.getWindowHeight() || 			// bottom
				(this.y + getEntityHeight()) < 0) 	// upper
			return false;
		return true;
	}
	
	
	public boolean crossedWestBorder(){
		return x < 0;
	}

	public boolean crossedEastBorder(){
		return (x + width) > GameConstants.gameResolution.getWindowWidth();
	}
	
	public boolean crossedNorthBorder(){
		return y < 0;
	}
	
	public boolean crossedSouthBorder(){
		return y + height > GameConstants.gameResolution.getWindowHeight();
	}
	
	
	public void stopAtWestBorder(){
		x = 0;
	}
	public void stopAtEastBorder(){
		x = GameConstants.gameResolution.getWindowWidth() - width;
	}
	public void stopAtNorthBorder(){
		y = 0;
	}
	public void stopAtSouthBorder(){
		y = GameConstants.gameResolution.getWindowHeight() - height;
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

	public void setSpritesheet(BufferedImage spritesheet) {
		this.spritesheet = spritesheet;
	}

	public void setCurrentSpriteFrame(int currentSpriteFrame) {
		this.currentSpriteFrame = currentSpriteFrame;
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

	public Color getEntityColor() {
		return entityColor;
	}

	public void setEntityColor(Color entityColor) {
		this.entityColor = entityColor;
	}

}
