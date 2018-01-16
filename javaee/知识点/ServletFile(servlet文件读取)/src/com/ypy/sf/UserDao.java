package com.ypy.sf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class UserDao {
	private String filename;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@SuppressWarnings("resource")
	public boolean login(User user) {
		Scanner scanner;
		
		try {
			scanner = new Scanner(new File(filename));
		
			while (scanner.hasNext()) {
				String[] arr = scanner.nextLine().split(",");
				if (arr[0].equals(user.getUsername()) && arr[1].equals(user.getPassword())) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
