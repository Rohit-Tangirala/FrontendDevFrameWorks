package com.example.hibernate_hql_project;


import java.util.List;
import com.example.hibernate.dao.UserDAO;
import com.example.hibernate.model.User;
import com.example.hibernate.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        dao.saveUser(new User(10, "Prasad"));
        dao.saveUser(new User(11, "Prasanna"));
        dao.saveUser(new User(5, "Rahul"));

        List<User> users = dao.getUsersWithRollnoAndName();
        for (User u : users) {
            System.out.println(u);
        }

        HibernateUtil.shutdown();
    }
}
