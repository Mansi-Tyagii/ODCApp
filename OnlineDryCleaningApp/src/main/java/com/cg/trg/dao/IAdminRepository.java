package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * This is an Admin Repository Interface which Extends JpaRepository<Admin,Long>
 *
 */
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin,Long>{

}
