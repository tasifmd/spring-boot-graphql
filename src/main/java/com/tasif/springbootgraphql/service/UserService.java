package com.tasif.springbootgraphql.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.springbootgraphql.dto.CreateUserDto;
import com.tasif.springbootgraphql.model.User;
import com.tasif.springbootgraphql.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public String createUser(CreateUserDto createUserDto) {
		User user = modelMapper.map(createUserDto, User.class);
		userRepository.save(user);
		return "User created successfully";
	}
}
