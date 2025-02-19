package com.example.springtodomanagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springtodomanagement.Model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	Optional<User> findByUsername(String username);
	
	boolean existsByEmail(String email);
	
	Optional<User> findByUsernameOrEmail(String username,String email);
}
