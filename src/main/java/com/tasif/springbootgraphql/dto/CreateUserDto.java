package com.tasif.springbootgraphql.dto;

import lombok.Data;

@Data
public class CreateUserDto {
	private String userName;
	private String userEmail;
	private String userMobile;
}
