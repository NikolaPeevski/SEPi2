package com.Clerver.domain.mediator;

import java.io.IOException;

import com.Clerver.domain.model.Access;
import com.Clerver.domain.model.Enemy;
import com.Clerver.domain.model.Item;
import com.Clerver.domain.model.NPCManagement;
import com.Clerver.domain.model.Profile;
import com.Clerver.domain.model.ProfileList;
import com.Clerver.domain.model.ShopKeeper;

public class ServerModelManager implements ModelInterface {
	private Access access;
	private DBManager dbManager;
	private IOManager ioManager;
	/**
	 * Casting is BAD, needs reworking.
	 */
	public ServerModelManager() {
		dbManager = new DBManager();
		ioManager = new IOManager();
		access = new Access(ioManager.load());
		ServerConnectionThread server;
		try {
			server = new ServerConnectionThread(this);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * (non-Javadoc)
	 * @see com.Clerver.domain.mediator.ModelInterface#login(java.lang.String, java.lang.String)
	 */
	@Override
	public Profile login(String username, String password) {
		int index = ((ProfileList) access.choice(0)).searchList(username,
				password);
		if (index != -1) {
			return ((ProfileList) access.choice(0)).getProfile(index);
		}
		return null;
	}
	/**
	 * (non-Javadoc)
	 * @see com.Clerver.domain.mediator.ModelInterface#createAProfile(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean createAProfile(String username, String password) {
		Profile buffer = new Profile(username, password);
		boolean autho = ((ProfileList) access.choice(0)).addProfile(buffer);
		if (autho) {
			return true;
		}
		return false;
	}
	/**
	 * (non-Javadoc)
	 * @see com.Clerver.domain.mediator.ModelInterface#getAnEnemy()
	 */
	@Override
	public Enemy getAnEnemy() {
		return ((NPCManagement) access.choice(1)).createAnEnemy();

	}
	/**
	 * (non-Javadoc)
	 * @see com.Clerver.domain.mediator.ModelInterface#getAShopKeeper()
	 */
	@Override
	public ShopKeeper getAShopKeeper() {
		return ((NPCManagement) access.choice(1)).createAShopKeeper(this.dbManager);
	}
	/**
	 * (non-Javadoc)
	 * @see com.Clerver.domain.mediator.ModelInterface#getAnItem()
	 */
	@Override
	public Item getAnItem() {
		return ((NPCManagement) access.choice(1)).createAnItem(dbManager);
	}
	/**
	 * (non-Javadoc)
	 * @see com.Clerver.domain.mediator.ModelInterface#exit(com.Clerver.domain.model.Profile)
	 */
	@Override
	public void exit(Profile profile) {
		((ProfileList) access.choice(0)).setProfile(profile);
		ioManager.save((ProfileList) access.choice(0));
	
	}

}
