package com.spedia.service.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.spedia.dao.MongoDao;
import com.spedia.model.User;
@Service("followService")
public class FollowService implements IFollowService {
	@Autowired
	MongoDao mongoDao;
	@Override
	public WriteResult follow(Integer nid, User user,Boolean status) {
		return mongoDao.follow(nid, user,status);
	}

}
