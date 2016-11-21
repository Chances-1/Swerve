package com.swerve.objects.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class BaseRectEntity extends Rectangle {

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
	 * Generic Constructor
	 */
	
	// nothing
	protected BaseRectEntity(){
		
	}
	
	// no image
	protected BaseRectEntity(int windowWidth, int windowHeight){
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}

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
	
	

}
