package com.spedia.model;

import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.ReflectionDBObject;

public class SchoolBean extends ReflectionDBObject{
	
	private String BackGroundImagePath;
	private String LogoPath;
	List<SchoolPhotoVideoBean> photoVedioBean;
	List<SchoolSubSection> schoolSubSection;
	public SchoolBean() {
		super();
		set_id(ObjectId.get());
	}
	
	public List<SchoolPhotoVideoBean> getPhotoVedioBean() {
		return photoVedioBean;
	}
	public void setPhotoVedioBean(List<SchoolPhotoVideoBean> photoVedioBean) {
		this.photoVedioBean = photoVedioBean;
	}
	public List<SchoolSubSection> getSchoolSubSection() {
		return schoolSubSection;
	}
	public void setSchoolSubSection(List<SchoolSubSection> schoolSubSection) {
		this.schoolSubSection = schoolSubSection;
	}

	public String getBackGroundImagePath() {
		return BackGroundImagePath;
	}

	public void setBackGroundImagePath(String backGroundImagePath) {
		BackGroundImagePath = backGroundImagePath;
	}

	public String getLogoPath() {
		return LogoPath;
	}

	public void setLogoPath(String logoPath) {
		LogoPath = logoPath;
	}
}
