package com.Clerver.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.Clerver.domain.model.Enemy;
import com.Clerver.domain.model.Item;
import com.Clerver.domain.model.Profile;
import com.Clerver.domain.model.ShopKeeper;

public class Proxy implements ModelInterface {
	private final int PORT = 2112;
	private final String HOST = "localhost";
	private Socket clientSocket;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private Object object;
	private ClientReceiverThread clientThread;

	/**
	 * It initializes a network socket, and it tries to connect to the server.
	 * If server is on another computer change the String HOST to the
	 * corresponding IP and PORT to the corresponding port.
	 */
	public Proxy() {
		try {
			clientSocket = new Socket(HOST, PORT);
			outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			inFromServer = new ObjectInputStream(clientSocket.getInputStream());
			clientThread = new ClientReceiverThread(this, inFromServer);
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + HOST);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to: "
					+ HOST);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.Clerver.domain.mediator.ModelInterface#login(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Profile login(String username, String password) {
		try {
			outToServer.writeObject(1);
			Profile buffer = new Profile(username, password);
			outToServer.writeObject(buffer);
			clientThread.run();
			clientThread.join();
			return (Profile) this.object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.Clerver.domain.mediator.ModelInterface#createAProfile(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public boolean createAProfile(String username, String password) {
		try {
			outToServer.writeObject(2);
			Profile buffer = new Profile(username, password);
			outToServer.writeObject(buffer);
			clientThread.run();
			clientThread.join();
			return (boolean) this.object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.Clerver.domain.mediator.ModelInterface#getAnEnemy()
	 */
	@Override
	public Enemy getAnEnemy() {
		try {
			outToServer.writeObject(3);
			clientThread.run();
			clientThread.join();
			return (Enemy) this.object;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.Clerver.domain.mediator.ModelInterface#getAShopKeeper()
	 */
	@Override
	public ShopKeeper getAShopKeeper() {
		try {
			outToServer.writeObject(4);
			clientThread.run();
			clientThread.join();
			return (ShopKeeper) this.object;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.Clerver.domain.mediator.ModelInterface#getAnItem()
	 */
	@Override
	public Item getAnItem() {
		try {
			outToServer.writeObject(5);
			clientThread.run();
			clientThread.join();
			return (Item) this.object;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.Clerver.domain.mediator.ModelInterface#exit(com.Clerver.domain.model
	 * .Profile)
	 */
	@Override
	public void exit(Profile profile) {
		try {
			outToServer.writeObject(6);
			outToServer.writeObject(profile);
			clientSocket.close();
			// Close the gui;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Used with connection to the client receiver thread. Gets the input from
	 * the server. NOTE: It's a bad idea and it needs reworking but for the
	 * moment it's the best solution.
	 */
	public void setObject(Object object) {
		this.object = object;
	}

}
