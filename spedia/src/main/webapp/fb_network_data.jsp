<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="fb-root"></div>
<body>
<div class="maindiv">
 <div class="fl"><a href="javascript: goToFacebook();">connect with FB</a></div>
<div class="rightpanel">
<div class="contentpart">
 <div class="rightpart">
 
<script type="text/javascript">
var site_url='http://test.schoolspedia.com/';
 function goToFacebook(){
 			var callBaclUrl=site_url+'spedia/fb_network_data.jsp';
			url=site_url+'spedia/social-connect.html?apc=sp&src=jbz_reg&pId=fb&cl='+callBaclUrl;
			window.location = url ;
 }
 var token = 'd6qH8Rz29i5iQxUEl8yHKWoRDeHM2QqP';
 //var pid = '100000615379768';
 //var pid = '1449796054';
 var fb_app_url=site_url+'harvest/fbAppNetworkData.html';
 var cand_url='http://timesjobs.com/';
 var pid = parseInt('${param.pfId}');
 var cid = parseInt('${param.cid}');
 var totalFriends_1L=-1;
  var totalFriends_2L=-1;
 
 if(isNaN(cid)){
 	cid = -1;
 }
 function global(){
	var appDomain = cand_url+'candidate/app/';
	var siteDomain=cand_url;
	var jobbuzzcrosssessionmgmt = 'https://jobbuzz.timesjobs.com'+'/candidate/jobbuzzcrosssessionmgmt.html';
		return {invite: appDomain+"invite",
				companyDetail:appDomain+"companyDetail",
				comments:appDomain+'comments-view',
				domain:appDomain,
				fbLikeCode:'0',
				userDetail:appDomain+'userDetail',
				firstVisit:appDomain+'firstVisit',
				jobbuzzcrosssessionmgmt:jobbuzzcrosssessionmgmt,
				parentDomain:siteDomain
				};
	}
 
 
</script>

<c:if test="${empty cid}">
<script type="text/javascript">

</script>
</c:if>
 