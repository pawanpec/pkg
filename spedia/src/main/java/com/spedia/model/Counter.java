package com.spedia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Counter {
	@Id
	private String id;
	private int seq;

	/* getters & setters .. */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
}
