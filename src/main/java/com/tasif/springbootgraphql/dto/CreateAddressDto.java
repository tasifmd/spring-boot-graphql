package com.tasif.springbootgraphql.dto;

import lombok.Data;

@Data
public class CreateAddressDto {
	private String addressLine1;
	private String addressLine2;
	private String addressType;
	private String district;
	private String state;
	private int zipCode;
}
