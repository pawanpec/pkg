/**
 * 
 */
package com.spedia;

import junit.framework.TestCase;

import org.junit.Assert;
import org.mvel2.ast.AssertNode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spedia.service.review.IReviewService;

/**
 * @author P.GHOSHAL
 *
 */
public class BaseSpringTest extends TestCase {
	
	private static BaseSpringTest testContext = null;
	 
    ApplicationContext context = null;
 
    private BaseSpringTest() {
    }
 
    public static BaseSpringTest getInstance()
    {
        if (testContext == null) {
            testContext = new BaseSpringTest();
            testContext.initialise();
        }
        return testContext;
    }
 
    public void initialise() {
    	String[] paths = { 
		"src/main/webapp/WEB-INF/test_spring-database.xml",
		"src/main/webapp/WEB-INF/spring-security.xml"
		};
    	context = new FileSystemXmlApplicationContext(paths);
    }
 
    public Object getBean(String name) {
        return context.getBean(name);
    }
 
    public ApplicationContext getSpringContext() {
        return context;
    }
    public static void main(String[] args) {
    	IReviewService reviewService = (IReviewService) BaseSpringTest.getInstance()
				.getBean("reviewService");
    	assertNotNull(reviewService);
	}
}
