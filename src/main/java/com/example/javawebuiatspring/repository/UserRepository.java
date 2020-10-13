package com.example.javawebuiatspring.repository;

import com.example.javawebuiatspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByAgeBetween(int minAge, int maxAge);
}
