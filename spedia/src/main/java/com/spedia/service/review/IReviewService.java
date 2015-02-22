package com.spedia.service.review;

import java.util.List;

import com.spedia.model.Reviews;

public interface IReviewService {

	public Reviews writeReview(Reviews reviews);
	public Reviews approveReview(Integer rid);
	public List<Reviews> findByNid(Integer nid, int i) ;
	public List<Reviews> getAllUnModeratedReviews();
	Reviews rejectReview(Integer rid);
}
