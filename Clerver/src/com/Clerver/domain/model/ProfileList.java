package com.Clerver.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfileList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Profile> profileList;

	/**
	 * Initializes constructor
	 */
	public ProfileList() {
		this.profileList = new ArrayList<>();
	}

	/**
	 * 
	 * @param profile
	 *            - a new profile instance is required in order to register one.
	 * @return - True if registration is done successfully/ False if problem
	 *         occurs.
	 */
	public boolean addProfile(Profile profile) {
		try {
			int bul = searchList(profile.getUsername());
			if (bul == -1) {
				profileList.add(profile);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @param username
	 *            - Requires a username in order to search for the profile which
	 *            needs t be deleted.
	 * @return - True if deleted successfully./False if a problem occurs.
	 */
	public boolean removeProfile(String username) {
		int index = searchList(username);
		if (index != -1) {
			profileList.remove(index);
			return true;
		}
		return false;
	}

	/**
	 * Search method for the program.
	 * 
	 * @param username
	 *            - Searches with the username
	 * @return -1 if a profile hasn't been found./ Index of the profile in the
	 *         list, if a profile has been found.
	 */
	public int searchList(String username) {
		for (int i = 0; i < profileList.size(); i++) {
			if (username.equals(profileList.get(i).getUsername())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Authentification method.
	 * 
	 * @param username
	 *            - Searches with the username.
	 * @param password
	 *            - Searches with the password.
	 * @return -1 if a profile with the matching username and password hasn't
	 *         been found./The index of a profile with matching username and
	 *         password.
	 */
	public int searchList(String username, String password) {
		for (int i = 0; i < profileList.size(); i++) {
			if (username.equals(profileList.get(i).getUsername())) {
				if (password.equals(profileList.get(i).getPass())) {
					return i;
				}
			}
		}
		return -1;
	}

	public Profile getProfile(int index) {
		return this.profileList.get(index);
	}
	public boolean setProfile(Profile profile){
		int index = searchList(profile.getUsername());
		if(index!=-1){
				profileList.set(index, profile);
				return true;
		}
		return false;
	}
	public int getSize(){
		return this.profileList.size();
	}
}
