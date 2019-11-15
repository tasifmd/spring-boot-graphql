package com.tasif.springbootgraphql.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.springbootgraphql.dto.CreateUserDto;
import com.tasif.springbootgraphql.model.Address;
import com.tasif.springbootgraphql.model.User;
import com.tasif.springbootgraphql.repository.AddressRepository;
import com.tasif.springbootgraphql.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public String createUser(CreateUserDto createUserDto) {
		User user = modelMapper.map(createUserDto, User.class);
		userRepository.save(user);
		return "User created successfully";
	}
	
	public String addAddressToUser(int userId,int addressId) {
		User user= userRepository.findById(userId).get();
		Address address = addressRepository.findById(addressId).get();
		user.getAddresses().add(address);
		userRepository.save(user);
		return "Address added to user";
	}
}
