package com.spedia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;





import org.springframework.stereotype.Repository;

import com.spedia.model.User;

@Repository("userDao") 
public class UserDaoImpl extends BaseDAOImpl<User, Long> implements UserDao {


	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		TypedQuery<User> query = getEntityManager().createQuery("from User where username=?",User.class).
				setParameter(1, username);
				users=query.getResultList();
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}