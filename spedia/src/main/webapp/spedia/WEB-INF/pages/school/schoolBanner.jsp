
<%	
int randBgImageIndex = 1 + (int)(Math.random()*8);
String defaultBGPath=WebConstants.IMAGE_URL+"images/bg_images/"+randBgImageIndex+".jpg";
%>
<c:if test="${not empty content.schoolsImages.BackGroundImagePath}">
	<c:set var="bgpath"
		value="${contextPath}/${content.schoolsImages.BackGroundImagePath}" />
</c:if>
<c:if test="${empty content.schoolsImages.BackGroundImagePath}">
	<c:set var="bgpath" value="<%=defaultBGPath%>" />
</c:if>
<c:set var="countOfReviews" value="${content.review.count}" />
<c:set var="isCountOfReviewsKPlus" value="false" />
<c:if test="${countOfReviews > 999}">
	<c:set var="countOfReviews" value="${countOfReviews/1000}" />
	<c:set var="countOfReviews"
		value="${ countOfReviews + ( 1 - ( countOfReviews %1 ) ) % 1 }" />
	<c:set var="isCountOfReviewsKPlus" value="true" />
</c:if>
	<c:if test="${countOfReviews>0}">
		<div>
			<span 
				class="fl fileupload hreview-aggregate"> <span> 
					<span class="rating1"> <c:choose>
							<c:when
								test="${content.review.oar ne null && content.review.oar > 2.5}">
								<span class="stars"><fmt:formatNumber value="${content.review.oar}" pattern="0.0" /></span> <fmt:formatNumber value="${content.review.oar}" pattern="0.0" />/5</c:when>
							<c:otherwise><span class="stars">2.5</span> 2.5/5</c:otherwise>
						</c:choose>
				</span>
					<a class="count" href="#reviews"> (<fmt:formatNumber
							value="${countOfReviews}" pattern="0" /> <c:if
							test="${isCountOfReviewsKPlus eq true}">K</c:if> Reviews )
					</a>

			</span>
			</span>
	</c:if>
<div class="clearfix">
				<ul class="clearfix">
					<c:if test="${fn:contains(content.f, uid)}">
						<input type="button" class="btn btn-xs btn-primary"
							id="followSchool" onclick="follow(${content.nid},this);"
							value="FOLLOWING">
					</c:if>
					<c:if test="${not fn:contains(content.f, uid)}">
						<input type="button" class="btn btn-xs btn-primary"
							id="followSchool" onclick="follow(${content.nid},this);"
							value="FOLLOW">
					</c:if>
					<a href="${contextPath}/writeReview.html?nid=${content.nid}"
						class="btn btn-primary btn-xs colorfff"><span class="colorfff">WRITE
							REVIEW</span></a>
					<c:if test="${isAdmin eq 'true'}">
						<a href="${contextPath}/editSchoolInfo.html?sid=${content.nid}"
							class="btn btn-primary btn-xs colorfff"><span
							class="colorfff">Edit School</span></a>
					</c:if>

				</ul><br />

			</div>
</div>
