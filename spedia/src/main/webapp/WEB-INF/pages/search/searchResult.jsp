<title>Top schools Best schools  ${param.city} ${param.province}</title>
<div class="container">
  <div class="left_coloum">
    <div class="list_grid">
    <ul>
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
       </ul>
    </div>
    <div class="pagignation">
   <%@include file="pagination.jsp"%>
    </div>
  </div>
  <div class="right_coloum">
    <div class="news_subscribe">
      <div class="news_text">Subscribe for news leatter</div>
      <div class="news_fields">
        <input type="text" placeholder="Enter your email address" />
        <input type="submit" value="SUBSCRIBE" />
      </div>
    </div>
    <%@include file="../recentNews.jsp"%>
    <%@include file="../amazon_336_280.jsp"%>
    <%@include file="../adsense_336_280.jsp"%>
  </div>
</div>






<!-- ==================== -->