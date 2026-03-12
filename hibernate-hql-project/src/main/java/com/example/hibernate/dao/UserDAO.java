package com.example.hibernate.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.example.hibernate.model.User;
import com.example.hibernate.util.HibernateUtil;

public class UserDAO {

    public void saveUser(User user) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
    }

    public List<User> getUsersWithRollnoAndName() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM User u WHERE u.rollno >= :minRoll AND u.name LIKE :pattern";
            Query<User> q = session.createQuery(hql, User.class);
            q.setParameter("minRoll", 10);
            q.setParameter("pattern", "P%");
            return q.list();
        }
    }
}
