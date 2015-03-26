package com.spedia.forum;

import org.junit.BeforeClass;

import com.spedia.forum.dao.DiscussionThreadEntryRepository;
import com.spedia.forum.dao.DiscussionThreadRepository;
import com.spedia.forum.dao.UserRepository;


public abstract class AbstractMongoDBTest {

	/**
	 * please store Starter or RuntimeConfig in a static final field if you want
	 * to use artifact store caching (or else disable caching)
	 */
	static DiscussionThreadRepository dtRepository;
	static DiscussionThreadEntryRepository dtEntryRepository;
	static UserRepository userRepository;

	@BeforeClass
	public static void setUp() throws Exception {
		userRepository = Repositories.getUserDatastore();
		dtRepository = Repositories.getDiscussionThreadDatastore();
		dtEntryRepository = Repositories.getDiscussionThreadEntryDatastore();
	}

	/*@AfterClass
	public static void tearDown() throws Exception {

		_mongod.stop();
		_mongodExe.stop();
	}
*/
}