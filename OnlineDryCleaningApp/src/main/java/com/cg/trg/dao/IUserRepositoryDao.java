package com.cg.trg.dao;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.User;
/**
 * 
 * This is an User Repository Interface which Extends JpaRepository
 *
 */
@Repository
public interface IUserRepositoryDao extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.emailId = ?1")
	Optional<User> findByEmailId(String emailId);	
	@Query("Select u.emailId FROM User u WHERE u.emailId = ?1")
	String findEmailId(String emailId);	
	
	
}
