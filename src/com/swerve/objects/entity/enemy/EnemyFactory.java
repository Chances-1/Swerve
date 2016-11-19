package com.swerve.objects.entity.enemy;

import java.util.ArrayList;
import java.util.List;

import com.swerve.common.BaseEntityFactory;

public class EnemyFactory extends BaseEntityFactory<Enemy> {

	public EnemyFactory(int windowWidth, int windowHeight) {
		super(windowWidth, windowHeight);
	}

	@Override
	protected Enemy create() {
		
		return new Enemy(getWindowWidth(), getWindowHeight());
	}

	@Override
	protected List<Enemy> createList(int size) {

		ArrayList<Enemy> ls = new ArrayList<Enemy>();
		int i = 0;
		while (i < size) {
			ls.add(new Enemy(getWindowWidth(), getWindowHeight()));
		}
		return ls;
	}

}
