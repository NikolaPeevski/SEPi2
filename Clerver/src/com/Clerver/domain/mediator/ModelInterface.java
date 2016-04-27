package com.Clerver.domain.mediator;

import com.Clerver.domain.model.Enemy;
import com.Clerver.domain.model.Item;
import com.Clerver.domain.model.Profile;
import com.Clerver.domain.model.ShopKeeper;

/**
 * This interface is a bit tricky to explain, may need to read over a few times.
 */

public interface ModelInterface {
	/**
	 * Method login, FROM CLIENT: Accepts user input of username and password
	 * and creates a buffered profile which is being sent to the server. FROM
	 * SERVER: Accepts a client transmitted profile object and checks if it
	 * exists in the Server. If true it returns the whole profile information,
	 * if not it returns null. NOTE: returning null is a bad thing, needs a fix.
	 */
	Profile login(String username, String password);

	/**
	 * Method createAprofile, registraion in short. FROM CLIENT: Accepts user
	 * input of username and password and creates a buffered profile which is
	 * being sent to the server. FROM SERVER: Accepts a client transmitted
	 * profile object and checks if it exists, if true it returns false to the
	 * client, which notifies the user that the profile is already taken. If
	 * false it creates a profile and the user is automatically logged in.
	 */
	boolean createAProfile(String username, String password);

	/**
	 * The client pushes a request using the proxy, to the server. Server accept
	 * the request, generates an enemy(factory's design patter ) and sents it
	 * back to the client.
	 */
	Enemy getAnEnemy();

	/**
	 * The client pushes a request using the proxy, to the server. Server accept
	 * the request, generates a Shopkeeper(Using builder's and factory's design
	 * patter ) and sents it back to the client.
	 */
	ShopKeeper getAShopKeeper();

	/**
	 * The client pushes a request using the proxy, to the server. Server accept
	 * the request, generates an item(Using builder's and factory's design
	 * patter ) and sents it back to the client.
	 */
	Item getAnItem();

	/**
	 * an exit method. FROM CLIENT: Takes the profile and sends it to the server
	 * with an identificator. FROM SERVER: Takes input of the profile object
	 * plus the identificator which tells the server that the client has stopped
	 * the application and it needs to save the progress.
	 */
	void exit(Profile profile);
}
