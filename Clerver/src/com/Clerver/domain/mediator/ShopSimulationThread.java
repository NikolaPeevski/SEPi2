package com.Clerver.domain.mediator;

import com.Clerver.domain.model.Hero;
import com.Clerver.domain.model.ShopKeeper;

public class ShopSimulationThread extends Thread {
	private Hero hero;
	private ShopKeeper shopKeeper;
	private SimulationManager manage;

	/**
	 * To be implemented, but the general concept is as follows : Inputs index
	 * and transfers the item from the shop's inventory to the hero's. Needs to
	 * add a method which removes hero's gold upon purchase! If index is -1 it
	 * stops the thread;
	 */
	public ShopSimulationThread(Hero hero, ShopKeeper shopKeeper,
			SimulationManager manage) {
		super(shopKeeper.getName());
		this.hero = hero;
		this.shopKeeper = shopKeeper;
	}

	@Override
	public void run() {
		try {
			while (true) {
				this.wait();
				int index = manage.getIndex();
				if (index == -1)
					break;
				hero.getInventory().addItem(
						shopKeeper.getInventory().getOne(index));
				shopKeeper.getInventory().removeItem(index);
				manage.setHero(hero);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
