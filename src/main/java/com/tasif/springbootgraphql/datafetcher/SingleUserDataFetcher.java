package com.tasif.springbootgraphql.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tasif.springbootgraphql.model.User;
import com.tasif.springbootgraphql.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class SingleUserDataFetcher implements DataFetcher<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User get(DataFetchingEnvironment dataFetchingEnvironment) {
		int userId = Integer.parseInt(dataFetchingEnvironment.getArgument("userId"));
		return userRepository.findById(userId).get();
	}

}
