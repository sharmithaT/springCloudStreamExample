package com.user.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.signup.model.UserSignupRequest;
import com.user.signup.service.impl.UserSignupServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserSignupController {
	
	@Autowired
	private UserSignupServiceImpl userSignupServiceImpl;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody UserSignupRequest request) {
		log.info("Create a user account");
		String response = this.userSignupServiceImpl.userSignup(request);
		log.info("Response data for user account creation: {}", response);
		return ResponseEntity.ok(response);
	}
}
