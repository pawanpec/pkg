<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<html>
<head>
</head>
<body>
	<center>
		<h3>Please Write the Review for ${content.title}</h3>
		<form:form method="POST" action="submitReview.html"
			modelAttribute="reviews">

			<label for="edit-a">1. Academic Result </label>
			</br>
			<form:radiobuttons path="a" items="${ratingOption}" />
			</br>
			<label for="edit-b">2. Infrastructure and facilities </label>
			</br>
			<form:radiobuttons path="b" items="${ratingOption}" />
			</br>
			<label for="edit-c">3. Attention to students </label>
			</br>
			<form:radiobuttons path="c" items="${ratingOption}" />
			</br>
			<label for="edit-d">4. Co-curricular activities </label>
			</br>
			<form:radiobuttons path="d" items="${ratingOption}" />
			</br>
			<label for="edit-e">5. Quality of faculty </label>
			</br>
			<form:radiobuttons path="e" items="${ratingOption}" />
			</br>
			<form:hidden path="uid" value="<%=uid %>" />
			<form:hidden path="nid" value="${nid}" />
			<label for="edit-a">Your Reviews</label>
			</br>
			<form:textarea path="review" />
			<input type="submit" value="SubmitReview">
		</form:form>
	</center>
</body>
</html>