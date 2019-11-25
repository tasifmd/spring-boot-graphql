package com.tasif.springbootgraphql.service;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.tasif.springbootgraphql.datafetcher.AllAddressDataFetcher;
import com.tasif.springbootgraphql.datafetcher.AllUserDataFetchers;
import com.tasif.springbootgraphql.datafetcher.SingleAddressDataFetcher;
import com.tasif.springbootgraphql.datafetcher.SingleUserDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Service
public class GraphQlService {

	private GraphQL graphQL;

	@Autowired
	private AllUserDataFetchers allUserDataFetcher;

	@Autowired
	private SingleUserDataFetcher singleUserDataFetcher;

	@Autowired
	private AllAddressDataFetcher allAddressDataFetcher;

	@Autowired
	private SingleAddressDataFetcher singleAddressDataFetcher;

	@Bean
	public GraphQL graphQL() {
		return graphQL;
	}

	@PostConstruct
	public void init() throws IOException {
		URL url = Resources.getResource("schema.graphql");
		String sdl = Resources.toString(url, Charsets.UTF_8);
		GraphQLSchema graphQLSchema = buildSchema(sdl);
		this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	private GraphQLSchema buildSchema(String sdl) {
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
		RuntimeWiring runtimeWiring = buildWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
	}

	private RuntimeWiring buildWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type(newTypeWiring("Query").dataFetcher("allUser", allUserDataFetcher))
				.type(newTypeWiring("Query").dataFetcher("user", singleUserDataFetcher))
				.type(newTypeWiring("Query").dataFetcher("allAddress", allAddressDataFetcher))
				.type(newTypeWiring("Query").dataFetcher("address", singleAddressDataFetcher))
				.build();
	}
}
