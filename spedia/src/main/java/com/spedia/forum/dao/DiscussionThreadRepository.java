package com.spedia.forum.dao;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spedia.forum.model.DiscussionThread;

public interface DiscussionThreadRepository extends
		PagingAndSortingRepository<DiscussionThread, BigInteger> {

}
