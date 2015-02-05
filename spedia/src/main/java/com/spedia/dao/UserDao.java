package com.spedia.dao;

import com.spedia.model.User;


public interface UserDao extends BaseDao<User, Long>  {

	User findByUserName(String username);

}