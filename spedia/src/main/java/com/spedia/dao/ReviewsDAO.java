package com.spedia.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.spedia.model.Reviews;

/**
 * A data access object (DAO) providing persistence and search support for
 * Reviews entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.spedia.content.model.Reviews
 * @author MyEclipse Persistence Tools
 */
@Repository("reviewsDao")
public class ReviewsDAO extends BaseDAOImpl<Reviews, Integer> implements IReviewsDAO{

	@Override
	public List<Reviews> findByNid(Integer nid, int i) {
	
	TypedQuery<Reviews> query = getEntityManager().createQuery("from Reviews where nid=?",Reviews.class).
			setParameter(1, nid);
		return query.getResultList();
	}

	@Override
	public List<Reviews> getAllUnModeratedReviews() {
		TypedQuery<Reviews> query = getEntityManager().createQuery("from Reviews where status=0",Reviews.class);
		return query.getResultList();
	}

	
}