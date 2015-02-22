package com.spedia.service.review;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.spedia.dao.IReviewsDAO;
import com.spedia.dao.MongoDao;
import com.spedia.model.Reviews;
@Service("reviewService")
public class ReviewService implements IReviewService {
	@Autowired
	IReviewsDAO reviewsDao;
	@Autowired
	MongoDao mongoDao;

	@Override
	public Reviews writeReview(Reviews reviews) {
		 // TODO Auto-generated method stub
		reviews=reviewsDao.persist(reviews);
		return reviews;
	}
	@Override
	public Reviews rejectReview(Integer rid) {
		Reviews reviews=reviewsDao.findById(rid);
		reviews.setStatus(2);
		reviewsDao.persist(reviews);
		return reviews;
	}
	@Override
	public Reviews approveReview(Integer rid) {
		Reviews reviews=reviewsDao.findById(rid);
		reviews.setStatus(1);
		reviewsDao.persist(reviews);
		Integer nid=reviews.getNid();
		DBObject node=mongoDao.getContentByNid(nid);
		if (node.containsField("review")&& node.get("review")!=null) {
			DBObject review=(DBObject) node.get("review");
			Integer count = ((Number) review.get("count")).intValue();
			Double ora = ((Number) review.get("ora")).doubleValue();
			Double orb = ((Number) review.get("orb")).doubleValue();
			Double orc = ((Number) review.get("orc")).doubleValue();
			Double ord = ((Number) review.get("ord")).doubleValue();
			Double ore = ((Number) review.get("ore")).doubleValue();
			Double oar = ((Number) review.get("oar")).doubleValue();
			Integer newcount = count + 1;
			ora = (ora * count + reviews.getA()) / newcount;
			orb = (orb * count + reviews.getB()) / newcount;
			orc = (orc * count + reviews.getC()) / newcount;
			ord = (ord * count + reviews.getD()) / newcount;
			ore = (ore * count + reviews.getE()) / newcount;
			oar = (ora + orb + orc + ord + ore) / 5;
			review.put("ora", ora);
			review.put("orb", orb);
			review.put("orc", orc);
			review.put("ord", ord);
			review.put("ore", ore);
			review.put("oar", oar);
			review.put("count", newcount);
			node.put("review", review);
			WriteResult c=mongoDao.updateOverAllRating(node);
			System.out.println(c);
		}else{
			Double ora = reviews.getA()*1.0;
			Double orb = reviews.getB()*1.0;
			Double orc = reviews.getC()*1.0;
			Double ord = reviews.getD()*1.0;
			Double ore = reviews.getE()*1.0;
			Double oar = (ora + orb + orc + ord + ore) / 5;
			DBObject review=new BasicDBObject();
			review.put("_id", reviews.getNid());
			review.put("ora", ora);
			review.put("orb", orb);
			review.put("orc", orc);
			review.put("ord", ord);
			review.put("ore", ore);
			review.put("oar", oar);
			review.put("count", 1);
			node.put("review", review);
			WriteResult c=mongoDao.updateOverAllRating(node);
		}
		return null;
	}

	@Override
	public List<Reviews> findByNid(Integer nid, int i) {
		// TODO Auto-generated method stub
		return reviewsDao.findByNid(nid, i);
	}

	@Override
	public List<Reviews> getAllUnModeratedReviews() {
		// TODO Auto-generated method stub
		return reviewsDao.getAllUnModeratedReviews();
	}

}
