package com.swerve.main;

import javax.swing.Timer;

import com.chances_Api.common.game.frame.BaseGameFrame;
import com.swerve.display.Swerve;

public class MainClass {
	
	public static Swerve swervePanel = new Swerve();
	
	public static void main(String[] args) {
		
		BaseGameFrame gf = new BaseGameFrame("Swerve", swervePanel);
		Timer mainTimer = gf.getTimer();
		mainTimer.start();
	}

}
