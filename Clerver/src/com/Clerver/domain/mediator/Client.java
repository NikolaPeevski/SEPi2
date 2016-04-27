package com.Clerver.domain.mediator;

import com.Clerver.controller.ClientController;
import com.Clerver.controller.Utility;
import com.Clerver.view.ClientView;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		ClientModelManager model = new ClientModelManager();
		ClientView clientView = new ClientView();
		Utility utility = new Utility();
		ClientController controller = new ClientController(model, clientView,
				utility);
		clientView.start(controller, utility);
		clientView.Display();
	}
}
