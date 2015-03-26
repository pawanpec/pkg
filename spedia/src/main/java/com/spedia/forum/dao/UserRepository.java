package com.spedia.forum.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spedia.model.User;


@Repository
public interface UserRepository extends
		CrudRepository<User, BigInteger> {

}
