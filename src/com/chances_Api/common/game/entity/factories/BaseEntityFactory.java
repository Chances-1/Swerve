package com.chances_Api.common.game.entity.factories;

import java.util.List;

import com.chances_Api.common.game.entity.entities.BaseRectEntity;

public abstract class BaseEntityFactory<T extends BaseRectEntity>{
	
	private int windowWidth;
	
	private int windowHeight;
	
	protected BaseEntityFactory() {
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
