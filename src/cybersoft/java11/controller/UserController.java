package cybersoft.java11.controller;

import java.util.List;

import cybersoft.java11.connection.ConnectDatabase;
import cybersoft.java11.model.User;

public class UserController {
	private List<User> userList;
	private ConnectDatabase connectDatabase;

	/*
	 * CONTRUCTORS
	 */
	public UserController() {
		connectDatabase = new ConnectDatabase();
	}

	/*
	 * METHODS
	 */
	public List<User> findAll() {
		return connectDatabase.getUserList();
	}

	public int add(User user) {
		if (user == null) {
			return 0;// user is null
		}
		if ("".equals(user.getUsername()) || "".equals(user.getPassword())) {
			return 2;// user is null
		}
		for (User e : userList) {
			if (e.getUsername().equalsIgnoreCase(user.getUsername())) {
				return 3;// user is existed
			}
		}
		userList.add(user);
		return 1;// add successfully
	}

	public boolean remove(String username) {
		for (User e : userList) {
			if (e.getUsername().equalsIgnoreCase(username)) {
				userList.remove(e);
				return true;
			}
		}
		return false;
	}

	public boolean update(String username, User user) {
		for (int i = 0; i < userList.size(); i++) {
			User curUser = userList.get(i);

			if (!curUser.getUsername().equalsIgnoreCase(username)) {
				continue;
			}

			user.setUsername(username);
			userList.set(i, user);
			return true;
		}
		return false;
	}

}
