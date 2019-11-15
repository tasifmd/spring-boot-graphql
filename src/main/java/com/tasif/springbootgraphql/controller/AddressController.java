package com.tasif.springbootgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.springbootgraphql.dto.CreateAddressDto;
import com.tasif.springbootgraphql.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<String> createAddress(@RequestBody CreateAddressDto createAddressDto){
		String response = addressService.createAddress(createAddressDto);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
