package com.arvato.jesy.lifematters.repositories;

import java.util.Optional;

import com.arvato.jesy.lifematters.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}