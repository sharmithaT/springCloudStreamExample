package com.user.signup.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserSignupRequest {
	private User user;
	private Signup signup;
}
