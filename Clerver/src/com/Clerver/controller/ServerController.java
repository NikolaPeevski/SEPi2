package com.Clerver.controller;

import com.Clerver.domain.mediator.ServerModelManager;
import com.Clerver.view.ServerView;

public class ServerController {
	@SuppressWarnings("unused")
	private ServerModelManager model;
	@SuppressWarnings("unused")
	private ServerView view;

	public ServerController(ServerModelManager model, ServerView view) {
		this.model = model;
		this.view = view;
	}

}
