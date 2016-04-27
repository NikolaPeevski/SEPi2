package com.Clerver.domain.model;

import java.io.Serializable;

public class Progress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int HeartsConsumed;
	private int HeroesCreated;

	public Progress() {
		this.HeartsConsumed = 0;
		this.HeroesCreated = 0;
	}

	public boolean incH() {
		HeroesCreated++;
		return true;
	}

	public boolean incC() {
		HeartsConsumed++;
		return true;
	}

	public int getC() {
		return this.HeartsConsumed;
	}

	public int getH() {
		return this.HeroesCreated;
	}
}
