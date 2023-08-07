package dao;

import bean.Comment;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    public List<Comment> getCommentsForPost(int postId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Comment> comments = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM comments WHERE post_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, postId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment(
                    resultSet.getInt("id"),
                    resultSet.getString("text"),
                    resultSet.getTimestamp("created_at"),
                    null, // Set author later
                    null  // Set post later
                );
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResources(connection, preparedStatement, resultSet);
        }

        return comments;
    }

    // Add other CRUD operations as needed

}
