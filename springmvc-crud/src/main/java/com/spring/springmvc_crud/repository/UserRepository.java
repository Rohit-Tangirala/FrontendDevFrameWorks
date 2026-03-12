package com.spring.springmvc_crud.repository;
//dependency injection code

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.springmvc_crud.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}