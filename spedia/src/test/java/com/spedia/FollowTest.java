package com.spedia;

import com.spedia.dao.MongoDao;
import com.spedia.model.User;

import junit.framework.TestCase;

public class FollowTest extends TestCase {
	
	public void testFollow(){
		MongoDao mongoDao=(MongoDao)
				  BaseSpringTest.getInstance().getBean("mongoDao");
		Integer nid=240;
		User user=new User();
		user.setUid(4);
		mongoDao.follow(nid, user,false);
	}

}
