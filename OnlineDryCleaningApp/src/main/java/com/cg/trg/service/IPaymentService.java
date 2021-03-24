package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.AddPayment;
import com.cg.trg.entity.Payment;
import com.cg.trg.exception.PaymentException;
/**
 * 
 * @author Shruti
 * This is Payment Service Interface Class.
 * Contains Add,Remove,Update, Get and GetAll methods.
 */
public interface IPaymentService {
	public Payment addPayment(AddPayment addPayment) throws PaymentException;
	public void removePayment(Long paymentId) throws PaymentException;
	public Payment updatePayment( Payment payment) throws PaymentException;
	public Payment getPaymentDetails(Long paymentId) throws PaymentException;
	public List<Payment> getAllPaymentDetails() throws PaymentException;
}
