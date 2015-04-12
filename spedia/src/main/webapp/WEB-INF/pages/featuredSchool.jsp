<%@ include file="include.jsp" %>
<%@ page import="java.util.*"%>
<%
Integer rand[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
Collections.shuffle(Arrays.asList(rand));
int i=1;
%>
	<div class="container-fluid fearturelist">
		<div class="margincenter col-sm-10 text-center">
			<h2 class="robotolight font36">
				<strong>FEATURED Schools In Delhi</strong>
			</h2>
		</div>
			<div class="row">
				<c:forEach items="${topSchools}" var="school" varStatus="status">
				   <c:set var="index" value="${status.index}"/>
					<div class="companyarea clearfix">
						<div class="text-right">
							<c:if test="${fn:contains(school.f, uid)}">
								<input type="button" class="btn btn-xs btn-primary" id="followSchool_${index}" onclick="follow(${school.nid},this);" value="FOLLOWING">
							</c:if>
							<c:if test="${not fn:contains(school.f, uid)}">
								<input type="button" class="btn btn-xs btn-primary" id="followSchool_${index}" onclick="follow(${school.nid},this);" value="FOLLOW">
							</c:if>
						</div>
						<div class="clearfix notifyRow">
							<div class="media">
								<div class="media-body">
									<h5 class="media-heading ellipsesingle redcolor nobotmargin">
										<a href="/${school.alias}" target="_blank"
											title="${school.title}">${school.title} </a>
									</h5>
									<div>
										<fmt:formatNumber value="${school.review.oar}" pattern="0.0" />/5
									</div>
								</div>
							</div>
						</div>
						<div class="clearfix notifyRow text-center homepageimg">
							<div class="">
								<img src="<%=WebConstants.IMAGE_URL%>images/static/<%=(int)( Math.random() * 14 ) %>.jpg" alt="${school.title}" />
							</div>
						</div>
						<div class="clearfix text-center">
							<ul class="infolist">
								<li><a target="_blank">${school.review.count} Review</a></li>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
	</div>
	<!--******* feature Screen *************-->