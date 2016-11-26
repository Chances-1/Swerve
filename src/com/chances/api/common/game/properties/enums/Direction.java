package com.chances.api.common.game.properties.enums;

import java.util.ArrayList;
import java.util.List;

public enum Direction{
	
	NORTH(0, -1),
	SOUTH(0, 1),
	EAST(1, 0),
	WEST(-1, 0),
	NORTHEAST(1, -1),
	NORTHWEST(-1, -1),
	SOUTHEAST(1, 1),
	SOUTHWEST(-1, 1),
	STILL(0,0);
	
	private int xDirection;
	
	private int yDirection;
	
	Direction(int xDirection, int yDirection){
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}
	
	public static Direction getValue(int xDirection, int yDirection){
		List<Direction> ls = new ArrayList<Direction>();
		for(Direction d: values()){
			if(d.getxDirection() == xDirection)ls.add(d);
		}
		for(Direction d: ls){
			if(d.getyDirection() == yDirection)return d;
		}
		// worse case
		return null;
	}
	
	public static Direction getFlipValue(int xDirection, int yDirection){
		xDirection*=-1;yDirection*=-1;
		return getValue(xDirection, yDirection);
	}

	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}

}
