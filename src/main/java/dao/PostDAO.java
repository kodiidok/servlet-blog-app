package dao;

import bean.Post;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    public List<Post> getAllPosts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Post> posts = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM posts";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Post post = new Post(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getTimestamp("created_at"),
                    null // Set author, comments, and tags later
                );
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResources(connection, preparedStatement, resultSet);
        }

        return posts;
    }

    // Add other CRUD operations as needed

}
