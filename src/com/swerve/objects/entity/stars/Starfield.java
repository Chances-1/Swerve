package com.swerve.objects.entity.stars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.swerve.properties.Direction;
import com.swerve.utils.RNG;

public class Starfield {

	private int numberOfStars = 400;

	private int fieldHeight = 600;

	private int fieldWidth = 800;

	ArrayList<Star> starfield = new ArrayList<Star>();

	private int speedLower = 4;

	private int speedUpper = 10;

	public Starfield(int width, int height) {
		// note: to maintain persistence of star locations for at least half the
		// screen size. This will result is a sparser looking starfield...
		fieldWidth = width * 3 / 2;
		fieldHeight = height * 3 / 2;
		populate_starfield();
	}

	/**
	 * Private Methods
	 */

	private void populate_starfield() {

		for (int i = 0; i < numberOfStars; i++) {
			starfield.add(new Star(RNG.randomNumber(fieldWidth), RNG.randomNumber(fieldHeight),
					RNG.randomNumber(speedLower, speedUpper)));
		}
	}

	/**
	 * Accessible Methods
	 */

	public void drawStarfield(Graphics2D g2d, JPanel panel) {
		panel.setBackground(Color.BLACK);
		for (Star s : getStarfield()) {
			s.drawStar(g2d);
		}

	}

	public void updateStarfield(Direction d) {

		for (Star s : starfield) {

			// update the position based on speed
			s.x += s.getSpeed() * d.getxDirection();
			s.y += s.getSpeed() * d.getyDirection();

			// x changes
			if (s.x > fieldWidth) {
				s.x = 0;
				s.y = RNG.randomNumber(fieldHeight);
				s.setSpeed(RNG.randomNumber(speedLower, speedUpper));
			}
			if (s.x < 0) {
				s.x = fieldWidth;
				s.y = RNG.randomNumber(fieldHeight);
				s.setSpeed(RNG.randomNumber(speedLower, speedUpper));
			}

			// y changes
			if (s.y > fieldHeight) {
				s.x = RNG.randomNumber(fieldWidth);
				s.y = 0;
				s.setSpeed(RNG.randomNumber(speedLower, speedUpper));
			}
			if (s.y < 0) {
				s.x = RNG.randomNumber(fieldWidth);
				s.y = fieldHeight;
				s.setSpeed(RNG.randomNumber(speedLower, speedUpper));
			}
		}
	}

	/*
	 * =========================================
	 * =========================================
	 */

	/**
	 * Getters and Setters
	 */

	public int getNumberOfStars() {
		return numberOfStars;
	}

	public void setNumberOfStars(int numberOfStars) {
		this.numberOfStars = numberOfStars;
		populate_starfield();
	}

	public int getFieldHeight() {
		return fieldHeight;
	}

	public void setFieldHeight(int field_height) {
		this.fieldHeight = field_height;
	}

	public int getFieldWidth() {
		return fieldWidth;
	}

	public void setFieldWidth(int field_width) {
		this.fieldWidth = field_width;
	}

	public ArrayList<Star> getStarfield() {
		return starfield;
	}

	public void setStarfield(ArrayList<Star> starfield) {
		this.starfield = starfield;
	}

	public int getSpeedLower() {
		return speedLower;
	}

	public void setSpeedLower(int speedLower) {
		this.speedLower = speedLower;
	}

	public int getSpeedUpper() {
		return speedUpper;
	}

	public void setSpeedUpper(int speedUpper) {
		this.speedUpper = speedUpper;
	}
}
