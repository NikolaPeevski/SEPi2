package com.Clerver.view;

import com.Clerver.controller.ServerController;

public class ServerView {

	@SuppressWarnings("unused")
	private ServerController controller;

	public ServerView() {
		System.out.println("Server is running...");
	}

	public void start(ServerController controller) {
		this.controller = controller;
	}

}
