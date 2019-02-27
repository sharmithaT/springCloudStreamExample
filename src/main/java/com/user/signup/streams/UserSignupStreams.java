package com.user.signup.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserSignupStreams {

	String SIGNUP_IN = "signup-in";
	String SIGNUP_OUT = "signup-out";
	String EMAIL_IN = "email-in";
	String EMAIL_OUT = "email-out";
	
	@Input(SIGNUP_IN)
	SubscribableChannel signupInBound();
	
	@Output(SIGNUP_OUT)
	MessageChannel signupOutBound();
	
	@Input(EMAIL_IN)
	SubscribableChannel emailInBound();
	
	@Output(EMAIL_OUT)
	MessageChannel emailOutBound();
	
}
