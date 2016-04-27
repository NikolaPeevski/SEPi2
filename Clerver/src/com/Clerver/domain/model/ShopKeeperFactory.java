package com.Clerver.domain.model;

import com.Clerver.domain.mediator.DBManager;

public class ShopKeeperFactory implements ShopF {

	@Override
	public ShopKeeper getShopKeeper(NPCManagement nManager,DBManager manage) {
		ShopKeeperBuilder oldShop = new OldShopKeeperBuilder();
		ShopKeeperDirector shopDirector = new ShopKeeperDirector(oldShop, manage, nManager);
		shopDirector.makeShop();
		return shopDirector.getShop();
	}

}
