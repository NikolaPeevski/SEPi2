package com.Clerver.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Item> items;
	private int gold;
	private static int MAX = 50;

	public Inventory() {
		items = new ArrayList<>();
		this.gold = 0;
	}

	public boolean addItem(Item item) {
		if (items.size() < MAX) {
			items.add(item);
			return true;
		}
		return false;
	}

	public boolean removeItem(int index) {
		items.remove(index);
		return true;
	}

	public int getGold() {
		return this.gold;
	}

	public ArrayList<Item> getAll() {
		return this.items;
	}

	public Item getOne(int index) {
		return this.items.get(index);
	}

	public boolean equip(int index) {
		if (!items.get(index).getIsEquiped()) {
			items.get(index).setIsEquiped(true);
			return true;
		}
		return false;

	}

	public boolean unEquip(int index) {
		if (items.get(index).getIsEquiped()) {
			items.get(index).setIsEquiped(false);
			return true;
		}
		return false;

	}

	public void gainGold(int index) {
		gold += index;
	}
}
