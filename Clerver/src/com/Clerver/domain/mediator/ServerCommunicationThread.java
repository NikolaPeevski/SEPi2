package com.Clerver.domain.mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.Clerver.domain.model.Enemy;
import com.Clerver.domain.model.Item;
import com.Clerver.domain.model.Profile;
import com.Clerver.domain.model.ShopKeeper;

public class ServerCommunicationThread extends Thread {
	private ObjectInputStream inFromClient;
	private ObjectOutputStream outToClient;
	private ServerModelManager model;
	@SuppressWarnings("unused")
	private String client;
	private String clientIP;

	/**
	 * Waits for an input from the client VIA sockets and then from the
	 * corresponding identificator it commands the model and returns an object
	 * in most cases. NOTE: Casting is bad, needs reworking, for now it works.
	 * It's able to get the client's IP, if needed.
	 */
	public ServerCommunicationThread(Socket clientSocket,
			ServerModelManager model) throws IOException {
		this.model = model;
		inFromClient = new ObjectInputStream(clientSocket.getInputStream());
		outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

		clientIP = clientSocket.getInetAddress().getHostName();
		if (!clientIP.equals(clientSocket.getInetAddress().getHostAddress()))
			clientIP += " / " + clientSocket.getInetAddress().getHostAddress();
		if (clientIP.equals("127.0.0.1"))
			clientIP = "localhost";

		this.start();
	}

	/**
	 * Waits for an identificator(readObject() because readInt() is
	 * bugged).Commans the model to process the information and returns it back
	 * to the Client.Exception is number 6 where it forces a save on the profile
	 * list.
	 */
	@Override
	public void run() {
		try {

			int action;

			while (true) {

				action = (int) inFromClient.readObject();
				switch (action) {
				case 1: {
					Profile buf = (Profile) inFromClient.readObject();
					String name = buf.getUsername();
					String pass = buf.getPass();
					Profile buffer = model.login(name, pass);
					sendObject(1);
					sendObject(buffer);
					break;
				}
				case 2: {
					Profile buf = (Profile) inFromClient.readObject();
					String name = (buf.getUsername());
					String pass = (buf.getPass());
					boolean buffer = model.createAProfile(name, pass);
					sendObject(2);
					sendObject(buffer);
					break;
				}
				case 3: {
					Enemy buffer = model.getAnEnemy();
					sendObject(3);
					sendObject(buffer);
					break;
				}
				case 4: {
					ShopKeeper buffer = model.getAShopKeeper();
					sendObject(4);
					sendObject(buffer);
					break;
				}
				case 5: {
					Item buffer = model.getAnItem();
					sendObject(5);
					sendObject(buffer);
					break;
				}
				case 6: {
					model.exit((Profile) inFromClient.readObject());
					break;
				}
				default:
					break;
				}

			}
		} catch (SocketException e) {
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void sendObject(Object obj) throws Exception {
		outToClient.writeObject(obj);
	}

}
