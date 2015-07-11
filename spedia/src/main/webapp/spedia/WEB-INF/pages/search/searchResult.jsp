<div class="container">
  <div class="left_coloum">
    <div class="list_grid">
    <div>
<%@ include file="../include.jsp"%>
<c:set var="orgURL" value="${requestScope['javax.servlet.forward.request_uri']}"  scope="session"/>
<c:if test="${not fn:containsIgnoreCase(requestScope['javax.servlet.forward.query_string'], 'pageNumber')}">
<c:set var="orgParam" value="${requestScope['javax.servlet.forward.query_string']}"  scope="session"/>
</c:if>
<c:set var="currentURL"
	value="${sessionScope.orgURL}?${sessionScope.orgParam}" />
	<c:forEach items="${contents}" var="newsContent" varStatus="theCount">
		<c:if test="${newsContent.type eq 'group'}">
			<%@include file="schoolListing.jsp"%>
		</c:if>
		<c:if test="${newsContent.type ne 'group'}">
			<%@include file="resultCard.jsp"%>
		</c:if>
	</c:forEach>
       </div>
    </div>
    <div class="pagignation">
   <%@include file="pagination.jsp"%>
    </div>
  </div>
  <div class="right_coloum">
    <div class="news_subscribe">
      <h4>Recent News</h4>      
    </div>
    <%@include file="../recentNews.jsp"%>
    <%@include file="../amazon_336_280.jsp"%>
    <%@include file="../adsense_336_280.jsp"%>
  </div>
</div>






<!-- ==================== -->