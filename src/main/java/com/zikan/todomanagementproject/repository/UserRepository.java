package com.zikan.todomanagementproject.repository;

import com.zikan.todomanagementproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByEmail (String email); // This mtd check if email already exists in the db

    Optional <User> findByUsernameOrEmail (String username, String email);

}
