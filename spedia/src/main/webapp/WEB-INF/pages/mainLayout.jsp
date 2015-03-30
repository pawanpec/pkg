<%@ include file="/WEB-INF/pages/include.jsp"%>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" type="image/ico" href="<%=WebConstants.IMAGE_URL%>images/favicon.ico"/>
	<meta property="og:description" content=''/>
	<meta property="og:url" content=""/>
	<meta property="og:image" content="jobuzz_logo.png"/>
	<meta property="og:type" content="article"/>
	<meta name="Author" content=" http://schoolspedia.com/"/>
	<meta name="copyright" content="http://www.schoolspedia.in/"/>
	<meta name="robots" content='index, follow'/>
	<meta name="rating" content="safe for kids"/>
	<meta name="googlebot" content='index, follow'/>
	<meta name="yahooSeeker" content='index, follow'/>
	<meta name="msnbot" content='index, follow'/>
	<meta name="reply-to" content="schoolspedia@gmail.com"/>
	<meta name="allow-search" content="yes"/>
	<meta name="revisit-after" content="daily"/>
	<meta name="distribution" content="global"/>
	<meta name="Rating" content="General"/>
	<meta name="expires" content="never"/>
	<meta name="language" content="english"/>
	

	 <script src="<%=WebConstants.JS_URL %>js/jquery-1.10.2.min.js" type="text/javascript"></script> 
	 <script type="text/javascript" src="<%=WebConstants.JS_URL %>js/autosuggest2.js"></script>
     <script type="text/javascript" src="<%=WebConstants.JS_URL %>js/suggestions2.js"></script>
     <script type="text/javascript" src="<%=WebConstants.JS_URL %>js/fbutils.js"></script> 
	<script type="text/javascript">
	 var random = shuffle([1,2,3,4,5,6,7,8,9,10,11,12,13,14]);
	</script>
<!-- css inludes -->
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL %>css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL %>css/stylesheet.css" />
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL %>css/bootstrap-slider.css" />
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL %>css/datepicker.css" />
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL %>fonts/font.css" />
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL%>css/star-rating.css" />
	<link rel="stylesheet" type="text/css" href="<%=WebConstants.CSS_URL %>css/autosuggest.css" />
		
</head>
<div id="fb-root"></div>
<body data-ng-click="visibleOption(false); mobileSearchvisible(false)">
	<noscript> <img src="http://b.scorecardresearch.com/p?c1=2&c2=6036484&c3=&c4=&c5=&c6=&c15=&cj=1" /> </noscript>
	<!-- <div class="modal" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
	<div class="slidemenu">
	<div>
		<tiles:insertAttribute name="header" />
	</div>
	
	<div class="row" id="staticmsg">
		<div class="col-xs-10 z2new text-center col-md-8 alert alert-warning margincenter alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<span class="txtmsg"></span>
		</div>
	</div>
	<!-- </div> -->
	
	<!-- <div class="container modal" id="myModal2" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
		<div class="parentcont">
			<tiles:insertAttribute name="body" />
		</div>
	<!-- </div> -->
	
	<!-- <div class="wrapper"> -->
		 <tiles:insertAttribute name="footer" />
	<!-- </div> -->
	
	<!-- close wrapper -->
	<div class="content-preloader" id="preloader">
	<!-- <div>JobBuzz</div> -->
		<img src="<%=WebConstants.IMAGE_URL %>images/small_loader.gif" />
	</div>
	</div>
	<!-- Js Includes -->

	 
</body>
</html>