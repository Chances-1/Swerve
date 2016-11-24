package com.swerve.objects.entity.bullet;

import java.awt.Color;
import java.awt.Graphics2D;

import com.swerve.objects.entity.BaseRectEntity;
import com.swerve.properties.Direction;

public class Bullet extends BaseRectEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2854793086054089058L;

	// defaults
	private int defaultSize = 3;

	private int defaultSpeed = 6;

	private Color defaultColor = Color.BLUE;

	// moving to empty constructor
	public Bullet() {
		setEntityHeight(defaultSize);
		setEntityWidth(defaultSize);
		entitySpeed = defaultSpeed;
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(defaultColor);
		g2d.fill(this);
	}

	@Override
	public void update() {
		move();
	}

	/**
	 * GS
	 */

	public int getDefaultSize() {
		return defaultSize;
	}

	public void setDefaultSize(int defaultSize) {
		this.defaultSize = defaultSize;
	}

	public int getDefaultSpeed() {
		return defaultSpeed;
	}

	public void setDefaultSpeed(int defaultSpeed) {
		this.defaultSpeed = defaultSpeed;
	}

	public Color getDefaultColor() {
		return defaultColor;
	}

	public void setDefaultColor(Color defaultColor) {
		this.defaultColor = defaultColor;
	}

	public String toDebugString() {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("X position:" + getX());
		stringBuffer.append(", ");
		stringBuffer.append("Y position:" + getY());
		stringBuffer.append(", ");
		stringBuffer.append("Width:" + getEntityWidth());
		stringBuffer.append(", ");
		stringBuffer.append("Height:" + getEntityHeight());
		// stringBuffer.append(", ");

		return stringBuffer.toString();

	}

}
