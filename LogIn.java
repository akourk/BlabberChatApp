/**
 * CLASS:       CS410 Software Engineering
 * ASSIGNMENT:  Development Phase 1
 * TEAM:        Brandae Grein, Michael Thomas, Alex Kourkoumelis, Matthew Clark, Jordi Monterrubio
**/
// Package Main.
package BlabberVMichaels;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class LogIn {
	private Map<String, String> hashedAccPass = new HashMap<>();
	private String fileName = "Blabber/login.txt";
	private final String CONFIG_FILE = "config.users";


	public LogIn() {
		String line = "";

		// try {
			// load user config file
			Properties props = new Properties();
			try {
				File configFile = new File(CONFIG_FILE);
				FileReader reader = new FileReader(configFile);
				props.load(reader);
			}
			catch (Exception e) {
				// user config file does not exist
				// create user config file
				try {
					File newConfigFile = new File(CONFIG_FILE);
					FileWriter write = new FileWriter(CONFIG_FILE);
					props.store(write, "user settings");
				}
				catch (Exception ex) {
					this.displayErrorMessage("Login loading error", ex.toString());
				}
			}

			for (String key : props.stringPropertyNames()) {
				String value = props.getProperty(key);
				hashedAccPass.put(key, value);
			}



			/*
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				String[] arr = line.split("   ");
				hashedAccPass.put(arr[0], arr[1]);
			}
			bufferedReader.close();


		} catch (FileNotFoundException ex) {
			System.out.println("Unable to find database containing login info.");
		} catch (IOException ex) {
			System.out.println("Error reading database login contents.");
			ex.printStackTrace();
		}
		*/
	}

	private String encrypt(String username, String password) {
		username += ".";
		username += password;
		password = "";
		for (int i = 0; i < username.length(); i++) {
			char c = username.charAt(i);
			if (i % 2 == 0) {
				c += 3;
			} else {
				c -= 2;
			}
			password += Character.toString(c);
		}

		return password;
	}

	private boolean exists(String username) {
		return hashedAccPass.containsKey(username);
	}

	public boolean createAccount(String username, String password) {
		String passwordEncrypted = encrypt(username, password);

		// plows over old entries
		// hashedAccPass.put(username, encrypt(username, password));

		String checkExists = hashedAccPass.get(username);
		if (checkExists == null || checkExists.isEmpty()) {

			Properties props = new Properties();
			try {
				File configFile = new File(CONFIG_FILE);
				FileReader reader = new FileReader(configFile);
				props.load(reader);
				props.setProperty(username, passwordEncrypted);
				FileWriter write = new FileWriter(configFile);
				props.store(write, "settings");
				hashedAccPass.put(username, encrypt(username, passwordEncrypted));
			}
			catch (Exception e) {
				displayErrorMessage("Failed to store new user", e.toString());
				return false;
			}
		}
		else {
			displayErrorMessage("Username already exists", "");
			return false;
		}

		return true;

		/*
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),
				"utf-8"))) {
			for(Map.Entry<String, String> entry : hashedAccPass.entrySet()) {
				writer.write(entry.getKey() + "   " + entry.getValue() + "\n");
			}
		} catch (IOException ex) {
			System.out.println("Error reading database login contents.");
			ex.printStackTrace();
		}
		*/
	}

	public boolean validate(String username, String password) {
		if(exists(username)){
			return (hashedAccPass.get(username).equals(encrypt(username, password)));
		} else {
			return false;
		}
	}

	private void displayErrorMessage(String message, String exception) {
		JOptionPane.showMessageDialog(null,
				message + " " + exception, "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}