<c:set var="a" value="${totalCount/rowsPerPage}" />
<c:set var="b" value="${totalCount/rowsPerPage}" />
<c:choose>
	<c:when test="${a==0}">
		<c:set var="numberOfPages" value="1" scope="session" />
	</c:when>

	<c:when test="${b>a}">
		<c:set var="xxx" value="${b%a}" />
		<c:if test="${xxx>0}">
			<c:set var="numberOfPages" value="${b-xxx+1}" scope="session" />
		</c:if>
	</c:when>

	<c:when test="${a>=b}">
		<c:set var="numberOfPages" value="${a}" scope="session" />
	</c:when>
</c:choose>
<c:set var="pageNumber" value="${param.pageNumber}" />
<c:set var="start" value="${pageNumber*rowsPerPage-rowsPerPage}" />
<c:set var="stop" value="${pageNumber*rowsPerPage-1}" />
<c:if test="${numberOfPages>=pageNumber+10}">
	<c:set var="end" value="${pageNumber+10}" />
</c:if>
<c:if test="${numberOfPages<pageNumber+10}">
	<c:set var="end" value="${numberOfPages}" />
</c:if>
<%--For displaying Previous link --%>
<c:if test="${pageNumber gt 0}">
	<a href="${currentURL}&pageNumber=${pageNumber - 1}">Previous</a>
</c:if>
<c:forEach begin="${pageNumber+1}" end="${end}" var="i">
	<c:choose>
		<c:when test="${i!=pageNumber}">
			<a href="${currentURL}&pageNumber=<c:out value="${i}"/>"><c:out
					value="${i}" /></a>
		</c:when>
		<c:otherwise>
			<c:out value="${i}" />
		</c:otherwise>
	</c:choose>
</c:forEach>
<%--For displaying Next link --%>
<c:if test="${pageNumber lt numberOfPages}">
	<a href="${currentURL}&pageNumber=${pageNumber + 1}">Next</a>
</c:if>