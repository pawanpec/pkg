<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*"%>
<%@ page import="com.spedia.utils.WebConstants"%>
<%@ page import="com.spedia.utils.SEOURLUtils"%>
<%@ page import="com.spedia.utils.SchoolsConstants"%>
<%@ page import="com.spedia.utils.SocialUtility"%>
<%@page import="java.lang.Math"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"		uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String contextPath=request.getContextPath();
String uid=SocialUtility.getCookieByKey(request, "uid");
String username=SocialUtility.getCookieByKey(request, "username");
String isAdmin=SocialUtility.getCookieByKey(request, "isAdmin");
%>
<c:set var="contextPath" value="<%=contextPath%>" />
<c:set var="uid" value="<%=uid%>" />
<c:set var="username" value="<%=username%>" />
<c:set var="isAdmin" value="<%=isAdmin%>" />
<script>
function registerUser(data) {
	 var queryString="?data="+data+"&socialType=fb";
	 var aurl="${contextPath}/registerUser.html"+queryString;
	  $.ajax({url: aurl, success: function(result){
		  console.log("after login "+result);
		  if(result=="1"){
			//  window.location = "http://dev.timesjobs.com/spedia/userHome.html";
		  }
		 
    }});
}
function logoutFROMSP() {
	  var aurl="${contextPath}/logout.html";
	  console.log("before logout "+aurl);
	  $.ajax({url: aurl, success: function(result){
 }});
}
function follow(nid,item) {
	 var divId=$(item).attr("id");
	 var val=$(item).attr("value");
	 var status=0;
	 if(val=='FOLLOW'){
		 status=1;
	 }
	 if(val=='FOLLOWING'){
		 status=0;
	 }
	 var queryString="?nid="+nid+"&status="+status;
	 var followUrl="${contextPath}/followSchool.html"+queryString;
	  $.ajax({url: followUrl, success: function(result){
		  if(result=="1"){
			  //change the value of follow button to following.
			  document.getElementById(divId).value="FOLLOWING"
		  }
		  if(result=="0"){
			  //change the value of follow button to following.
			  document.getElementById(divId).value="FOLLOW"
		  }
		  if(result==null){
			  //change the value of follow button to following.
			  document.getElementById(divId).value="Error"
		  }
         
      }});
}
function shuffle(array) {
	  var currentIndex = array.length, temporaryValue, randomIndex ;

	  // While there remain elements to shuffle...
	  while (0 !== currentIndex) {

	    // Pick a remaining element...
	    randomIndex = Math.floor(Math.random() * currentIndex);
	    currentIndex -= 1;

	    // And swap it with the current element.
	    temporaryValue = array[currentIndex];
	    array[currentIndex] = array[randomIndex];
	    array[randomIndex] = temporaryValue;
	  }

	  return array;
}
</script>