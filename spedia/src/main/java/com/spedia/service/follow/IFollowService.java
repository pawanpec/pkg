package com.spedia.service.follow;

import com.mongodb.WriteResult;
import com.spedia.model.User;

public interface IFollowService {
	public WriteResult follow(Integer nid,User user,Boolean status) ;

}
