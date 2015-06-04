<%@ page import="java.util.*"%>
<%
Integer rand[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
Collections.shuffle(Arrays.asList(rand));
int i=1;
%>

<div class="featured_school">
  <div class="title">FEATURED Schools In <span>Delhi</span></div>
  <ul>
    <c:forEach items="${topSchools}" var="school" varStatus="status">
    <c:set var="index" value="${status.index}"/>
    <li>
      <div class="follow_row">
        <c:if test="${fn:contains(school.f, uid)}">
          <input type="button" class="btn btn-xs btn-primary" id="followSchool_${index}" onclick="follow(${school.nid},this);" value="FOLLOWING">
        </c:if>
        <c:if test="${not fn:contains(school.f, uid)}">
          <input type="button" class="btn btn-xs btn-primary" id="followSchool_${index}" onclick="follow(${school.nid},this);" value="FOLLOW">
        </c:if>
      </div>
      <div class="head">
        <div class="head_logo"></div>
        <div class="head_t">
          <div class="school_name"><a href="/${school.alias}" target="_blank" title="${school.title}">${school.title} </a></div>
          <div class="school_rate">
<div class="rating_div"><fmt:formatNumber value="${school.review.oar}" pattern="0.0" /></div><fmt:formatNumber value="${school.review.oar}" pattern="0.0" />/5</div>
        </div>
      </div>
      <div class="image"><img src="<%=WebConstants.IMAGE_URL%>images/static/<%=(int)( Math.random() * 14 ) %>.jpg" alt="${school.title}" /></div>
      <div class="reviews">
      ${school.review.count} Reviews
      </c:forEach>
  </ul>
</div>
