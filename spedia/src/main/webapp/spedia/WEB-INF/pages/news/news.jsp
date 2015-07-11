<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<script type="text/javascript" src="<%=WebConstants.JS_URL %>js/ckeditor/ckeditor.js"></script>
<html>
<head>
</head>
<body>
	<center>
		<h3>Add News</h3>
		<form:form method="POST" action="submitNews.html"
			acceptCharset="utf-8" modelAttribute="content" enctype="multipart/form-data">
			<label>Title </label>
			<form:input path="title" />
			<br />
			<label>Body</label>
			<form:textarea cssClass="ckeditor" path="body" />
			<br />
			<label>Tags</label>
			<form:input path="tags" />
			<br />
			Load image <form:input type="file" path="imageFile" />
			<label>News type</label>
			<form:hidden path="sid" value="${param.sId}" />
			<form:select path="type">
				<form:option value="schools_news">Schools News</form:option>
				<form:option value="nursery_admission_news">Nursery Admission News</form:option>
			</form:select>
			<br />
			<input type="submit" value="Submit" />
		</form:form>
	</center>
</body>
</html>