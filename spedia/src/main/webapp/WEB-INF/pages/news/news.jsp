<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
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
			<form:textarea path="body" />
			<br />
			<label>Tags</label>
			<form:input path="tags" />
			<br />
			Load image <form:input type="file" path="imageFile" />
			<label>News type</label>
			
			<form:select path="type">
				<form:option value="Political"></form:option>
				<form:option value="Bollywood Hangama"></form:option>

				<form:option value="Hollywood Hangama"></form:option>
				<form:option value="Cricket"></form:option>

			</form:select>
			<br />
			<input type="submit" value="Submit" />
		</form:form>
	</center>
</body>
</html>