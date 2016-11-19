package com.swerve.common;

import java.util.List;

import com.swerve.objects.entity.BaseEntity;

public abstract class BaseEntityFactory<T extends BaseEntity>{
	
	private int windowWidth;
	
	private int windowHeight;
	
	protected BaseEntityFactory(int windowWidth, int windowHeight) {
		super();
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}

	protected abstract T create();
	
	protected abstract List<T> createList(int size);

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
}
