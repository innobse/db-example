package ru.bse71.learnup.dbexample;

import ru.bse71.learnup.dbexample.entities.Comment;
import ru.bse71.learnup.dbexample.entities.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bse71
 * Date: 18.08.2021
 * Time: 23:43
 */

public class DbWorker {

    private Connection connection;
    private String dbUrl = "jdbc:postgresql:posts";
    private String user = "postgres";
    private String pass = "dzVkh";

    public void init() throws SQLException {
        this.connection = DriverManager.getConnection(dbUrl, user, pass);
    }

    public List<Post> getPosts() throws SQLException {
        final Statement statement = connection.createStatement();
        final PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM comments WHERE post_id = ?;");

        final ResultSet resultSet = statement.executeQuery("SELECT * FROM posts;");
        List<Post> result = new ArrayList<>();
        while (resultSet.next()) {
            final int id = resultSet.getInt("id");
            final String title = resultSet.getString("title");
            final String text = resultSet.getString("text");

            preparedStatement.setInt(1, id);
            final ResultSet commentsResultSet = preparedStatement.executeQuery();
            final List<Comment> comments = getCommentsFromResultSet(commentsResultSet);

            final Post post = new Post(id, title, text);
            post.setComments(comments);

            result.add(post);
        }
        return result;
    }

    public boolean savePost(Post target) throws SQLException {
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO posts(id, title, text) VALUES(?, ?, ?);");

        preparedStatement.setInt(1, target.getId());
        preparedStatement.setString(2, target.getTitle());
        preparedStatement.setString(3, target.getText());

        final boolean result = preparedStatement.execute();

        if (result) return saveComments(target.getComments(), target.getId());
        return false;
    }

    private boolean saveComments(List<Comment> comments, int postId) throws SQLException {
        if (comments == null) return true;
        final PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO comments(id, post_id, text) VALUES(?, ?, ?);");

        for (Comment comment : comments) {
            preparedStatement.setInt(1, comment.getId());
            preparedStatement.setInt(2, postId);
            preparedStatement.setString(3, comment.getText());

            if (!preparedStatement.execute()) return false;
        }

        return true;
    }

    private List<Comment> getCommentsFromResultSet(ResultSet resultSet) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        while (resultSet.next()) {
            final int id = resultSet.getInt("id");
            final String text = resultSet.getString("text");

            comments.add(
                    new Comment(id, text));
        }

        return comments;
    }
}
