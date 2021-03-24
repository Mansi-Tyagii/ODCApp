package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.Feedback;
import com.cg.trg.exception.FeedbackException;
/**
 * 
 * 
 * This is Feedback Service Interface Class.
 * Contains Add,Remove,Update,Get and GetAll methods.
 * 
 */
public interface IFeedbackService {
	public Feedback addFeedback(Feedback feedback) throws FeedbackException;
	public void removeFeedback(Long feedbackNumber) throws FeedbackException;
	public Feedback updateFeedback(Feedback feedback) throws FeedbackException;
	public Feedback getFeedback(Long feedbackNumber) throws FeedbackException;
	public List<Feedback> getAllFeedback() throws FeedbackException;
}
