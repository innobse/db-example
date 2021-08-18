package ru.bse71.learnup.dbexample.entities;

/**
 * Created by bse71
 * Date: 18.08.2021
 * Time: 23:42
 */

public class Comment {

    private int id;
    private String text;

    public Comment(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
