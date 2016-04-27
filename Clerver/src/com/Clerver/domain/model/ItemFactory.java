package com.Clerver.domain.model;

import com.Clerver.domain.mediator.DBManager;

public class ItemFactory implements ItemF{

	@Override
	public Item getItem(DBManager manage) {
		ItemBuilder oldItem = new OldItemBuilder();
		ItemDirector itemDirector = new ItemDirector(oldItem, manage);
		itemDirector.makeItem();
		return itemDirector.getItem();
	}

}
