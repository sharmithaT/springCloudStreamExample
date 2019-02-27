package com.user.signup.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.user.signup.streams.UserSignupStreams;

@EnableBinding(UserSignupStreams.class)
public class UserSignupConfig {

}
