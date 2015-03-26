package com.spedia.forum.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.spedia.model.User;

@Document
public class DiscussionThreadEntry extends AbstractDocument {

	@DBRef
	private User user;
	private String content;
	private Date date;
	@Transient
	private String caption;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCaption() {
		return content.substring(0, 10).concat("...");
	}

	@Override
	public String toString() {
		return "DiscussionThreadEntry [user=" + user + ", content=" + content
				+ ", date=" + date + ", caption=" + getCaption() + "]";
	}

}
