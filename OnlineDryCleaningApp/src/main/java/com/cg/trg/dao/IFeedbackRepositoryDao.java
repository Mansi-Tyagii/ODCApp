package com.cg.trg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.trg.entity.Feedback;
/**
 * 
 * This is an Feedback Repository Interface which Extends JpaRepository
 *
 */
@Repository
public interface IFeedbackRepositoryDao extends JpaRepository<Feedback,Long>{

}
