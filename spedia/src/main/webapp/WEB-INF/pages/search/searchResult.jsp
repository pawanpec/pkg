<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
Search Result
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="currentURL"
	value="/spedia/contentType.html?type=nursery_admission_news" />
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide">
	<c:forEach items="${contents}" var="newsContent">
		<c:if test="${newsContent.type eq 'group'}">
			<%@include file="schoolListing.jsp"%>
		</c:if>
		<c:if test="${newsContent.type ne 'group'}">
			<a itemprop="url" class="biznme_txt" title="${newsContent.title }"
				id="${newsContent.nid }" href="/${newsContent.alias }"><span
				style="color:#3273da;right:0px;top:0px;" itemprop="name">${newsContent.title }</span>
			</a>
			</br>

		</c:if>
	</c:forEach>
</div>
<%@include file="pagination.jsp"%>
<!-- ==================== -->