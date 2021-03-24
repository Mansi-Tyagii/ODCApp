package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Address;
/**
 * 
 * This is an Address Repository Interface which Extends JpaRepository
 *
 */
@Repository
public interface IAddressRepository extends JpaRepository<Address,Long>{

}
