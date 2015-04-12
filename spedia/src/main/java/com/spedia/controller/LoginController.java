package com.spedia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.WriteResult;
import com.spedia.dao.MongoDao;
import com.spedia.model.User;
import com.spedia.model.UserRole;
import com.spedia.service.user.UserService;
import com.spedia.utils.SocialUtility;
import com.sun.org.apache.xpath.internal.operations.Bool;


@Controller
public class LoginController {
	@Autowired
	@Qualifier("mongoDao")
	private MongoDao mongoDao;
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired @Qualifier("authenticationManagerAutoLogin")
	private AuthenticationManager authenticationManagerAutoLogin;
	
	@RequestMapping(value = { "/", "/userHome.html" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This is default page!");
		model.setViewName("userHome");
		return model;

	}
	@RequestMapping(value = { "/logout.html" }, method = { RequestMethod.GET })
	public @ResponseBody String logOut(HttpServletRequest request, HttpServletResponse response) {
		CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
		SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
		cookieClearingLogoutHandler.logout(request, response, null);
		securityContextLogoutHandler.logout(request, response, null);
		removeUserDataInSession(response);
		return "1";
	}
	@RequestMapping(value = { "/registerUser.html" }, method = { RequestMethod.GET })
	public @ResponseBody String registerUser(HttpServletRequest request, HttpServletResponse response) {
		String data=request.getParameter("data");
		String socialType=request.getParameter("socialType");
		User user=SocialUtility.getUserFromJson(data);
		String email=user.getMail();
		User userExist=userService.findByUserEmail(email);
		String status="1";
		if (userExist==null) {
			user.setSocialType(socialType);
			user.setPassword(SocialUtility.getMD5(user.getSocialLoginId()));
			user = userService.registerUser(user);
			WriteResult writeResult = mongoDao.saveUserFbData(data);
			System.out.println(writeResult.getUpsertedId());
			setUserDataInSession(response,user);
			status="0";
		}else{
			setUserDataInSession(response,userExist);
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(email);
		Boolean autoLogin=doAutoLogin(userDetails);
		if(!autoLogin){
			//login false
			status="-1";
		}
		return status;
	}
	private void setUserDataInSession(HttpServletResponse response, User userExist) {
		Set<UserRole>  userroles=userExist.getUserRoleses();
		List<String> roles=new ArrayList();
		for (UserRole userRole : userroles) {
			roles.add(userRole.getRole());
		}
		Boolean isAdmin=false;
		if(roles!=null){
		 isAdmin=roles.contains("ROLE_ADMIN");
		}
		SocialUtility.addCookie("username", userExist.getUsername(), response);
		SocialUtility.addCookie("isAdmin", isAdmin.toString(), response);
		SocialUtility.addCookie("email", userExist.getMail(), response);
		SocialUtility.addCookie("uid", userExist.getUid()+"", response);
		SocialUtility.addCookie("socialLoginId", userExist.getSocialLoginId(), response);
	}
	private void removeUserDataInSession(HttpServletResponse response) {
		SocialUtility.removeCookie("username", response);
		SocialUtility.removeCookie("email", response);
		SocialUtility.removeCookie("uid", response);
		SocialUtility.removeCookie("socialLoginId", response);
	}
	private Boolean doAutoLogin(UserDetails userDetails) {
		// perform login authentication
		Boolean autoLogin=false;
	    try {
	   
	      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
	      authenticationManagerAutoLogin.authenticate(authentication);
	      // redirect into secured main page if authentication successful
	      if(authentication.isAuthenticated()) {
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        autoLogin= true;
	      }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return autoLogin;
	}

	@RequestMapping(value = "/admin.html", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login.html")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
}