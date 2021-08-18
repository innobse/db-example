package ru.bse71.learnup.dbexample.entities;

import java.util.List;

/**
 * Created by bse71
 * Date: 18.08.2021
 * Time: 23:41
 */

public class Post {

    private int id;
    private String title;
    private String text;

    private List<Comment> comments;

    public Post(int id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("Post id: %d\n%s\n%s\n", id, title, text));

        for (Comment comment : comments) {
            sb
                    .append(
                            String.format("\t%s\n", comment.getText()));
        }

        return sb.toString();
    }
}
