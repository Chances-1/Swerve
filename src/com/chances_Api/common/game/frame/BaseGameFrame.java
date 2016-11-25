package com.chances_Api.common.game.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.chances_Api.common.game.BaseGame;

public class BaseGameFrame extends JFrame {

	/**
	 * Constructor
	 * @param windowName
	 * @param panel
	 */
	
	public BaseGameFrame(String windowName, JPanel panel){
		super(windowName);
		startGame(panel);
	}
	
	/**
	 * public methods
	 */
	
	public void startGame(JPanel panel){
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
	}
	
	public void update(){
		getGameObject().update();	
	}
	
	public Timer getTimer(){

		Timer timer = new Timer(getGameObject().getMsPerFrame(), null);
		timer.addActionListener(getGameEventListener());
		
		return timer;
	}
	
	/**
	 * private methods
	 */
	
	private ActionListener getGameEventListener(){
		
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getGameObject().update();
				pack();
			}
		};
		return actionListener;
	}
	
	private BaseGame getGameObject(){
		return BaseGame.class.cast(this.getContentPane().getComponent(0));
	}
}
