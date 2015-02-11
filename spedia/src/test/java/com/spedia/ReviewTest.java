package com.spedia;

import com.spedia.model.Reviews;
import com.spedia.service.review.IReviewService;

import junit.framework.TestCase;

public class ReviewTest extends TestCase {
	/*public void testWriteReview() {
		IReviewService reviewService = (IReviewService) BaseSpringTest.getInstance()
				.getBean("reviewService");
		String reviewText="very good";
		Long created=System.currentTimeMillis();
		Reviews reviews=new Reviews(600,2,"rohini",125,reviewText,4,5,4,3,4,0,created.intValue());
		reviewService.writeReview(reviews);
	}*/
	public void testApproveReview() {
		IReviewService reviewService = (IReviewService) BaseSpringTest.getInstance()
				.getBean("reviewService");
		reviewService.approveReview(1859);
	}
}
