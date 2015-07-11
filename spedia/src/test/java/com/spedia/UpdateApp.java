package com.spedia;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.spedia.model.Counter;


public class UpdateApp {

	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		
		System.out.println("\nCase 6");
		Query query = new Query(where("_id").is("_id"));
		Update inc = new Update().inc("seq", 1);
		Counter counter = mongoOperation.findAndModify(query,
				inc, new FindAndModifyOptions().upsert(true).returnNew(true),Counter.class);
        System.out.println(counter.getSeq());
	/*	Query query6 = new Query();
		query6.addCriteria(Criteria.where("name").is("appleF"));

		Update update6 = new Update();
		update6.set("age", 101);
		update6.set("ic", 1111);

		User userTest6 = mongoOperation.findAndModify(query6, update6,
				new FindAndModifyOptions().upsert(true).returnNew(true), User.class);
		System.out.println("userTest6 - " + userTest6);
*/
		//mongoOperation.dropCollection(User.class);

	}

}
