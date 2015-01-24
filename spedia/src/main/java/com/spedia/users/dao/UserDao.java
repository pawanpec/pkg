package com.spedia.users.dao;

import com.spedia.users.model.User;

public interface UserDao {

	User findByUserName(String username);

}