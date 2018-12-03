package com.abhishek.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abhishek.app.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	@Query("FROM User Where userName=:username")
	User findByUsername(@Param("username") String username);
	
}
