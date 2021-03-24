package com.cg.trg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.trg.entity.User;
import com.cg.trg.exception.UserException;
import com.cg.trg.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 
 * This is an User Controller
 *
 */
@Api
@RestController
@RequestMapping("/api/uc")
@CrossOrigin(origins = "*")
public class UserController {


	@Autowired
	IUserService service;
	
	/**
	 * 
	 * @param user
	 * Signup User
	 * @return
	 */
	@ApiOperation(value = "Signup User",
	response = String.class,
	consumes = "user Object",
	tags = "register user",
	httpMethod = "POST")	
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		try {
			String  details= service.signup(user);
			return new ResponseEntity<>(details, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	} 
	
	
	/**
	 * 
	 * @param emailId
	 * @param password
	 * Sign In
	 * @return
	 */
	@ApiOperation(value = "Sign In",
			response = String.class,
			consumes = "user Object",
			tags = "sign in",
			httpMethod = "GET")
	@GetMapping("/signin/{emailId}/{password}")
	public ResponseEntity<String> signIn(@PathVariable String emailId,@PathVariable String password){
		try {
			String sign = service.SignIn(emailId,password);
			return new ResponseEntity<>(sign, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param emailId
	 * @param newPass
	 * Change Password
	 * @return
	 */
	@ApiOperation(value = "Change Password",
			response = String.class,
			consumes = "user Object",
			tags = "change password",
			httpMethod = "PUT")
	@PutMapping("/changePassword/{emailId}/{newPass}")
	public ResponseEntity<String> changePassword(@PathVariable String emailId,@PathVariable String newPass){
		try {
			String cPass = service.changePassword(emailId,newPass);
			return new ResponseEntity<>(cPass, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	
}
