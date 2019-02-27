package com.user.signup.service.impl;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.user.signup.model.Message;
import com.user.signup.model.User;
import com.user.signup.model.UserSignupRequest;
import com.user.signup.streams.UserSignupStreams;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserSignupServiceImpl {
	
	private final UserSignupStreams userSignupStreams;
	
	public UserSignupServiceImpl(UserSignupStreams userSignupStreams) {
		this.userSignupStreams = userSignupStreams;
	}

	public String userSignup(UserSignupRequest request) {
		if (request == null || request.getUser() == null || request.getSignup() == null) {
			log.warn("Invalid request parameters for user account creation..");
			return "Invalid request parameters for user account creation..";
		}
		
		User user = request.getUser();
		if (user.getUserName() == null || user.getUserName().trim().length() == 0) {
			log.warn("User Name is a required field to signup the account..");
			return "User Name is a required field to signup the account.";
		}
		log.info("Create a user account for this user: {} using method: {}", request.getUser().getUserName(), request.getSignup().getMethod());
		MessageChannel messageChannel = this.userSignupStreams.signupOutBound();
		Message message = Message.builder().user(request.getUser()).content("Created user successfully...").build();
		Boolean response = messageChannel.send(MessageBuilder.withPayload(message).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		return (response == null || response == false) ? "Something went wrong while sending an email to the user: "+request.getUser().getUserName() : "Sent a notification to the email..";
	}

}
