package com.Clerver.domain.model;

import com.Clerver.domain.mediator.DBManager;

public interface ShopF {
	ShopKeeper getShopKeeper(NPCManagement nManager,DBManager manage);
}
