package com.user.signup.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Signup {

	private String method;
	private String dateTime;
}
