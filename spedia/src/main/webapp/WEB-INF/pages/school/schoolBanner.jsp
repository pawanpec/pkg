
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
<div class="row z2new company-details m_b10"
	style='background-image: url("${bgpath}")'>
	<div class="col-sm-10 position companyinfo">
		<h1>${content.title}</h1>
		<c:if test="${countOfReviews>0}">
			<div>
				<span itemscope
					itemtype="http://data-vocabulary.org/Review-aggregate"
					class="fl fileupload"> <span itemprop="rating" itemscope
					itemtype="http://data-vocabulary.org/Rating"> <span
						itemprop="average"> <c:choose>
								<c:when
									test="${content.review.oar ne null && content.review.oar > 2.5}">
									<fmt:formatNumber value="${content.review.oar}" pattern="0.0" />/5</c:when>
								<c:otherwise>2.5/5</c:otherwise>
							</c:choose>
					</span> <%-- <a itemprop="votes pad_l15" href="/company/${fn:replace(companyViewBean.companyMast.companyName,' ','-')}/review&txtCompId=${companyViewBean.companyMast.companyId}"> --%>
						<a itemprop="votes pad_l15" href="#reviews"> (<fmt:formatNumber
								value="${countOfReviews}" pattern="0" />
							<c:if test="${isCountOfReviewsKPlus eq true}">K</c:if> Reviews )
					</a>

				</span>
				</span>
				<div class="clearfix">

					<ul class="followpos inlineul">
						<!-- <li class="font24" data-ng-if="followData.followCount > 0"> -->
						<c:if test="${fn:contains(content.f, uid)}">
								<input type="button" class="btn btn-xs btn-primary" id="followSchool" onclick="follow(${content.nid},this);" value="FOLLOWING">
							</c:if>
						<c:if test="${not fn:contains(content.f, uid)}">
								<input type="button" class="btn btn-xs btn-primary"  id="followSchool" onclick="follow(${content.nid},this);" value="FOLLOW">
						</c:if>
						<a href="${contextPath}/writeReview.html?nid=${content.nid}"
							class="btn btn-primary btn-sm colorfff"><span
							class="colorfff">WRITE REVIEW</span></a>
						<c:if test="${isAdmin eq 'true'}">
							<a href="${contextPath}/editSchoolInfo.html?sid=${content.nid}"
								class="btn btn-primary btn-sm colorfff"><span
								class="colorfff">Edit School</span></a>
						</c:if>

					</ul>
				</div>
			</div>
			<div class="col-sm-3 text-center colorfff companyrating">
				<div class="row" style="border:1px solid #ff0000">
					<div class="col-xs-3" style="background:#1c817e;">
						<div class="cmpratinginfo row">
							<strong> <fmt:formatNumber value="${content.review.ora}"
									pattern="0.0" />/5
							</strong><br /> Academic Result
						</div>
					</div>
					<div class="col-xs-3" style="background:#d9823d;">
						<div class="cmpratinginfo row">
							<strong> <fmt:formatNumber value="${content.review.orb}"
									pattern="0.0" />/5
							</strong><br /> Infrastructure and facilities
						</div>
					</div>
					<div class="col-xs-3" style="background:#333333;">
						<div class="cmpratinginfo row">
							<strong> <fmt:formatNumber value="${content.review.orc}"
									pattern="0.0" />/5
							</strong><br /> Attention to students
						</div>
					</div>
					<div class="col-xs-3" style="background:#c1494b;">
						<div class="cmpratinginfo row">
							<strong> <fmt:formatNumber value="${content.review.ord}"
									pattern="0.0" />/5
							</strong><br /> Co-curricular activities
						</div>
					</div>
					<div class="col-xs-3" style="background:#565a9d;">
						<div class="cmpratinginfo row">
							<strong> <fmt:formatNumber value="${content.review.ore}"
									pattern="0.0" />/5
							</strong><br /> Quality of faculty
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
<!--########### Company Details with logo Container Ends Here ###########-->
