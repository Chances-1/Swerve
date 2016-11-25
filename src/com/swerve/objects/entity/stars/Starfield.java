package com.swerve.objects.entity.stars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.chances_Api.common.game.properties.enums.Direction;
import com.chances_Api.common.utils.RNG;

public class Starfield {

	private int numberOfStars = 400;

	private int fieldHeight = 600;

	private int fieldWidth = 800;

	ArrayList<Star> starfield = new ArrayList<Star>();

	private int speedLower = 4;

	private int speedUpper = 10;
	
	private Direction movementDirection;
	
	public Starfield(){
		
		populate_starfield();
	}
	
	public Starfield(int fieldHeight, int fieldWidth) {
		
		super();
		this.fieldHeight = fieldHeight;
		this.fieldWidth = fieldWidth;
		populate_starfield();
	}

	/**
	 * Private Methods
	 */

	private void populate_starfield() {

		for (int i = 0; i < numberOfStars; i++) {
			Star s = new Star(RNG.selectRandomNumber(fieldWidth), RNG.selectRandomNumber(fieldHeight));
			starfield.add(s);
		}
	}

	/**
	 * Accessible Methods
	 */

	public void draw(Graphics2D g2d, JPanel panel) {
		
		panel.setBackground(Color.BLACK);
		for (Star s : getStarfield()) {
			s.drawStar(g2d);
		}
	}

	public void update() {
		
		for (Star s : starfield) {

			s.setEntityMovementDirection(movementDirection);
			
			s.update();

			// x changes
			if (s.x > fieldWidth) {
				s.x = 0;
				s.y = RNG.selectRandomNumber(fieldHeight);
				s.setEntitySpeed(RNG.selectRandomNumber(speedLower, speedUpper));
			}
			if (s.x < 0) {
				s.x = fieldWidth;
				s.y = RNG.selectRandomNumber(fieldHeight);
				s.setEntitySpeed(RNG.selectRandomNumber(speedLower, speedUpper));
			}

			// y changes
			if (s.y > fieldHeight) {
				s.x = RNG.selectRandomNumber(fieldWidth);
				s.y = 0;
				s.setEntitySpeed(RNG.selectRandomNumber(speedLower, speedUpper));
			}
			if (s.y < 0) {
				s.x = RNG.selectRandomNumber(fieldWidth);
				s.y = fieldHeight;
				s.setEntitySpeed(RNG.selectRandomNumber(speedLower, speedUpper));
			}
		}
	}

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

	public Direction getMovementDirection() {
		return movementDirection;
	}

	public void setMovementDirection(Direction movementDirection) {
		this.movementDirection = movementDirection;
	}
}
