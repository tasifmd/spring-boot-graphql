package com.tasif.springbootgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.springbootgraphql.dto.CreateUserDto;
import com.tasif.springbootgraphql.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody CreateUserDto createUserDto) {
		String response = userService.createUser(createUserDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@PostMapping("/addaddress")
	public ResponseEntity<String> addAddressToUser(@RequestParam int userId,@RequestParam int addressId) {
		String response = userService.addAddressToUser(userId, addressId);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}

}
