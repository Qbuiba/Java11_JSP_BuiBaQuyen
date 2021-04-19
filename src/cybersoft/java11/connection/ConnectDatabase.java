package cybersoft.java11.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.model.User;

public class ConnectDatabase {

	String url = "jdbc:mysql://localhost:3306/test_db";
	String usernameRoot = "root";
	String passwordRoot = "1234";

	String sql = "select * from users";

	public ConnectDatabase() {

	}

	public List<User> getUserList() {
		List<User> userList = new LinkedList<User>();
		try (Connection connection = DriverManager.getConnection(url, usernameRoot, passwordRoot)) {
			// Read all user
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			// Add to userList
			while (result.next()) {
				String username = result.getString(1);
				String password = result.getString(2);
				String fullname = result.getString(3);
				int role = result.getInt(4);
				int yearofbirth = result.getInt(5);

				userList.add(new User(username, password, fullname, role, yearofbirth));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}
}
