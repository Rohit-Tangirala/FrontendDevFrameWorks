package com.example.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.*;

import com.example.hibernate.model.User;
import com.example.hibernate.util.HibernateUtil;

public class UserDAO {

    public void saveUsers(List<User> users) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            for (User u : users) {
                session.persist(u);
            }
            tx.commit();
        }
    }

    public List<User> getUsersWithCriteria() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
            JpaCriteriaQuery<User> cq = cb.createQuery(User.class);
            JpaRoot<User> root = cq.from(User.class);

            JpaPredicate p1 = cb.ge(root.get("rollno"), 10);
            JpaPredicate p2 = cb.like(root.get("name"), "P%");

            cq.select(root)
              .where(cb.and(p1, p2))
              .orderBy(cb.asc(root.get("rollno")));

            return session.createQuery(cq).getResultList();
        }
    }
}
