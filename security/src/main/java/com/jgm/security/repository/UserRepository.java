package com.jgm.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgm.security.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
