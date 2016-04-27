package com.Clerver.domain.mediator;

import com.Clerver.domain.model.Hero;
import com.Clerver.domain.model.ShopKeeper;

public interface Simulations {
	/**
	 * Simulates a shop and returns the hero as a processed data. It should be
	 * replaced with the existing hero in the client profile model.
	 */
	Hero SimulateAShop(Hero hero, ShopKeeper shopKeeper);

	/**
	 * Simulates a journey, needs to be implemented. Similar to the Shopkeeper
	 * but with a numerical values of enemies and battle simulations.
	 */
	Hero SimulateAJourney(Hero hero);

}
