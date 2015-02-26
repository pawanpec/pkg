package com.spedia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;





import org.springframework.stereotype.Repository;

import com.spedia.model.User;

@Repository("userDao") 
public class UserDaoImpl extends BaseDAOImpl<User, Integer> implements UserDao{


	@SuppressWarnings("unchecked")
	public User findByUserEmail(String email) {

		List<User> users = new ArrayList<User>();

		TypedQuery<User> query = getEntityManager().createQuery("from User where mail=?",User.class).
				setParameter(1, email);
				users=query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}