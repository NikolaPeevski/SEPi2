package com.Clerver.domain.model;

import java.io.Serializable;

import com.Clerver.controller.Utility;

public class Item implements Serializable, ItemPlan {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int steamRolliness;
	private int plasticness;
	private int eagerness;
	private int childishness;
	private int injudiciousness;
	private int aluminiumness;
	private int looking;
	private String name;
	private boolean isEquiped;
	private int price;
	public Item(){
		isEquiped = false;
	}

	public int getPrice() {
		return this.price;
	}

	public int getSteamRolliness() {
		return steamRolliness;
	}

	public int getPlasticness() {
		return plasticness;
	}

	public int getEagerness() {
		return eagerness;
	}

	public int getChildishness() {
		return childishness;
	}

	public int getInjudiciousness() {
		return injudiciousness;
	}

	public int getLooking() {
		return looking;
	}

	public String getName() {
		return name;
	}

	public int getAluminiumness() {
		return this.aluminiumness;
	}

	public boolean getIsEquiped() {
		return this.isEquiped;
	}

	public void setIsEquiped(boolean status) {
		this.isEquiped = status;
	}

	private static int randInt(int min, int max) {
		return Utility.randInt(min, max);
	}

	@Override
	public void setItemName(String name) {
		this.name = name;

	}

	@Override
	public void setItemPrice(int index) {
		this.price = index * randInt(0, 100);

	}

	@Override
	public void setItemStats(int S, int P, int E, int C, int I, int A, int L) {
		this.steamRolliness = S;
		this.plasticness = P;
		this.eagerness = E;
		this.childishness = C;
		this.injudiciousness = I;
		this.aluminiumness = A;
		this.looking = L;

	}
}
