/**
 * 
 */
package com.spedia;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.spedia.dao.MongoDao;
import com.spedia.service.user.UserService;

/*
 * @author Pawan Goyal
 *
 */
@ContextConfiguration(locations = {"classpath*:spring-database.xml"})
public class JBSearchServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	/*@Autowired
	private UserService userService;*/
	@Autowired
	MongoDao mongoDao;
	
	
  
   @Test
    public void testJobSearch() {
        assertNotNull("UserService is null.", mongoDao);
    }

}
