package com.spedia.dao;

import com.spedia.model.User;


public interface UserDao {

	User findByUserName(String username);

}