package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.trg.entity.ItemCharges;
/**
 * 
 * This is an Item Charges Repository Interface which Extends JpaRepository
 *
 */
@Repository
public interface IItemChargesRepositoryDao extends JpaRepository<ItemCharges,Long>{

}
