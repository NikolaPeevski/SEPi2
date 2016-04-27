package com.Clerver.domain.mediator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.Clerver.domain.model.ProfileList;

public class IOManager {
	private String filenameI;

	/**
	 * Standart constructor, tries to create a folder and a file for the storage
	 * of User data.
	 */
	public IOManager() {
		filenameI = "Content/Data.bin";
		String folderDir = "Content";
		try {
			new File(folderDir).mkdir();
			new File(filenameI).createNewFile();
		} catch (Exception E) {

		}
		;
	}

	/**
	 * Loads userdata into a profile list and returns it. If no data/file is found or error happens returns a new, empty ProfileList.
	 */
	public ProfileList load() {
		try {
			FileInputStream InS = new FileInputStream(filenameI);
			ObjectInputStream in = new ObjectInputStream(InS);
			try {
				ProfileList list = (ProfileList) in.readObject();
				in.close();
				return list;
			} catch (Exception e) {
			}

		} catch (Exception e) {
		}
		;
		return new ProfileList();
	}
	/**
	 * Saves userdata into a binary file. Hopefully no errors happen here, which the construct insures because it creates a file.
	 */
	public void save(ProfileList list) {
		try {
			FileOutputStream outS = new FileOutputStream(filenameI);
			ObjectOutputStream out = new ObjectOutputStream(outS);

			out.writeObject(list);
			System.out.println("Successful save");
			out.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
