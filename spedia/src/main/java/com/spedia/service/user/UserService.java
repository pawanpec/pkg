package com.spedia.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spedia.dao.UserDao;
import com.spedia.model.User;

@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User registerUser(User user) {
		return userDao.persist(user);
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		Integer id=user.getUid();
		return userDao.findById(id);
	}

	@Override
	public User findByUserEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findByUserEmail(email);
	}

}
