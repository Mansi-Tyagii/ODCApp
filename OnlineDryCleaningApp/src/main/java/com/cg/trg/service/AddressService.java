package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.AddAddress;
import com.cg.trg.entity.Address;
import com.cg.trg.exception.AddressException;

/**
 * 
 * @author Pravartika
 * This is Address Service Interface Class.
 * Contains Add,Remove,Update and Get methods
 * 
 */
public interface AddressService {
	public Address addAddress(AddAddress addAddress)throws AddressException;
	public void removeAddress(long addressId)throws AddressException;
	public Address updateAddress(Address address)throws AddressException;
	public List<Address> getAllAddress()throws AddressException; 

}