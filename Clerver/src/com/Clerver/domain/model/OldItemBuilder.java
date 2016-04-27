package com.Clerver.domain.model;

public class OldItemBuilder implements ItemBuilder {
	private Item item;

	public OldItemBuilder() {
		this.item = new Item();
	}

	@Override
	public void buildItemName(String name) {
		this.item.setItemName(name);
	}

	@Override
	public void buildItemStats(int S, int P, int E, int C, int I, int A, int L) {
		this.item.setItemStats(S, P, E, C, I, A, L);
	}

	@Override
	public void buildItemPrice(int index) {
		this.item.setItemPrice(index);

	}

	@Override
	public Item getItem() {
		return this.item;
	}

}
