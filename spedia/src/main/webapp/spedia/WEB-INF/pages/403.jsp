<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>403</title>
<style type="text/css">
body{
font-family:arial;
font-size:13px;
background-color:#999;
color:#333;
}
.wra_error{
width:460px;
height:200px;
position:absolute;
top:50%;
left:50%;
background-color:#f1f1f1;
margin-top:-120px;
margin-left:-250px;
padding:20px;
border:#7c7c7c solid 2px;
border-radius:7px;
-moz-border-radius:7px;
-webkit-border-radius:7px;
}

p{
padding:0px;
margin:0px;
line-height:20px;
margin-bottom:10px;
}

@media screen and (max-width:500px){
	.wra_error{
	width:80%;
	padding:20px 7%;
	}
}

</style>
</head>
<body>
<div class="wra_error">	
	<p style="margin-bottom:15px;"><img src="/social/resources/images/error_page_logo.jpg" /></p>
	<p style="font-size:18px;"><strong style="color:#006c9a">403 Error </strong> &nbsp;Access Forbidden</p>
	<p>Forbidden: You don't have permission to access [directory] on this server.</p>
	<p><a href="<%= request.getContextPath() %>/home">www.jobbuzz.timesjob.com/social</a></p>
</div>

</body>
</html>