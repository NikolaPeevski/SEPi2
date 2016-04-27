package com.Clerver.domain.mediator;

import com.Clerver.domain.model.Hero;
import com.Clerver.domain.model.ShopKeeper;

public class SimulationManager implements Simulations {
	private Hero hero;
	private int index;

	@Override
	public Hero SimulateAShop(Hero hero, ShopKeeper shopKeeper) {
		this.hero = hero;
		ShopSimulationThread shop = new ShopSimulationThread(this.hero,
				shopKeeper, this);
		shop.run();
		return this.hero;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.Clerver.domain.mediator.Simulations#SimulateAJourney(com.Clerver.
	 * domain.model.Hero)
	 */
	@Override
	public Hero SimulateAJourney(Hero hero) {
		return null;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	/**
	 * Used for shopping simulation. It's being set by the GUI.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

}
