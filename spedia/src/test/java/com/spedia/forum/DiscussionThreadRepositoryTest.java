package com.spedia.forum;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.spedia.forum.model.DiscussionThread;
import com.spedia.forum.model.DiscussionThreadEntry;
import com.spedia.model.User;

public class DiscussionThreadRepositoryTest extends AbstractMongoDBTest {
	
	/*@Test
	public void testGetThread() throws Exception {
		BigInteger id;
		Iterable<DiscussionThread> pThread = dtRepository.findAll();
		for (DiscussionThread discussionThread : pThread) {
			System.out.println(discussionThread);
		}
	}*/

	/*@Test
	public void testCreateThread() throws Exception {
		User u = new User();
		u.setUsername("pawanpec");
		u.setUid(1234);
		userRepository.save(u);
		assertNotNull(u.getUid());

		DiscussionThread thread = new DiscussionThread();
		thread.setDate(new Date());
		thread.setTitle("Test");
		thread.setCreatedBy(u);
		thread = dtRepository.save(thread);
		assertNotNull(thread.getId());
		System.out.println("thread id " + thread.getId());

		DiscussionThread pThread = dtRepository.findOne(thread.getId());
		assertNotNull(pThread);
		assertNotNull(pThread.getCreatedBy());
	}
*/
	@Test
	public void testCreateThreadEntries() throws Exception {
		User u = new User();
		u.setUsername("pawanpec");
		userRepository.save(u);
		assertNotNull(u.getId());

		DiscussionThread thread = new DiscussionThread();
		thread.setDate(new Date());
		thread.setTitle("Test");
		thread.setCreatedBy(u);
		thread = dtRepository.save(thread);
		assertNotNull(thread.getId());
		System.out.println("thread id " + thread.getId());
		for (int i = 0; i < 10; i++) {
			User u1 = new User();
			u1.setUsername("pawanpec");
			userRepository.save(u1);
			assertNotNull(u1.getId());

			DiscussionThreadEntry entry = new DiscussionThreadEntry();
			entry.setDate(new Date());
			entry.setUser(u1);
			entry.setContent("content added by user" + i);
			entry = dtEntryRepository.save(entry);
			assertNotNull(entry.getId());

			thread.getThreads().add(entry);
			thread = dtRepository.save(thread);

			assertEquals(i + 1, dtRepository.findOne(thread.getId())
					.getThreads().size());
		}

		System.out.println(thread);
	}
}
