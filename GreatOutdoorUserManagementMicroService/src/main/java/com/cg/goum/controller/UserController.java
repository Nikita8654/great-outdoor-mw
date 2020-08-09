package com.cg.goum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.goum.exception.UserException;
import com.cg.goum.model.UserModel;
import com.cg.goum.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/login/{userId}/{pass}")
	public ResponseEntity<UserModel> userLogin(@PathVariable("userId") String userId,@PathVariable("pass") String pass) throws UserException {
		UserModel user=userService.userLogin(userId, pass);
		if(user!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping("/user/registration")
	public ResponseEntity<UserModel> userLogin(@RequestBody UserModel user) throws UserException {
		user=userService.userRegistration(user);
		if(user!=null) {
			return new ResponseEntity<>(user,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		}	
		
	}

}
