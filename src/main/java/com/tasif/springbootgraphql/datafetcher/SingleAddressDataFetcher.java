package com.tasif.springbootgraphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tasif.springbootgraphql.model.Address;
import com.tasif.springbootgraphql.repository.AddressRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class SingleAddressDataFetcher implements DataFetcher<Address> {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address get(DataFetchingEnvironment dataFetchingEnvironment) {
		int addressId = Integer.parseInt(dataFetchingEnvironment.getArgument("addressId"));
		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new RuntimeException("No address exist with address id " + addressId));
		return address;
	}

}
