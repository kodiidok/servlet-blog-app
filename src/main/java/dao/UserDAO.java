package dao;

import bean.User;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public User getUserByUsername(String username) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			connection = DBConnection.getConnection();
			String query = "SELECT * FROM users WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("fullname"), resultSet.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResources(connection, preparedStatement, resultSet);
		}

		return user;
	}

	public List<User> getAllUsers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> users = new ArrayList<>();

		try {
			connection = DBConnection.getConnection();
			String query = "SELECT * FROM users";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				User user = new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("fullname"), resultSet.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResources(connection, preparedStatement, resultSet);
		}

		return users;
	}

	public boolean updateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean success = false;

		try {
			connection = DBConnection.getConnection();
			String query = "UPDATE users SET fullname = ?, email = ?, updated_at = CURRENT_TIMESTAMP WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getUsername());

			int rowsUpdated = preparedStatement.executeUpdate();

			success = rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResources(connection, preparedStatement, null);
		}

		return success;
	}

}
