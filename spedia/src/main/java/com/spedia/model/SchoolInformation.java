package com.spedia.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SchoolInformation {
	private MultipartFile logoFile;
	private MultipartFile[] imageGallery;
	private MultipartFile backgroundImage;
	private Integer sid;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public MultipartFile getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(MultipartFile logoFile) {
		this.logoFile = logoFile;
	}

	public MultipartFile[] getImageGallery() {
		return imageGallery;
	}

	public void setImageGallery(MultipartFile[] imageGallery) {
		this.imageGallery = imageGallery;
	}

	public MultipartFile getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(MultipartFile backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
}
