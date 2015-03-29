<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<html>
<head>
</head>
<body>
	<h3 align="center">Update School Information</h3>
	<center>
		<form:form method="POST" action="submitSchoolInfo.html"
			acceptCharset="utf-8" modelAttribute="schoolInformation"
			enctype="multipart/form-data">
			<label>School Name</label>
			<br />
			<label>Logo File</label>
			<form:input type="file" path="logoFile" />
			<br />

			<label>School Background image</label>

			<form:hidden path="sid" value="200" />
			<form:input type="file" path="backgroundImage" />
			<br />
			<label>Image Gallery</label>
			Image1	<form:input type="file" path="imageGallery" multiple="multiple" />
			Image2	<form:input type="file" path="imageGallery" multiple="multiple" />
			Image3	<form:input type="file" path="imageGallery" multiple="multiple" />
			<br />
			<input type="submit" value="Submit" />
		</form:form>
	</center>
</body>
</html>