package com.Clerver.domain.model;

import com.Clerver.controller.Utility;

public class EnemyFactory implements Factory{

	@Override
	public Enemy getEnemy() {
		int index = Utility.randInt(1, 4);
		switch (index) {
		case 1:
			return new Skeleton();
		case 2:
			return new Orc();
		case 3:
			return new Elf();
		case 4:
			return new Human();
		}
		return null;
	}

}
