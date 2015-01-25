package com.spedia.model;

import org.bson.types.ObjectId;

import com.mongodb.ReflectionDBObject;

public class SchoolPhotoVideoBean extends ReflectionDBObject{

	private int mediaType;
	private String mediaUrl;
	private String mediaText;

	public SchoolPhotoVideoBean() {
		super();
		set_id(ObjectId.get());
	}

	public int getMediaType() {
		return mediaType;
	}

	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getMediaText() {
		return mediaText;
	}

	public void setMediaText(String mediaText) {
		this.mediaText = mediaText;
	}

}
