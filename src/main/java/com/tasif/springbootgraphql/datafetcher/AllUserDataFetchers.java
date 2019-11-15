package com.tasif.springbootgraphql.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tasif.springbootgraphql.model.User;
import com.tasif.springbootgraphql.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllUserDataFetchers implements DataFetcher<List<User>>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> get(DataFetchingEnvironment environment) {
		return userRepository.findAll();
	}
	
}
