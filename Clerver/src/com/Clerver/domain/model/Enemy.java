package com.Clerver.domain.model;

import java.io.Serializable;

import com.Clerver.controller.Utility;

public abstract class Enemy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Stats stats;
	private String name;
	private int level;
	private int gold;

	public Enemy(String name, int level) {
		this.name = name;
		this.stats = new Stats();
		this.level = level;
		this.gold = level * randInt(0, 100);
	}

	public Stats getStats() {
		return this.stats;
	}

	public String getName() {
		return this.name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}

	public int getGold() {
		return this.gold;
	}

	/**
	 * 
	 * @param index
	 *            - The action the Enemy takes
	 * @return integer on which action has the Enemy taken. Of input 0 it
	 *         returns the damage the Enemy does with an attack. Of input 1 it
	 *         returns 1 which is the identifier for skipping a turn. Of input 2
	 *         it returns the damage the Enemy does with an ability. Of an
	 *         inaccurate input it returns -1.
	 */
	public int Action(int index) {
		switch (index) {
		case 0:
			return stats.getAttackDamage();

		case 1:
			return 1;
		case 2:
			// uses an ability
			break;
		case 3:
			// use an item
			break;
		}
		return -1;
	}

	/**
	 * 
	 * @param index
	 *            - The damage the Enemy takes.
	 * @return True if the Enemy's health points becomes zero or negative. It
	 *         identifies that the Enemy is dead and the user needs to create a
	 *         new one. False if the Enemy takes damage, but it doesn't die.
	 */
	public boolean receiveDmg(int index) {
		stats.setCurrentHp(index);
		if (stats.getCurrentHP() <= 0) {
			return false;
		}
		return true;
	}

	private static int randInt(int min, int max) {
		return Utility.randInt(min, max);
	}
}
