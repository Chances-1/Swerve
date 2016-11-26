package com.chances.api.common.game.properties.enums;

import java.awt.Dimension;

public enum Resolution {

	r800x600(800, 600),
	r1024x720(1024,720),
	rPlayArea(0, 0);
	
	private int windowWidth;
	
	private int windowHeight;
	
	private Dimension dimension;
	
	private Resolution(int windowWidth, int windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		dimension = new Dimension(windowWidth, windowHeight);
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
}
