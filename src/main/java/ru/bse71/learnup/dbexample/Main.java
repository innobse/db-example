package ru.bse71.learnup.dbexample;

import ru.bse71.learnup.dbexample.entities.Post;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bse71
 * Date: 18.08.2021
 * Time: 23:24
 */

public class Main {

    public static void main(String[] args) throws SQLException {
        DbWorker db = new DbWorker();
        db.init();
        final List<Post> posts = db.getPosts();
        for (Post post : posts) {
            System.out.println(post);
        }

//        db.savePost(new Post(999, "title 999", "ololo"));
    }

}
