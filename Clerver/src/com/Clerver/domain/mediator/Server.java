package com.Clerver.domain.mediator;

import java.io.IOException;

import com.Clerver.controller.ServerController;
import com.Clerver.view.ServerView;

public class Server {
	public static void main(String args[]) throws IOException {
		ServerModelManager model = new ServerModelManager();
		ServerView serverView = new ServerView();
		ServerController controller = new ServerController(model, serverView);
		serverView.start(controller);
	}

}
