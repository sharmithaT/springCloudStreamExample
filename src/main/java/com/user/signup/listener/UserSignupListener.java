package com.user.signup.listener;

import java.util.Date;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.user.signup.model.Message;
import com.user.signup.streams.UserSignupStreams;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserSignupListener {
	
	private final UserSignupStreams streams;
	
	public UserSignupListener(UserSignupStreams streams) {
		this.streams = streams;
	}
	
	@StreamListener(UserSignupStreams.SIGNUP_IN)
	public void handleEmailRequest(@Payload Message message) {
		if (message == null || message.getUser() == null) {
			log.warn("Invalid email creation happen fot this time: {}", new Date());
			return;
		}
		log.info("Request received to send an email to the user: {}", message.getUser().getUserName());
		
		MessageChannel messageChannel = this.streams.emailOutBound();
		messageChannel.send(MessageBuilder.withPayload(message).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
	}
}
