package com.tasif.springbootgraphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tasif.springbootgraphql.model.Address;
import com.tasif.springbootgraphql.repository.AddressRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllAddressDataFetcher implements DataFetcher<List<Address>>{

	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public List<Address> get(DataFetchingEnvironment environment) {
		return addressRepository.findAll();
	}

}
