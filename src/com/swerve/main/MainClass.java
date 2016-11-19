package com.swerve.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.swerve.display.Swerve;

public class MainClass {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Swerve");
		Swerve swerve = new Swerve();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add((JPanel)swerve, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

}
