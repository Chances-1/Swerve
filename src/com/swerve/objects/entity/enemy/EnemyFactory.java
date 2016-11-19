package com.swerve.objects.entity.enemy;

public class EnemyFactory {
	
	public EnemyFactory(){
		
	}
	
	public Enemy spawnEnemy(){
		return new Enemy();
	}
}
