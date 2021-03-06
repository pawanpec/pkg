/**
 * 
 */
package com.spedia.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.spedia.dao.ContentDao;
import com.spedia.dao.IReviewsDAO;
import com.spedia.dao.MongoDao;
import com.spedia.model.Content;
import com.spedia.model.Reviews;
import com.spedia.model.User;
import com.spedia.service.follow.IFollowService;
import com.spedia.utils.SEOURLUtils;
import com.spedia.utils.SocialUtility;
import com.spedia.utils.WebConstants;

/**
 * @author pawan
 * 
 */
@Controller
public class ContentController {
	private static Integer rowPerPage = 10;

	@Autowired
	@Qualifier("mongoDao")
	private MongoDao mongoDao;
	@Autowired
	private IReviewsDAO reviewsDao;

	@Autowired
	private IFollowService followService;
	@Autowired
	@Qualifier("contentDao")
	private ContentDao contentDao;

	@RequestMapping(value = { "/website.html" }, method = { RequestMethod.GET })
	public ModelAndView schoolDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("schoolHome");
		String url = request.getParameter("url");
		String msg = request.getParameter("msg");
		// String url="website/bal-bharti-pub-school-sector-14-rohini-delhi";
		DBObject content = mongoDao.getContentByURL(url);
		if (content != null) {
			Integer nid = (Integer) content.get("nid");
			List<Reviews> reviews = reviewsDao.findByNid(nid, 10);
			BasicDBObject basicDBObject = new BasicDBObject(
					"field_group.target_id", nid);
			DBCursor news = mongoDao.getContent(basicDBObject);
			model.put("content", content);
			model.put("reviews", reviews);
			model.put("news", news);
			model.put("newsCount", news.size());
			model.put("msg", msg);
		}
		view.addAllObjects(model);
		return view;

	}

	@RequestMapping(value = { "/content.html" }, method = { RequestMethod.GET })
	public ModelAndView contentDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("news");
		String url = request.getParameter("url");
		// String
		// url="nursery-admission/heritage-school-vasant-kunj-nursery-admission-schedule-and-criteria-session-2013";
		DBObject content = mongoDao.getContentByURL(url);
		if (content != null && content.containsField("field_group")) {
			DBObject field_group = (DBObject) content.get("field_group");
			if (field_group != null) {
				Integer groupId = (Integer) field_group.get("target_id");
				if (groupId != null) {
					DBObject group = mongoDao.getContentByNid(groupId);
					model.put("group", group);
				}
			}
		}
		model.put("content", content);
		String contentType = (String) content.get("type");
		DBObject query = new BasicDBObject();
		if (!SocialUtility.chkNull(contentType)
				&& contentType.contains("nursery")) {
			DBObject clause1 = new BasicDBObject("type", "nursery_admission");
			DBObject clause2 = new BasicDBObject("type",
					"nursery_admission_news");
			BasicDBList or = new BasicDBList();
			or.add(clause1);
			or.add(clause2);
			query = new BasicDBObject("$or", or);
		} else {
			query.put("type", contentType);
		}
		DBCursor contents = mongoDao.getContent(query).limit(10);
		model.put("relatedContent", contents);
		view.addAllObjects(model);
		return view;

	}

	@RequestMapping(value = { "/tags.html" }, method = { RequestMethod.GET })
	public ModelAndView getContentByTags(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("searchResult");
		String url = request.getParameter("url");
		String pageNumber = request.getParameter("pageNumber");
		Integer p = 0;
		if (!SocialUtility.chkNull(pageNumber)) {
			p = Integer.parseInt(pageNumber);
		}
		url = url.replace("-", " ");
		// String
		// url="nursery-admission/heritage-school-vasant-kunj-nursery-admission-schedule-and-criteria-session-2013";
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("tags", url);
		DBCursor contents = mongoDao.getContent(basicDBObject);
		model.put("contents", contents);
		Integer totalCount = contents.size();
		System.out.println("totalCount " + totalCount);
		model.put("contents", contents.skip(p * rowPerPage).limit(rowPerPage));
		model.put("totalCount", totalCount);
		model.put("rowsPerPage", rowPerPage);
		getLatestContent(model);
		view.addAllObjects(model);
		return view;

	}

	@RequestMapping(value = { "/contentType.html" }, method = { RequestMethod.GET })
	public ModelAndView getContentByType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("searchResult");
		String type = request.getParameter("type");
		String pageNumber = request.getParameter("pageNumber");
		Integer p = 0;
		if (!SocialUtility.chkNull(pageNumber)) {
			p = Integer.parseInt(pageNumber);
		}
		// String
		// url="nursery-admission/heritage-school-vasant-kunj-nursery-admission-schedule-and-criteria-session-2013";
		DBObject query = new BasicDBObject();
		if (!SocialUtility.chkNull(type) && type.contains("nursery")) {
			DBObject clause1 = new BasicDBObject("type", "nursery_admission");
			DBObject clause2 = new BasicDBObject("type",
					"nursery_admission_news");
			BasicDBList or = new BasicDBList();
			or.add(clause1);
			or.add(clause2);
			query = new BasicDBObject("$or", or);
		} else {
			query.put("type", type);
		}
		DBCursor contents = mongoDao.getContent(query);
		Integer totalCount = contents.size();
		System.out.println("totalCount " + totalCount);
		model.put("contents", contents.skip(p * rowPerPage).limit(rowPerPage));
		model.put("totalCount", totalCount);
		model.put("rowsPerPage", rowPerPage);
		getLatestContent(model);
		view.addAllObjects(model);
		return view;

	}

	@RequestMapping(value = { "/searchSchool.html" }, method = { RequestMethod.GET })
	public ModelAndView searchSchool(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		ModelAndView view = new ModelAndView("searchResult");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String postal_code = request.getParameter("postal_code");
		// String
		// url="nursery-admission/heritage-school-vasant-kunj-nursery-admission-schedule-and-criteria-session-2013";
		String pageNumber = request.getParameter("pageNumber");
		Integer p = 0;
		if (!SocialUtility.chkNull(pageNumber)) {
			p = Integer.parseInt(pageNumber);
		}
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("type", "group");
		if (!SEOURLUtils.chkNull(province)) {
			basicDBObject.put("location.province", province);
		}
		if (!SEOURLUtils.chkNull(city)) {
			basicDBObject.put("location.city", city);
		}
		if (!SEOURLUtils.chkNull(postal_code)) {
			basicDBObject.put("location.postal_code", postal_code);
		}
		DBCursor contents = mongoDao.getContent(basicDBObject);
		model.put("contents", contents);
		Integer totalCount = contents.size();
		System.out.println("totalCount " + totalCount);
		model.put("contents", contents.skip(p * rowPerPage).limit(rowPerPage));
		model.put("totalCount", totalCount);
		model.put("rowsPerPage", rowPerPage);
		getLatestContent(model);
		view.addAllObjects(model);
		return view;

	}

	@RequestMapping(value = { "/followSchool.html" }, method = { RequestMethod.GET })
	public @ResponseBody
	String followSchool(HttpServletRequest request, HttpServletResponse response) {
		try {
			Integer nid = Integer.parseInt(request.getParameter("nid"));
			String uidS = SocialUtility.getCookieByKey(request, "uid");
			Integer uid = Integer.parseInt(uidS);
			Integer status = Integer.parseInt(request.getParameter("status"));
			if (!SocialUtility.chkNull(uid)) {
				User user = new User();
				user.setUid(uid);
				if (status.equals(1)) {
					followService.follow(nid, user, true);
				}
				if (status.equals(0)) {
					followService.follow(nid, user, false);
					return "0";
				}

			}
			return "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = { "/index.html" }, method = { RequestMethod.GET })
	public ModelAndView home(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<DBObject> topSchools = mongoDao.getTopReviewedSchool();
		model.put("topSchools", topSchools);
		ModelAndView view = new ModelAndView("home");
		getLatestContent(model);
		view.addAllObjects(model);
		return view;
	}

	private void getLatestContent(Map<String, Object> model) {
		DBObject query = new BasicDBObject();
		DBObject clause1 = new BasicDBObject("type", "nursery_admission");
		DBObject clause2 = new BasicDBObject("type", "nursery_admission_news");
		DBObject clause3 = new BasicDBObject("type", "summer_camp");
		BasicDBList or = new BasicDBList();
		or.add(clause1);
		or.add(clause2);
		or.add(clause3);
		query = new BasicDBObject("$or", or);
		DBCursor contents = mongoDao.getContent(query).limit(10);
		model.put("relatedContent", contents);
	}

	@RequestMapping(value = "/savefbgroupdata.html")
	public @ResponseBody
	String saveFbGroupData(HttpServletRequest request,
			HttpServletResponse response) {
		String jsonData = request.getParameter("data");
		if (jsonData != null) {
			mongoDao.saveFBGroupData(jsonData);
		} else {
			return "error";
		}
		return "done";
	}

	@RequestMapping(value = { "/addNews.html" }, method = { RequestMethod.GET })
	public ModelAndView addNews(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		// Content content=new Content();
		ModelAndView view = new ModelAndView("addNews", "content",
				new Content());
		return view;
	}

	@RequestMapping(value = "/submitNews.html")
	public ModelAndView submit(
			@Valid @ModelAttribute("content") Content content,
			/* HttpServletRequest request */BindingResult result) {
		ModelAndView view = new ModelAndView("addNews");
		FileOutputStream outputStream = null;
		MultipartFile imageFile = content.getImageFile();
		if (imageFile != null && !imageFile.isEmpty()) {
			String filePath = WebConstants.contentImageDirectory
					+ imageFile.getOriginalFilename();
			content.setImagePath(filePath);
			// String path =
			// request.getSession().getServletContext().getContextPath();
			System.out.println(filePath);
			try {
				outputStream = new FileOutputStream(new File(filePath));
				FileCopyUtils.copy(imageFile.getInputStream(), outputStream);
				outputStream.close();
			} catch (Exception e) {
				System.out.println("not written");
				// e.printStackTrace();
			}
		} else {
			content.setImagePath(null);
		}
		content.setImageFile(null);
		String[] tags = content.getTags();
		String seourl = SEOURLUtils.getSEOURL(content.getType(),
				content.getTitle());
		content.setAlias(seourl);
		System.out.println(seourl);

		Long time = new Date().getTime();
		content.setCreated(time);
		if (content.getStatus() == 0) {
			content.setChanged(time);
		}
		contentDao.saveContent(content);
		return view;
	}

}
