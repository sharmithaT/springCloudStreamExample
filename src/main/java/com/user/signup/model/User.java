package com.user.signup.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class User {

	private String id;
	private String fullName;
	private String userName;
}
