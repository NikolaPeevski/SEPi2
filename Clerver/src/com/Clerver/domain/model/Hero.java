package com.Clerver.domain.model;

import java.io.Serializable;

public class Hero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int level;
	private int experience;
	private HeroProgress progress;
	private Inventory inventory;
	private Stats stats;

	/**
	 * Initializes counstructor.
	 * 
	 * @param name
	 *            - the name of the character.
	 * @param stats
	 *            - A pre-written statatistics of the hero.
	 */
	public Hero(String name, Stats stats) {
		this.name = name;
		this.experience = 0;
		this.level = 1;
		this.stats = stats;
		inventory = new Inventory();
	}

	/**
	 * 
	 * @param experience
	 *            - The experience gained after a fight.
	 * @return true if the hero is ready to level up/False if not. The rate is
	 *         adjustable by changing "400".
	 */
	public boolean gainExperience(int experience) {
		experience += experience;
		if (experience % 400 == 0) {
			return true;
		}
		return false;
	}

	public String getName() {
		return this.name;
	}

	public int getXP() {
		return this.experience;
	}

	public int getlevel() {
		return this.level;
	}

	/**
	 * 
	 * @param S
	 *            - Attribute for Steamrolliness.
	 * @param P
	 *            - Attribute for Plasticness.
	 * @param E
	 *            - Attribute for Eagerness.
	 * @param C
	 *            - Attribute for Childishness.
	 * @param I
	 *            - Attribute for Injudiciousness.
	 * @param A
	 *            - Attribute for Aluminiumness.
	 * @param L
	 *            - Attribute for Looking.
	 * @return returns true if successfully leveled up.
	 * 
	 *         For detailed description of the Attributes see the documentation.
	 */
	public boolean levelup(int S, int P, int E, int C, int I, int A, int L) {
		stats.levelup(S, P, E, C, I, A, L);
		return true;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public Stats getStats() {
		return this.stats;
	}

	/**
	 * 
	 * @param index
	 *            The index of an item from the inventory.
	 * @return returns true if item isn't equipped already and if it's
	 *         successfully equipped. The way the method works is getting the
	 *         attributes from the item and adding them to the hero's general
	 *         stats temporary until unequippment.
	 *
	 */
	public boolean Equip(int index) {
		if (!inventory.getOne(index).getIsEquiped()) {
			levelup(inventory.getOne(index).getSteamRolliness(), inventory
					.getOne(index).getPlasticness(), inventory.getOne(index)
					.getEagerness(), inventory.getOne(index).getChildishness(),
					inventory.getOne(index).getInjudiciousness(), inventory
							.getOne(index).getAluminiumness(), inventory
							.getOne(index).getLooking());
			inventory.getOne(index).setIsEquiped(true);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param index
	 *            The index of an item from the inventory which is already
	 *            equipped.
	 * @return returns true if item is equipped already and if it's successfully
	 *         unequipped. The way the method works is getting the attributes
	 *         from the item and removing them to the hero's general stats.
	 *
	 */
	public boolean unEquip(int index) {
		if (inventory.getOne(index).getIsEquiped()) {
			stats.unLevel(inventory.getOne(index).getSteamRolliness(),
					inventory.getOne(index).getPlasticness(),
					inventory.getOne(index).getEagerness(),
					inventory.getOne(index).getChildishness(), inventory
							.getOne(index).getInjudiciousness(), inventory
							.getOne(index).getAluminiumness(), inventory
							.getOne(index).getLooking());
			inventory.getOne(index).setIsEquiped(false);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param index
	 *            - The action the hero takes
	 * @return integer on which action has the hero taken. Of input 0 it returns
	 *         the damage the hero does with an attack. Of input 1 it returns 1
	 *         which is the identifier for skipping a turn. Of input 2 it
	 *         returns the damage the hero does with an ability. Of an
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
	 *            - The damage the hero takes.
	 * @return True if the hero's health points becomes zero or negative. It
	 *         identifies that the hero is dead and the user needs to create a
	 *         new one. False if the hero takes damage, but it doesn't die.
	 */
	public boolean receiveDmg(int index) {
		stats.setCurrentHp(index);
		if (stats.getCurrentHP() <= 0) {
			return false;
		}
		return true;
	}

	public HeroProgress getProgress() {
		return this.progress;
	}

}
