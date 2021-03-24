package com.cg.trg.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.IFeedbackRepositoryDao;
import com.cg.trg.entity.Feedback;
import com.cg.trg.exception.FeedbackException;
/**
 * 
 *
 * This is Feedback Service Interface Implementation Class.
 * Performing Add,Remove,Update,Get and GetAll methods in this implementing class.
 */
@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired 
	private IFeedbackRepositoryDao iFeedbackRepositoryDao;
	/**
     * This method is used to Add Feedback Using Feedback Object
     */
	@Override
	public Feedback addFeedback(Feedback feedback) throws FeedbackException {
		try {			
			return iFeedbackRepositoryDao.save(feedback);
		}catch(DataAccessException e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}
	}
	/**
     * This method is used to Remove Feedback Using FeedbackNumber
     */
	@Override
	public void removeFeedback(Long feedbackNumber) throws FeedbackException {
		try {
			iFeedbackRepositoryDao.deleteById(feedbackNumber);
		}catch(DataAccessException e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}

	}
	/**
     * This method is used to Update Feedback Using Feedback 
     */
	@Override
	public Feedback updateFeedback(Feedback feedback) throws FeedbackException {
		try {
			return iFeedbackRepositoryDao.save(feedback);
		}catch(DataAccessException e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}
	}
	/**
     * This method is used to Get Feedback Using FeedbackNumber 
     */
	@Override
	public Feedback getFeedback(Long feedbackNumber) throws FeedbackException {
		try {
			Optional<Feedback> optional= iFeedbackRepositoryDao.findById(feedbackNumber);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Feedback Number");
			}
		}catch(DataAccessException e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}
	}
	/**
     * This method is used to GetAll Feedback  
     */
	@Override
	public List<Feedback> getAllFeedback() throws FeedbackException {
		try {
			return iFeedbackRepositoryDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to FeedbackException
			throw new FeedbackException(e.getMessage());
		}
	}
}


