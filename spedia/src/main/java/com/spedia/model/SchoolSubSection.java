/**
 * 
 */
package com.spedia.model;

import org.bson.types.ObjectId;

import com.mongodb.ReflectionDBObject;

/**
 * @author pawan
 *
 */
public class SchoolSubSection extends ReflectionDBObject {
	private String title;
	private String text;
	private String image;
	public SchoolSubSection() {
		super();
		set_id(ObjectId.get());
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
