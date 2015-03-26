package com.spedia.forum.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spedia.model.User;

@Document
public class DiscussionThread extends AbstractDocument {

	@DBRef
	private Set<DiscussionThreadEntry> threads = new HashSet<>();
	@DBRef
	private User createdBy;
	private String title;
	private Date date;

	public Set<DiscussionThreadEntry> getThreads() {
		return threads;
	}

	public void setThreads(Set<DiscussionThreadEntry> threads) {
		this.threads = threads;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DiscussionThread [threads=" + threads + ", createdBy="
				+ createdBy + ", title=" + title + ", date=" + date + "]";
	}

}
