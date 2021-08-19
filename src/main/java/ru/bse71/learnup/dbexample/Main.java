package ru.bse71.learnup.dbexample;

import ru.bse71.learnup.dbexample.entities.Comment;
import ru.bse71.learnup.dbexample.entities.Post;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
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


//        final Post post = new Post(null, "title 555", "ololo555");
//        post.setComments(
//                Collections.singletonList(
//                        new Comment(null, post, "comment!")));
//        db.savePost(post);

        final Collection<Post> posts = db.getPostsWithFetch();  // N+1 getPosts()
        for (Post tmp : posts) {
            System.out.println(tmp);
        }


    }

}
