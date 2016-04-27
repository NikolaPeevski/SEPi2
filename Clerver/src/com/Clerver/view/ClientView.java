package com.Clerver.view;

import com.Clerver.controller.ClientController;
import com.Clerver.controller.Utility;

public class ClientView {
	private ClientController controller;
	private Utility utility;
	public ClientView() {
	}

	public void start(ClientController controller, Utility utility) {
		this.controller = controller;
		this.utility = utility;
	}

	private void menu() {
		System.out.println(" MENU");
		System.out.println(" 1) Login");
		System.out.println(" 2) Create an account");
		System.out.println(" 3) Create a hero");
		System.out.println(" 4) Delete a hero");
		System.out.println(" 5) Request an item");
		System.out.println(" 6) Request an enemy");
		System.out.println(" 7) Request a shopKeeper");
		System.out.println(" 0) Quit");
		System.out.print(" Type your choice: ");
	}

	public void Display() {
		int choice;
		while (true) {
			utility.flush();
			menu();
			choice = Cin.readInt();
			switch (choice) {

			// -----------------------------------------------------------------------------------------------------------------------------

			case 1:
				System.out.println("-------------------------");
				System.out.println(" WRITE YOUR USERNAME: ");
				utility.addString(Cin.readString());
				System.out.println(" WRITE YOUR PASSWORD: ");
				utility.addString(Cin.readString());
				controller.execute(0);
				System.out.println("-------------------------");
				break;
			case 2:
				System.out.println("-------------------------");
				System.out.println(" WRITE YOUR USERNAME: ");
				utility.addString(Cin.readString());
				System.out.println(" WRITE YOUR PASSWORD: ");
				utility.addString(Cin.readString());
				controller.execute(1);
				System.out.println("-------------------------");
				break;
			case 3:
				System.out.println("-------------------------");
				System.out.println(" ENTER HERO USERNAME: ");
				utility.addString(Cin.readString());
				controller.execute(2);
				System.out.println("-------------------------");
				break;
			case 4:
				controller.execute(3);
				break;
			case 5:
				System.out.println("-------------------------");
				System.out.println(" LOADING.... ");
				controller.execute(4);
				System.out.println("-------------------------");
				break;
			case 6:
				System.out.println("-------------------------");
				System.out.println(" LOADING.... ");
				controller.execute(5);
				System.out.println("-------------------------");
				break;
			case 7:
				System.out.println("-------------------------");
				System.out.println(" LOADING.... ");
				controller.execute(6);
				System.out.println("-------------------------");
				break;
			case 0:
				controller.execute(7);
				break;
			default:
				break;

			}

		}
	}

	public void login() {
	}
}
