/**
 * 
 */
package com.spedia;

import junit.framework.TestCase;

import com.spedia.dao.ContentDao;
import com.spedia.model.Content;
import com.spedia.model.Reviews;
import com.spedia.service.CounterService;
import com.spedia.service.review.IReviewService;

/**
 * @author pawan
 *
 */
public class ContentDaoTest extends TestCase {
	public void testSaveContent() {
		ContentDao contentDao = (ContentDao) BaseSpringTest.getInstance()
				.getBean("contentDao");
		CounterService counterService = (CounterService) BaseSpringTest.getInstance()
				.getBean("counterService");
		Content content=new Content();
		content.set_id(counterService.getNextSequence("_id"));
		content.setTitle("test title");
		content.setBody("test body");
		content.setType("123");
		contentDao.saveContent(content);
	}
}
