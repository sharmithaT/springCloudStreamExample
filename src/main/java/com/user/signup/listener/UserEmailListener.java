package com.user.signup.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.user.signup.model.Message;
import com.user.signup.streams.UserSignupStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserEmailListener {
	
	private final UserSignupStreams streams;
	
	public UserEmailListener(UserSignupStreams streams) {
		this.streams = streams;
	}

	@StreamListener(UserSignupStreams.EMAIL_IN)
	public void receiveEmailNotification(@Payload Message message) {
		log.info("Received a notification to send an email: {} to this userName: {}", message.getUser().getUserName(), message.getUser().getUserName());
	}
}
