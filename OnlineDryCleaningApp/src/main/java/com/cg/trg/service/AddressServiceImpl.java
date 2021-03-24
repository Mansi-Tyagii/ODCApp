package com.cg.trg.service;

import java.util.List;
/**
 * 
 * @author Pravartika
 * This is Address Service Interface Implementation Class.
 * Performing Add,Remove,Update and Get methods in this implementing class.
 */
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.trg.dao.IAddressRepository;
import com.cg.trg.dao.ICustomerRepositoryDao;
import com.cg.trg.entity.AddAddress;
import com.cg.trg.entity.Address;
import com.cg.trg.entity.Customer;
import com.cg.trg.exception.AddressException;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private IAddressRepository addressDao; 
	
	  @Autowired
	     private ICustomerRepositoryDao customerDao;
/**
 * This method is used to Add Address Using  AddAddress Object
 */
	@Override
    public Address addAddress(AddAddress addAddress) throws AddressException {
        Address add=new Address();
        Long custId=addAddress.getCustomerId();
       
        try
        {
        	add.setArea(addAddress.getArea());
        	add.setCity(addAddress.getCity());
        	add.setDoorNo(addAddress.getDoorNo());
        	add.setPincode(addAddress.getPincode());
        	add.setStreet(addAddress.getStreet());
        	add.setState(addAddress.getState());
        	
           
            
            if(custId != null)
            {
                Optional<Customer> optional=customerDao.findById(custId);
                if(optional.isPresent())
                {
                    add.setCustomer(optional.get());
                }
            }

 
            addressDao.save(add);
            return add;
        }
        
        catch(Exception e)
        {
            throw new AddressException(e.getMessage());
        }
    }
	/**
	 * This method is used to Remove Address Using  AddressId 
	 */
	@Override
	public void removeAddress(long addressId) throws AddressException {
		try {
			addressDao.deleteById(addressId);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AddressException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AddressException(e.getMessage());
		}
		
	}
	/**
	 * This method is used to Update Address Using  Address Object
	 */
	@Override
	public Address updateAddress(Address address) throws AddressException {
		try {
			return addressDao.save(address);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new AddressException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new AddressException(e.getMessage());
		}
	}
	/**
	 * This method is used to Get all Address 
	 */
	@Override
	public List<Address> getAllAddress() throws AddressException {
		try {
			return addressDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to CustomerException
			throw new AddressException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to CustomerException
			throw new AddressException(e.getMessage());
		}
	}

}