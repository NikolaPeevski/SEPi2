package com.Clerver.domain.model;

import com.Clerver.controller.Utility;
import com.Clerver.domain.mediator.DBManager;

public class ShopKeeperDirector {
	private ShopKeeperBuilder shopBuilder;
	private DBManager manage;
	private NPCManagement nManage;

	public ShopKeeperDirector(ShopKeeperBuilder shopBuilder,
			DBManager dbManager, NPCManagement nManage) {
		this.shopBuilder = shopBuilder;
		this.manage = dbManager;
		this.nManage = nManage;
	}

	public ShopKeeper getShop() {
		return this.shopBuilder.getShopkeeper();
	}

	public void makeShop() {
		shopBuilder.buildShopkeeperName(genName());
		shopBuilder.builtInventory(genInventory());
	}

	private String genName() {
		int i = Utility.randInt(0, 4);
		switch (i) {
		case 0:
			return "Toncho";
		case 1:
			return "Boncho";
		case 2:
			return "Noncho";
		case 3:
			return "Bai Nikcho";
		case 4:
			return "The stranding merchant";
		}
		return "Blop";
	}

	private Inventory genInventory() {
		Inventory inventory = new Inventory();
		for (int i = 0; i < 39; i++) {
			inventory.addItem(nManage.createAnItem(this.manage));
		}
		return inventory;
	}
}
