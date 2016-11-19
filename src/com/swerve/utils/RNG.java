package com.swerve.utils;

import java.util.Random;

public class RNG {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2784500293628717074L;

	private static Random rand = new Random();

	public static int randomNumber(int upper_limit) {
		return rand.nextInt(upper_limit);
	}

	public static int randomNumber(int lower_limit, int upper_limit) {
		return lower_limit + rand.nextInt(upper_limit-lower_limit+1);
	}
}
