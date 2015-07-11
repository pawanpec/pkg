package com.spedia.service;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.spedia.model.Counter;

@Service("counterService")
public class CounterService {
	@Autowired
	MongoTemplate mongoTemplate;

	public int getNextSequence(String fieldName) {
		Query query = new Query(where("_id").is(fieldName));
		Update inc = new Update().inc("seq", 1);
		Counter counter = mongoTemplate.findAndModify(query,
				inc, new FindAndModifyOptions().upsert(true).returnNew(true),Counter.class);

		return counter.getSeq();
	}
}
