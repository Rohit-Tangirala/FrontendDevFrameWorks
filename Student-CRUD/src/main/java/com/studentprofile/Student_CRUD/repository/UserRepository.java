package com.studentprofile.Student_CRUD.repository;


import com.studentprofile.Student_CRUD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
