<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ page import="com.spedia.utils.WebConstants"%>
<%@ page import="com.spedia.utils.SEOURLUtils"%>
<%@ page import="com.spedia.utils.SchoolsConstants"%>
<%@ page import="com.spedia.utils.SocialUtility"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String contextPath=request.getContextPath();
String uid=SocialUtility.getCookieByKey(request, "uid");
%>