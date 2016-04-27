package com.Clerver.domain.model;

import java.io.Serializable;

public class HeroProgress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int enemiesKilled;

	public HeroProgress() {
		enemiesKilled = 0;
	}

	public void killEnemy() {
		enemiesKilled++;
	}

	public int getCount() {
		return this.enemiesKilled;
	}
}
