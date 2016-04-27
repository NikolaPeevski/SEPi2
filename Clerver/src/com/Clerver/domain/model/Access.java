package com.Clerver.domain.model;

public class Access {
	private ProfileList pList;
	private NPCManagement manager;

	public Access() {
		pList = new ProfileList();
		manager = new NPCManagement();
	}

	public Access(ProfileList list) {
		pList = list;
		manager = new NPCManagement();
	}

	/**
	 * 
	 * @param index
	 *            can be 0 or 1.
	 * @return returns an object. Of index 0 it returns the profile list. Of
	 *         index 1 it returns the NPC manager.
	 */
	public Object choice(int index) {
		switch (index) {
		case 0:
			return this.pList;
		case 1:
			return this.manager;
		}
		return null;
	}

}
