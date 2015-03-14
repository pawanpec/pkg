<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/pages/include.jsp"%>
<script>
function validateForm() {
    var x = document.forms["reviewForm"]["review"].value;
    if (x == null || x == "") {
        alert("Review must be filled out");
        return false;
    }
    if (x.length <10) {
        alert("Review must have at least 10 char");
        return false;
    }
}
</script>
<body>
	<center>
		<h3>Please Write the Review for ${content.title}</h3>
		<form:form method="POST" action="submitReview.html" name="reviewForm"
			modelAttribute="reviews" onsubmit="return validateForm()">

			<label for="edit-a">1. Academic Result </label>
			</br>
			<form:radiobuttons path="a" items="${ratingOption}"/>
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
			<form:errors   path="review"  />
			</td>
			<input type="submit" value="SubmitReview">
		</form:form>
	</center>
