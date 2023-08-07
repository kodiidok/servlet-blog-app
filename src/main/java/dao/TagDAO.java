package dao;

import bean.Tag;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagDAO {

    public List<Tag> getTagsForPost(int postId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tag> tags = new ArrayList<>();

        try {
            connection = DBConnection.getConnection();
            String query = "SELECT * FROM post_tags WHERE post_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, postId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Tag tag = new Tag(
                    resultSet.getInt("id"),
                    resultSet.getString("name")
                );
                tags.add(tag);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeResources(connection, preparedStatement, resultSet);
        }

        return tags;
    }

    // Add other CRUD operations as needed

}
