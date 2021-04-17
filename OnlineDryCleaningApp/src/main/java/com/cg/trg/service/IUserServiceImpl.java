package com.cg.trg.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.IAdminRepository;
import com.cg.trg.dao.ICustomerRepositoryDao;
import com.cg.trg.dao.IUserRepositoryDao;
import com.cg.trg.entity.Admin;
import com.cg.trg.entity.Customer;
import com.cg.trg.entity.User;
import com.cg.trg.exception.UserException;
/**
 * 
 * @author Mrunal
 * This is User Service Interface Implementation Class.
 * Performing SignUp,SignIn,EmailIdExists and ChangePassword methods
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService{
	@Autowired
	private IUserRepositoryDao iUserRepositoryDao;
	@Autowired
	private ICustomerRepositoryDao iCustomerRepositoryDao;
	@Autowired
	private IAdminRepository iAdminRepositoryDao;
	/**
     * This method is used to signUp User Using User Object
     */
	@Override
	public String signup(User user) throws UserException {
				try {		if(emailIdExists(user.emailId))
			{
				throw new UserException("EmailID already exists");
						
				}
				else {
		iUserRepositoryDao.save(user);

			if(user.getUserType().toLowerCase().equals("admin"))
			{Admin admin=new Admin(user.getUserId(),user.getName(),user.getEmailId(), user.getContactNo(),user);
			iAdminRepositoryDao.save(admin);
			}

			else if(user.getUserType().toLowerCase().equals("customer"))
			{
				Customer customer=new Customer(user.getUserId(),user.getName(),user.getEmailId(), user.getContactNo(),user);
				iCustomerRepositoryDao.save(customer);
			}
			return "Added!";
		}
				
				}
		catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	/**
     * This method is used to signIn User Using EmailId and Password
     */
	@Override
	public String SignIn(String emailId, String password, String userType) throws UserException {
		try {			
			Optional<User> optional = iUserRepositoryDao.findByEmailId(emailId);
			if(optional.isPresent()) {
				User user = optional.get();
				if(user.getPassword().equals(password)&& user.getUserType().equalsIgnoreCase(userType)) {
					return user.getUserType();
				}else {
					
					return "Please Enter Correct Password";
				}
			}else {
				return "No such User";
				
			}
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}

	/**
     * This method is used to Change the Password  Using EmailId and new Password
     */
	@Override
	public String changePassword(String emailId, String newPass) throws UserException {
		try {			
			Optional<User> optional = iUserRepositoryDao.findByEmailId(emailId);
			if(optional.isPresent()) {
				User user = optional.get();
			    user.setPassword(newPass);
				return "Password successfully changed";
				
				}
			else {
				return "User doesn't exist";
				
			}
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage());
		}catch(Exception e) {
			throw new UserException(e.getMessage());
		}
	}











	@Override
	public boolean emailIdExists(String emailId){
		String check = iUserRepositoryDao.findEmailId(emailId);
		if(check==null)
		{return false;
		} 
		return true;
	}

	
	}

	

	

