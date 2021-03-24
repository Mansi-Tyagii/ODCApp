package com.cg.trg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.trg.entity.ItemCharges;
import com.cg.trg.exception.ItemChargesException;
import com.cg.trg.service.IItemChargesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * This is an Admin Controller
 *
 */
@Api
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private IItemChargesService itemChargesService;
	/**
	 *
	 * @param itemChargesId
	 * Get Item Charges by Id
	 * @return
	 */
	@ApiOperation(value = "Get Item Charges by Id",
			response = ItemCharges.class,
			tags = "get-charges-by-id",
			consumes = "itemChargesId",
			httpMethod = "GET")
	@GetMapping("/admin/{itemChargesId}")
	public ResponseEntity<ItemCharges> getItemCharges(@PathVariable long itemChargesId){
		try {
			ItemCharges ic = itemChargesService.getItemCharges(itemChargesId);
			return new ResponseEntity<>(ic, HttpStatus.OK);
		}catch(ItemChargesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}

	/**
	 * Get all Item charges
	 * @return
	 */
	@ApiOperation(value = "Get all Item charges",
			response = ItemCharges.class,
			tags = "get-all-itemcharges",			
			httpMethod = "GET")
	@GetMapping("/admin")
	public ResponseEntity<List<ItemCharges>> getAllItemCharges(){
		try {
			List<ItemCharges> icList = itemChargesService.getAllItemCharges();
			return new ResponseEntity<>(icList, HttpStatus.OK);
		}catch(ItemChargesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param itemCharges
	 * Add item charge
	 * @return
	 */
	@ApiOperation(value = "Add item charge",
			response = ItemCharges.class,
			consumes = "itemCharges",
			tags = "ItemCharges record",
			httpMethod = "POST")
	@PostMapping("/admin")
	public ResponseEntity<ItemCharges> addItemCharges(@RequestBody ItemCharges itemCharges) {
		try {
			ItemCharges emp= itemChargesService.addItemCharges(itemCharges);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}catch(ItemChargesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param itemCharges
	 * Update item charges
	 * @return
	 */
	@ApiOperation(value = "Update item charges",
			response = ItemCharges.class,
			consumes = "itemCharges ",
			tags = "Update ItemCharges  record",
			httpMethod = "PUT")
	@PutMapping("/admin")
	public ResponseEntity<ItemCharges> updateItemCharges(@RequestBody ItemCharges itemCharges) {
		try {
			ItemCharges emp= itemChargesService.updateItemCharges(itemCharges);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}catch(ItemChargesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	
	/**
	 * 
	 * @param itemChargesId
	 * Delete item charges
	 * @return
	 */
	@ApiOperation(value = "Delete item charges",
			response = String.class,
			consumes = "itemChargesId",
			tags = "Delete itemCharges record",
			httpMethod = "DELETE")
	@DeleteMapping("/admin/{itemChargesId}")
	public ResponseEntity<String> removeItemCharges(@PathVariable long itemChargesId) {
		try {
			itemChargesService.removeItemCharges(itemChargesId);
			return new ResponseEntity<>("Item Charge deleted", HttpStatus.OK);
		}catch(ItemChargesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
