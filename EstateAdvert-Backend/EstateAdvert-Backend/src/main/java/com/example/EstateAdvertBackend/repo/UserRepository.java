package com.example.EstateAdvertBackend.repo;

import com.example.EstateAdvertBackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>{


    Optional<User> findByEmail(String email);
}

