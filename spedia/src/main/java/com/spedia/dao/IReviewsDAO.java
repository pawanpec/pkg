package com.spedia.dao;

import java.util.List;

import com.spedia.model.Reviews;



/**
 * Interface for ReviewsDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IReviewsDAO {

	List<Reviews> findByNid(Integer nid, int i);

}