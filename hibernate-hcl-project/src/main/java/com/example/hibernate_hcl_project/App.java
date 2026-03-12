package com.example.hibernate_hcl_project;

import java.util.Arrays;
import java.util.List;

import com.example.hibernate.dao.UserDAO;
import com.example.hibernate.model.User;
import com.example.hibernate.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        List<User> users = Arrays.asList(
            new User(1, "Ramesh"),
            new User(10, "Prasanna"),
            new User(11, "Prasad"),
            new User(12, "Paul"),
            new User(21, "Pavan"),
            new User(30, "Pravin")
        );

        dao.saveUsers(users);

        List<User> result = dao.getUsersWithCriteria();
        for (User u : result) {
            System.out.println(u);
        }

        HibernateUtil.shutdown();
    }
}
