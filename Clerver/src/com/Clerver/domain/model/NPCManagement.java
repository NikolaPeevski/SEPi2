package com.Clerver.domain.model;

import com.Clerver.domain.mediator.DBManager;

public class NPCManagement {

	public NPCManagement() {
	}

	public Enemy createAnEnemy() {
		return new EnemyFactory().getEnemy();
	}

	public ShopKeeper createAShopKeeper(DBManager dbManager) {
		return new ShopKeeperFactory().getShopKeeper(this, dbManager);
	}

	public Item createAnItem(DBManager dbManager) {
		return new ItemFactory().getItem(dbManager);
	}

}
