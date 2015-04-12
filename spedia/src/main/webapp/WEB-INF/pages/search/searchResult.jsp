<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
Search Result
<%@ include file="../include.jsp"%>
<c:set var="orgURL" value="${requestScope['javax.servlet.forward.request_uri']}"  scope="session"/>
<c:if test="${not fn:containsIgnoreCase(requestScope['javax.servlet.forward.query_string'], 'pageNumber')}">
<c:set var="orgParam" value="${requestScope['javax.servlet.forward.query_string']}"  scope="session"/>
</c:if>
<c:set var="currentURL"
	value="${sessionScope.orgURL}?${sessionScope.orgParam}" />
<div class="col-md-9">
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
			${newsContent.body.value }
			</br>

		</c:if>
	</c:forEach>
</div>
<%@include file="pagination.jsp"%>
<!-- ==================== -->