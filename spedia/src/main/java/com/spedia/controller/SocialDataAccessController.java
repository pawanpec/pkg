package com.spedia.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spedia.service.OAuthProviderService;
import com.spedia.service.ServiceImplementationProvider;
import com.spedia.service.SocialAuthServiceProvider;
import com.spedia.utils.MyLogger;
import com.spedia.utils.SocialUtility;


@Controller
public class SocialDataAccessController{
	@Autowired
	private SocialAuthServiceProvider socialAuthServiceProvider;
	@Autowired
	private ServiceImplementationProvider serviceImplementationProvider;
	
	private static final MyLogger logger = new MyLogger(SocialDataAccessController.class);
	
	@RequestMapping(value = { "/social-connect.html" }, method = { RequestMethod.GET })
	public ModelAndView schoolDetails(HttpServletRequest request, HttpServletResponse response) {
		String provider = request.getParameter("pId");
		String appCode =  request.getParameter("apc");
		/**
		 * check if data in session is of the same provider or of different
		 * provider, if different then remove auth and request token
		 **/
		SocialUtility.removeOtherProviderAuthTokenFromSession(request, provider);

		/**
		 * storing the information in session, which will be used in callback
		 * controller
		 **/
		SocialUtility.storeDataInSession(request);

		try {
			/** creating the OAuthService object based on provider type **/
			OAuthService service = socialAuthServiceProvider.getOAuthServiceProvider(appCode, provider);

			/** creating the provider service implementation class **/
			OAuthProviderService providerService = serviceImplementationProvider.getInstanceForSocialParser(provider);
			
			if (!providerService.isSessionTokenAvailable(request)) {
				System.out.println("provider asif 3: "+provider);
				String authorizationUrl = providerService.getAuthorizationUrl(service, request);
				System.out.println("provider asif 4 Redirecting to the authorization URL of the "+provider + " | authorizationUrl "+authorizationUrl);
				return new ModelAndView("redirect:" + authorizationUrl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:callback.html?pId=" + provider);
	}
}
