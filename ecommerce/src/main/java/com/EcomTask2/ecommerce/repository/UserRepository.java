package com.EcomTask2.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.EcomTask2.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}