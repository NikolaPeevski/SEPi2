package com.Clerver.domain.mediator;

import com.Clerver.domain.model.Hero;

public interface ClientInteraction {
	/**
	 * Adds a hero to the client's profile model. If a hero already exist it will replace it.
	 * @param hero - From profile's model.
	 * @return true or false
	 */
	boolean CreateAhero(Hero hero);
	
	/**
	 * Deletes a hero from the client's profile model. NOTE: If already it's been deleted will throw an exception. Needs halndling.
	 * @param hero - From profile's model.
	 * @return true or false.
	 */
	boolean deleteAhero(Hero hero);
	/**
	 * Simulates a journer. Needs implementation.
	 */
	Hero goOnAJourney(Hero hero);
	/**
	 * Simulates a shop. Partly implemented. Code is OK, there needs to be an interface for this action to work properly.
	 */
	Hero shop(Hero hero);
}
