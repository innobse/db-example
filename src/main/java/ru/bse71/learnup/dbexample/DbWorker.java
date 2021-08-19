package ru.bse71.learnup.dbexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import ru.bse71.learnup.dbexample.entities.Post;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private SessionFactory sessionFactory;

    public void init() throws SQLException {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        this.sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public List<Post> getPosts() {
        try (Session session = sessionFactory.openSession()) {
            final Query<Post> query = session.createQuery("from Post", Post.class);
            return query.getResultList();
        }
    }

    public Set<Post> getPostsWithFetch() {
        try (Session session = sessionFactory.openSession()) {
            final Query<Post> query = session.createQuery("from Post p join fetch p.comments", Post.class);
            return new HashSet<>(query.getResultList());
        }
    }

    public boolean savePost(Post target) {
        try (Session session = sessionFactory.openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(target);
            transaction.commit();
            return true;
        }
    }
}
