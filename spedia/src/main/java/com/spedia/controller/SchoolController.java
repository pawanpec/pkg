package com.spedia.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.DBObject;
import com.spedia.dao.MongoDao;
import com.spedia.model.SchoolBean;
import com.spedia.model.SchoolInformation;
import com.spedia.model.SchoolPhotoVideoBean;
import com.spedia.utils.WebConstants;

@Controller
public class SchoolController {
	@Autowired
	@Qualifier("mongoDao")
	private MongoDao mongoDao;

	@RequestMapping(value = { "/editSchoolInfo.html" }, method = { RequestMethod.GET })
	public ModelAndView editSchoolDetails(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView view = new ModelAndView("editSchoolInfo",
				"schoolInformation", new SchoolInformation());
		return view;

	}

	@RequestMapping(value = { "/submitSchoolInfo.html" }, method = { RequestMethod.POST })
	public ModelAndView submitSchoolDetails(
			@Valid @ModelAttribute("schoolInformation") SchoolInformation schoolInformation,
			BindingResult result) throws FileNotFoundException {
		ModelAndView view = new ModelAndView("editSchoolInfo",
				"schoolInformation", schoolInformation);
		SchoolBean schoolsImages = new SchoolBean();
		Integer sid = schoolInformation.getSid();
		for (MultipartFile mfile : schoolInformation.getImageGallery()) {
			System.out.println(mfile.getOriginalFilename());
		}
		String fileUploadPath=WebConstants.schoolImageDirectory+"/"+sid+"/";
		File file = new File(fileUploadPath);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
				fileUploadPath=WebConstants.schoolImageDirectory;
			}
		}
		MultipartFile logoImageFile = schoolInformation.getLogoFile();
		if (logoImageFile != null && !logoImageFile.isEmpty()) {
			String filePath = fileUploadPath+logoImageFile.getOriginalFilename();
			uploadFile(logoImageFile, filePath);
			schoolsImages.setLogoPath(filePath.substring(filePath.indexOf("images")));
			System.out.println(filePath);
		}
		MultipartFile backGroundImage = schoolInformation.getBackgroundImage();
		if (backGroundImage != null && !backGroundImage.isEmpty()) {
			String filePath = fileUploadPath+backGroundImage.getOriginalFilename();
			uploadFile(backGroundImage, filePath);
			schoolsImages.setBackGroundImagePath(filePath.substring(filePath.indexOf("images")));
			System.out.println(filePath);
		}
		MultipartFile[] imageGallery = schoolInformation.getImageGallery();
		List<SchoolPhotoVideoBean> list = new ArrayList<SchoolPhotoVideoBean>();
		if (imageGallery != null) {
			for (MultipartFile mFile : imageGallery) {
				if (mFile != null && !mFile.isEmpty()) {
					String filePath = fileUploadPath
							+ mFile.getOriginalFilename();
					SchoolPhotoVideoBean bean = new SchoolPhotoVideoBean();
					bean.setMediaUrl(filePath.substring(filePath.indexOf("images")));
					list.add(bean);
					System.out.println(filePath);
					uploadFile(mFile, filePath);
				}
			}
			schoolsImages.setPhotoVedioBean(list);
		}

		
		DBObject schoolInfo = mongoDao.getContentByNid(sid);

		schoolInfo.put("schoolsImages", schoolsImages);
		mongoDao.updateSchoolInformation(sid, schoolInfo);
		return view;

	}

	private void uploadFile(MultipartFile imageFile, String filePath) {
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(filePath));
			FileCopyUtils.copy(imageFile.getInputStream(), outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			// System.out.println("not written");
			e.printStackTrace();
		}
	}

}
