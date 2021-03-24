package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Payment;
/**
 * 
 * This is an Payment Repository Interface which Extends JpaRepository
 *
 */
@Repository
public interface IPaymentRepositoryDao extends JpaRepository<Payment,Long>{

}
