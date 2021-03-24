package com.cg.trg.dao;

import java.util.Optional;
/**
 * 
 * This is an Customer Repository Interface which Extends JpaRepository
 *
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Customer;
@Repository
public interface ICustomerRepositoryDao extends JpaRepository<Customer,Long>{

}
