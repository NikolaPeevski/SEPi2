package com.Clerver.domain.mediator;

import com.Clerver.domain.model.Enemy;
import com.Clerver.domain.model.Hero;
import com.Clerver.domain.model.Item;
import com.Clerver.domain.model.Profile;
import com.Clerver.domain.model.ShopKeeper;

public class ClientModelManager implements ModelInterface, ClientInteraction,
		Simulations {
	/**
	 * Using three private variables to control the client's model:
	 * proxy - controlling the communication thread with which we're sending information to the server.
	 * Profile - utilizes with either login() method or createAProfile() method. The model of the client.
	 * Simulation manager - used to simulate an action such as a battler, a journey or shopping for items
	 */ 
	private Proxy proxy;
	private Profile profile;
	private SimulationManager manage;
/**
 * Standard constructor for a client model manager. Creates a new proxy class and a new simulation manager.
 */
	public ClientModelManager() {
		this.proxy = new Proxy();
		manage = new SimulationManager();
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ModelInterface#login(java.lang.String, java.lang.String)
 */
	@Override
	public Profile login(String username, String password) {
		this.profile = this.proxy.login(username, password);
		return this.profile;
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ModelInterface#createAProfile(java.lang.String, java.lang.String)
 */
	@Override
	public boolean createAProfile(String username, String password) {
		boolean b = proxy.createAProfile(username, password);
		if (b)
			return true;
		return false;
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ModelInterface#getAnEnemy()
 */
	@Override
	public Enemy getAnEnemy() {
		return proxy.getAnEnemy();
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ModelInterface#getAShopKeeper()
 */
	@Override
	public ShopKeeper getAShopKeeper() {
		return proxy.getAShopKeeper();
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ModelInterface#getAnItem()
 */
	@Override
	public Item getAnItem() {
		return proxy.getAnItem();
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ModelInterface#exit(com.Clerver.domain.model.Profile)
 */
	@Override
	public void exit(Profile profile) {
		proxy.exit(profile);
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ClientInteraction#CreateAhero(com.Clerver.domain.model.Hero)
 */
	@Override
	public boolean CreateAhero(Hero hero) {
		boolean b = profile.createAHero(hero);
		if (b)
			return true;
		return false;
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ClientInteraction#deleteAhero(com.Clerver.domain.model.Hero)
 */
	@Override
	public boolean deleteAhero(Hero hero) {
		boolean b = profile.deleteAHero();
		if (b)
			return true;

		return false;
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ClientInteraction#goOnAJourney(com.Clerver.domain.model.Hero)
 */
	@Override
	public Hero goOnAJourney(Hero hero) {
		return this.SimulateAJourney(hero);
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.ClientInteraction#shop(com.Clerver.domain.model.Hero)
 */
	@Override
	public Hero shop(Hero hero) {
		return this.SimulateAShop(hero, this.getAShopKeeper());
	}
/*
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.Simulations#SimulateAShop(com.Clerver.domain.model.Hero, com.Clerver.domain.model.ShopKeeper)
 */
	@Override
	public Hero SimulateAShop(Hero hero, ShopKeeper shopKeeper) {
		return manage.SimulateAShop(hero, shopKeeper);
	}
/**
 * (non-Javadoc)
 * @see com.Clerver.domain.mediator.Simulations#SimulateAJourney(com.Clerver.domain.model.Hero)
 */
	@Override
	public Hero SimulateAJourney(Hero hero) {
		return SimulateAJourney(hero);
	}
/**
 * 
 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
/**
 * 
 */
	public Profile getProfile() {
		return this.profile;
	}
/**
 * 
 */
	public SimulationManager getManager(){
		return this.manage;
	}

}
