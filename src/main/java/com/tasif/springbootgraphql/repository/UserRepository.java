package com.tasif.springbootgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasif.springbootgraphql.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
