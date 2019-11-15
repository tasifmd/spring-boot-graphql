package com.tasif.springbootgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.springbootgraphql.dto.CreateUserDto;
import com.tasif.springbootgraphql.provider.GraphQlProvider;
import com.tasif.springbootgraphql.service.UserService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private GraphQlProvider garphQlProvider;

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody CreateUserDto createUserDto) {
		String response = userService.createUser(createUserDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PostMapping("/getuser")
	ResponseEntity<Object> getUsers(@RequestBody String query) {
		ExecutionResult execute = garphQlProvider.graphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
