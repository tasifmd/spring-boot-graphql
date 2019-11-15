package com.tasif.springbootgraphql.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.springbootgraphql.dto.CreateAddressDto;
import com.tasif.springbootgraphql.model.Address;
import com.tasif.springbootgraphql.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public String createAddress(CreateAddressDto createaddressDto) {
		Address address = modelMapper.map(createaddressDto, Address.class);
		addressRepository.save(address);
		return "Address added";
	}

}
