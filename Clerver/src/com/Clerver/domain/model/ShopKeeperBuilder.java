package com.Clerver.domain.model;

public interface ShopKeeperBuilder {
	void buildShopkeeperName(String name);

	void builtInventory(Inventory inventory);

	ShopKeeper getShopkeeper();
}
