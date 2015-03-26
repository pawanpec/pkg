package com.spedia.forum;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spedia.forum.dao.DiscussionThreadEntryRepository;
import com.spedia.forum.dao.DiscussionThreadRepository;
import com.spedia.forum.dao.UserRepository;


public class Repositories {

	private final static ApplicationContext ctx;

	static {
		ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

	public static UserRepository getUserDatastore() {
		return ctx.getBean(UserRepository.class);
	}

	public static DiscussionThreadRepository getDiscussionThreadDatastore() {
		return ctx.getBean(DiscussionThreadRepository.class);
	}

	public static DiscussionThreadEntryRepository getDiscussionThreadEntryDatastore() {
		return ctx.getBean(DiscussionThreadEntryRepository.class);
	}

}
