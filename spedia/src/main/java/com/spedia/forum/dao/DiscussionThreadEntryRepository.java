package com.spedia.forum.dao;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.spedia.forum.model.DiscussionThreadEntry;


public interface DiscussionThreadEntryRepository extends
		PagingAndSortingRepository<DiscussionThreadEntry, BigInteger> {

}
