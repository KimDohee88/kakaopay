package com.example.kakaopay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kakaopay.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

}
