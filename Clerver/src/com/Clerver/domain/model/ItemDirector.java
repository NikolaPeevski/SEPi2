package com.Clerver.domain.model;

import com.Clerver.controller.Utility;
import com.Clerver.domain.mediator.DBManager;

public class ItemDirector {
	private ItemBuilder itemBuilder;
	private DBManager manage;

	public ItemDirector(ItemBuilder itemBuilder, DBManager manage) {
		this.itemBuilder = itemBuilder;
		this.manage = manage;
	}

	public Item getItem() {
		return this.itemBuilder.getItem();
	}

	public void makeItem() {
		String name = manage.genitemName();
		this.itemBuilder.buildItemName("the " + name);
		this.itemBuilder.buildItemPrice(Utility.randInt(0, 100));
		int[] list = genStats(name);

		this.itemBuilder.buildItemStats(list[0], list[1], list[2], list[3],
				list[4], list[5], list[6]);
	}

	private int[] genStats(String name) {
		int[] list = new int[7];
		String[] buff = name.split("\\s+");
		for (int i = 0; i < buff.length; i++) {
			switch (buff[i]) {

			case "dagger":
				list[1]++;
				list[2]++;
				list[3]++;
				list[6]++;
				break;

			case "sword":
				list[1]++;
				list[1]++;
				list[2]++;
				list[0]++;
				break;

			case "mace":
				list[1]++;
				list[1]++;
				list[1]++;
				list[0]++;

				break;

			case "axe":
				list[1]++;
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "shield":
				list[3]++;
				list[3]++;
				list[3]++;
				list[1]++;
				break;

			case "helmet":
				list[3]++;
				break;

			case "mask":
				list[3]++;
				break;

			case "necklace":
				list[6]++;
				break;

			case "gloves":
				list[5]++;
				break;

			case "ring":
				list[5]++;
				break;

			case "shoulders":
				list[5]++;
				break;

			case "cape":
				list[3]++;
				break;

			case "armor":
				list[4]++;
				list[4]++;
				break;

			case "shirt":
				list[1]++;
				break;

			case "belt":
				list[0]++;
				break;

			case "bottoms":
				list[3]++;
				break;

			case "socks":
				list[2]++;
				break;

			case "flaming":
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "freezing":
				list[5]++;
				list[5]++;
				list[5]++;
				break;

			case "itchy":
				list[2]++;
				list[2]++;
				list[2]++;
				break;

			case "deadly":
				list[0]++;
				list[0]++;
				list[0]++;
				break;

			case "holy":
				list[3]++;
				list[2]++;
				list[1]++;
				break;

			case "unholy":
				list[5]++;
				list[6]++;
				list[4]++;
				break;

			case "swift":
				list[3]++;
				list[3]++;
				list[3]++;
				break;

			case "shady":
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "heavy":
				list[0]++;
				list[0]++;
				list[1]++;
				break;

			case "light":
				list[4]++;
				list[2]++;
				list[2]++;
				break;

			case "spectral":
				list[5]++;
				list[5]++;
				list[4]++;
				break;

			case "obvious":
				list[6]++;
				list[6]++;
				list[6]++;
				break;

			case "invisible":
				list[3]++;
				list[3]++;
				list[3]++;
				break;

			case "stinky":
				list[0]++;
				list[0]++;
				list[0]++;
				break;

			case "scrappy":
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "tight":
				list[6]++;
				list[6]++;
				list[3]++;
				break;

			case "shiny":
				list[6]++;
				list[5]++;
				list[5]++;
				break;

			case "spooky":
				list[3]++;
				list[3]++;
				list[6]++;
				break;

			case "doom":
				list[5]++;
				list[5]++;
				list[5]++;
				break;

			case "salvation":
				list[2]++;
				list[2]++;
				list[2]++;
				break;

			case "bones":
				list[0]++;
				list[0]++;
				list[0]++;
				break;

			case "razors":
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "bricks":
				list[1]++;
				list[1]++;
				list[0]++;
				break;

			case "cans":
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "metal":
				list[0]++;
				list[1]++;
				list[2]++;
				break;

			case "pop":
				list[6]++;
				list[6]++;
				list[5]++;
				break;

			case "rock":
				list[5]++;
				list[5]++;
				list[5]++;
				break;

			case "bieber":
				break;

			case "swag":
				break;

			case "nike":
				list[2]++;
				list[2]++;
				list[2]++;
				break;

			case "puma":
				list[2]++;
				list[2]++;
				list[2]++;
				break;

			case "versace":
				list[6]++;
				list[6]++;
				list[6]++;
				break;

			case "armani":
				list[6]++;
				list[6]++;
				list[6]++;
				break;

			case "cuba":
				list[1]++;
				list[1]++;
				list[1]++;
				break;

			case "america":
				list[4]++;
				list[4]++;
				list[4]++;
				break;

			case "energy":
				list[3]++;
				list[3]++;
				list[3]++;
				break;

			default:
				break;
			}
		}
		return list;
	}
}
