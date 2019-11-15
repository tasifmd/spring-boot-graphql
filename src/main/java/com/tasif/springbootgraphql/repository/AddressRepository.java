package com.tasif.springbootgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasif.springbootgraphql.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
