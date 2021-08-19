package ru.bse71.learnup.dbexample.entities;

import javax.persistence.*;

/**
 * Created by bse71
 * Date: 18.08.2021
 * Time: 23:42
 */

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn
    private Post post;

    public Comment(Integer id, Post post, String text) {
        this.id = id;
        this.text = text;
        this.post = post;
    }

    public Comment() {

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
