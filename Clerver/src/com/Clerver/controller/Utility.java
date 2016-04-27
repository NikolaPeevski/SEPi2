package com.Clerver.controller;

import java.util.ArrayList;
import java.util.Random;

public class Utility {
	private ArrayList<String> simpleString;

	public Utility() {
		simpleString = new ArrayList<>();
	}

	public void flush() {
		simpleString = new ArrayList<>();
	}

	public int getSize() {
		return simpleString.size();
	}

	public void addString(String string) {
		simpleString.add(string);
	}

	public String getString(int id) {
		return simpleString.get(id);
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}
