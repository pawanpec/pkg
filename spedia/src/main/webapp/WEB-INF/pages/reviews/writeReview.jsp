<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
	<h3>Welcome, Enter The Employee Details</h3>
	<form:form method="POST" action="submitReview.html"
		modelAttribute="reviews">
				
					<label for="edit-a">1. Academic Result </label>
					<form:radiobuttons path="a" items="${ratingOption}" />
					</br>
					<label for="edit-a">1. Academic Result </label>
					<form:radiobuttons path="a" items="${ratingOption}" />
				
					</br>
				
					<input type="submit" value="SubmitReview">
	</form:form>
</body>
</html>