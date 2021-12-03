package com.H2Crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2Crud.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
}
