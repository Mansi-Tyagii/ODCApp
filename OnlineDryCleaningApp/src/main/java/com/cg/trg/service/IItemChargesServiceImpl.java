package com.cg.trg.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.trg.dao.IItemChargesRepositoryDao;
import com.cg.trg.entity.ItemCharges;
import com.cg.trg.exception.ItemChargesException;
/**
 * 
 * @author Shivam
 * This is ItemCharges Service Interface Implementation Class.
 * Performing Add,Remove,Update, Get and GetAll methods.
 */
@Service
@Transactional
public class IItemChargesServiceImpl implements IItemChargesService {
	
	@Autowired
	private IItemChargesRepositoryDao iItemChargesRepositoryDao;
	/**
     * This method is used to Add ItemCharges Using ItemCharges Object
     */
	@Override
	public ItemCharges addItemCharges(ItemCharges itemCharges) throws ItemChargesException {
		try {			
			return iItemChargesRepositoryDao.save(itemCharges);
		}catch(DataAccessException e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}

	}
	/**
     * This method is used to Remove ItemCharges Using ItemChargesId
     */
	@Override
	public void removeItemCharges(long itemChargesId) throws ItemChargesException {
		try {
			iItemChargesRepositoryDao.deleteById(itemChargesId);
		}catch(DataAccessException e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}
	}
	/**
     * This method is used to Update ItemCharges Using ItemCharges Object
     */
	@Override
	public ItemCharges updateItemCharges( ItemCharges itemCharges) throws ItemChargesException {
		try {
			return iItemChargesRepositoryDao.save(itemCharges);
		}catch(DataAccessException e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}
	}
	/**
     * This method is used to Get ItemCharges Using ItemChargesId
     */
	@Override
	public ItemCharges getItemCharges(long itemChargesId) throws ItemChargesException {
		try {
			Optional<ItemCharges> optional= iItemChargesRepositoryDao.findById(itemChargesId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid itemChargeId");
			}
		}catch(DataAccessException e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}
	}
	/**
     * This method is used to GetAll ItemCharges 
     */
	@Override
	public List<ItemCharges> getAllItemCharges() throws ItemChargesException {
		try {
			return iItemChargesRepositoryDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to ItemChargesException
			throw new ItemChargesException(e.getMessage());
		}
	}

}
