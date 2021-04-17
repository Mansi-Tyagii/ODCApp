package com.cg.trg.service;

import org.springframework.stereotype.Service;
/**
 * 
 * @author Mrunal
 * This is User Service Interface Class.
 * Contains SignUp,SignIn,EmailIdExists and ChangePassword methods.
 */
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.entity.User;
import com.cg.trg.exception.UserException;
@Service
@Transactional
public interface IUserService {

	public String signup(User user) throws  UserException;
	//public String SignIn(String emailId, String password) throws UserException;
	public boolean emailIdExists(String emailId) ;
	public String changePassword(String emailId, String newPass) throws UserException;
	public String SignIn(String emailId, String password, String userType) throws UserException;
	
}
