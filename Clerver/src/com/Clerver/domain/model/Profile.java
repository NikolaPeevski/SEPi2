package com.Clerver.domain.model;

import java.io.Serializable;

public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Hero hero;
	private Progress progress;

	public Profile(String username, String password) {
		this.username = username;
		this.password = password;
		progress = new Progress();
	}

	public String getUsername() {
		return this.username;
	}
	public String getPass() {
		return this.password;
	}

	public boolean createAHero(Hero hero) {
		this.hero = hero;
		progress.incH();
		return true;
	}

	public boolean deleteAHero() {
		this.hero = null;
		return true;
	}

	public Hero getHero() {
		return this.hero;
	}

	public boolean setPass(String password) {
		this.password = password;
		return true;
	}

	public boolean profileBeat() {
		progress.incC();
		this.deleteAHero();
		return true;
	}
}
