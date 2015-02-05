package com.spedia.dao;

import java.util.List;

import com.spedia.model.Reviews;
import com.spedia.model.User;



/**
 * Interface for ReviewsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IReviewsDAO extends BaseDao<Reviews, Integer>{
	public List<Reviews> findByNid(Integer nid, int i);


}