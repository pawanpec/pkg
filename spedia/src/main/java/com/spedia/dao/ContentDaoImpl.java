package com.spedia.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.spedia.model.Content;
import com.spedia.utils.MongoConstants;

@Repository("contentDao")
public class ContentDaoImpl implements ContentDao {
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public void saveContent(Content content) {
		mongoTemplate.save(content, MongoConstants.FIELDS_CURRENT_NODE);
	}
}
