package com.Clerver.domain.model;

import java.io.Serializable;

public class ShopKeeper implements Serializable, ShopKeeperPlan {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Inventory inventory;

	public String getName() {
		return this.name;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	/**
	 * 
	 * @param index
	 *            - The index of the item in the inventory.
	 * @param gold
	 *            - The gold of the hero.
	 * @return null if the hero doesn't have enogh gold to buy the item, and
	 *         returns the item if the player can aquier it.
	 */
	public Item buyItem(int index, int gold) {
		Item buffer = inventory.getOne(index);
		if (gold >= buffer.getPrice()) {
			inventory.removeItem(index);
			return buffer;
		}
		return null;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;

	}
}
