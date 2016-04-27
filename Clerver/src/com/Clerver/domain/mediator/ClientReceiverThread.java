package com.Clerver.domain.mediator;

import java.io.ObjectInputStream;

public class ClientReceiverThread extends Thread {
	ObjectInputStream inFromServer;
	Proxy proxy;

	/**
	 * Using proxy to accept the data and the transfer it to the proxy's method
	 * which returns an object.
	 */
	public ClientReceiverThread(Proxy proxy, ObjectInputStream inFromServer) {
		this.inFromServer = inFromServer;
		this.proxy = proxy;
	}

	/**
	 * Runs ONCE,accepting information from the server using method .readObject.
	 * First object is ALWAYS the identificator and the second is the object.
	 * NOTE readInt() is kind of bugged, replaced with readObject + (int) cast.
	 */
	@Override
	public void run() {
		int action;
		try

		{
			action = (int) inFromServer.readObject();
			switch (action) {
			case 1: {
				proxy.setObject(inFromServer.readObject());
				break;
			}
			case 2: {
				proxy.setObject(inFromServer.readObject());
				break;
			}
			case 3: {
				proxy.setObject(inFromServer.readObject());
				break;
			}
			case 4: {
				proxy.setObject(inFromServer.readObject());
				break;
			}

			case 5: {
				proxy.setObject(inFromServer.readObject());
				break;
			}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
