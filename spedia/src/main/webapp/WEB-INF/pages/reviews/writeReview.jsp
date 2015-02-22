<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST" action="submitReview.html" modelAttribute="reviews">
             <table>
                <tr>
                    <td><form:label path="review">Review TEXT</form:label></td>
                    <td><form:input path="review"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>