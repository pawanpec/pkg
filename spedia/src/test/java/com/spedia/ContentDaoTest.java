/**
 * 
 */
package com.spedia;

import junit.framework.TestCase;

import com.spedia.dao.ContentDao;
import com.spedia.model.Content;
import com.spedia.model.Reviews;
import com.spedia.service.review.IReviewService;

/**
 * @author pawan
 *
 */
public class ContentDaoTest extends TestCase {
	public void testSaveContent() {
		ContentDao contentDao = (ContentDao) BaseSpringTest.getInstance()
				.getBean("contentDao");
		Content content=new Content();
		content.setTitle("test title");
		content.setBody("test body");
		contentDao.saveContent(content);
	}
}
