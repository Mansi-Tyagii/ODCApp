package com.cg.trg.service;

import java.util.List;

import com.cg.trg.entity.ItemCharges;
import com.cg.trg.exception.ItemChargesException;
/**
 * 
 * @author Shivam
 * This is ItemCharges Service Interface Class.
 * Contains Add,Remove,Update, Get and GetAll methods.
 */
public interface IItemChargesService {
	public ItemCharges addItemCharges(ItemCharges itemCharges)throws ItemChargesException;
	public void removeItemCharges(long itemChargesId)throws ItemChargesException;
	public ItemCharges updateItemCharges(ItemCharges itemCharges)throws ItemChargesException;
	public ItemCharges getItemCharges(long itemChargesId)throws ItemChargesException;
	public List<ItemCharges> getAllItemCharges()throws ItemChargesException;
}
