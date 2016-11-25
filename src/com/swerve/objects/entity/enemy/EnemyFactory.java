package com.swerve.objects.entity.enemy;

import java.util.ArrayList;
import java.util.List;

import com.chances_Api.common.game.entity.factories.BaseEntityFactory;

public class EnemyFactory extends BaseEntityFactory<Enemy> {

	public EnemyFactory() {
	}

	@Override
	protected Enemy create() {
		
		Enemy e = new Enemy();
		
		return new Enemy();
	}

	@Override
	protected List<Enemy> createList(int size) {

		ArrayList<Enemy> ls = new ArrayList<Enemy>();
		int i = 0;
		while (i < size) {
			Enemy e = new Enemy();

			ls.add(e);
		}
		return ls;
	}

}
