package com.Clerver.domain.model;

public class OldShopKeeperBuilder implements ShopKeeperBuilder {
	private ShopKeeper shopKeeper;
	public OldShopKeeperBuilder() {
		this.shopKeeper = new ShopKeeper();
	}

	@Override
	public void buildShopkeeperName(String name) {
		this.shopKeeper.setName(name);

	}

	@Override
	public void builtInventory(Inventory inventory) {
		this.shopKeeper.setInventory(inventory);
	}

	@Override
	public ShopKeeper getShopkeeper() {
		return this.shopKeeper;
	}

}
