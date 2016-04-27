package com.Clerver.controller;

import com.Clerver.domain.mediator.ClientModelManager;
import com.Clerver.domain.model.Enemy;
import com.Clerver.domain.model.Hero;
import com.Clerver.domain.model.Item;
import com.Clerver.domain.model.Profile;
import com.Clerver.domain.model.ShopKeeper;
import com.Clerver.domain.model.Stats;
import com.Clerver.view.ClientView;

public class ClientController {
	private ClientModelManager model;
	private ClientView view;
	private Utility utility;
	private Profile profile;

	public ClientController(ClientModelManager model, ClientView view,
			Utility utility) {
		this.model = model;
		this.view = view;
		this.utility = utility;
	}

	public void execute(int index) {
		switch (index) {
		case 0: {
			if (utility.getSize() == 2) {
				this.profile = model.login(utility.getString(0),
						utility.getString(1));
				if (profile == null) {
					System.err.println("Wrong");
				} else
					System.out.println("Successful login");
				view.login();
			}
			break;
		}

		case 1:
			if (model
					.createAProfile(utility.getString(0), utility.getString(1))) {
				this.profile = new Profile(utility.getString(0),
						utility.getString(1));
				view.login();
			} else
				System.out.println("Problem");
			view.Display();
			break;

		case 2:
			model.CreateAhero(new Hero(utility.getString(0), new Stats()));
			System.out.println("Hero " + model.getProfile().getHero().getName()
					+ " name created!");
			view.Display();
			break;
		case 3:
			System.out.println("Hero " + model.getProfile().getHero().getName()
					+ " name deleted!");
			model.deleteAhero(model.getProfile().getHero());
			view.Display();
			break;
		case 4:
			Item buffer = model.getAnItem();
			System.out.println("Item with name: " + buffer.getName()
					+ " has a price of " + buffer.getPrice() + " gold points.");
			view.Display();
			break;
		case 5:
			Enemy buffer1 = model.getAnEnemy();
			System.out.println("Enemy with name: " + buffer1.getName()
					+ " has a price of " + buffer1.getGold() + " gold points.");
			view.Display();
			break;
		case 6:
			ShopKeeper buffer2 = model.getAShopKeeper();
			System.out.println("Enemy with name: " + buffer2.getName()
					+ " has an inventory of "
					+ buffer2.getInventory().getAll().size() + " items.");
			view.Display();
			break;
		case 7:
			model.exit(profile);
			System.exit(0);
			break;

		default:
			view.Display();
			break;
		}
	}
}
