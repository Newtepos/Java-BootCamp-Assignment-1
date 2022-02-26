package com.example.shoppingapp.repository;

import com.example.shoppingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
