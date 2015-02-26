package com.spedia.service.user;

import com.spedia.model.User;

public interface IUserService {
	User registerUser(User user);
	User getUser(User user);
	User findByUserEmail(String email);

}
