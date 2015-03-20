
<%	
int randBgImageIndex = 1 + (int)(Math.random()*8);
String defaultBGPath=WebConstants.IMAGE_URL+"images/bg_images/"+randBgImageIndex+".jpg";
%>
<script>
function follow(nid,uid,status) {
	 var queryString="?nid="+nid+"&uid="+uid+"&status="+status;
	 var followUrl="/spedia/followSchool.html"+queryString;
	  $.ajax({url: followUrl, success: function(result){
		  if(result=="1"){
			  //change the value of follow button to following.
			  $("#follow").html("following");
		  }
         
      }});
}
</script>

<c:set value="<%=SchoolsConstants.SOCIAL_URL_TWITTER_CODE%>"
	var="SOCIAL_URL_TWITTER_CODE" />
<c:set value="<%=SchoolsConstants.SOCIAL_URL_FACEBOOK_CODE%>"
	var="SOCIAL_URL_FACEBOOK_CODE" />
<c:set value="<%=SchoolsConstants.SOCIAL_URL_LINKEDIN_CODE%>"
	var="SOCIAL_URL_LINKEDIN_CODE" />
<c:set value="<%=SchoolsConstants.SOCIAL_URL_GOOGLE_PLUS_CODE%>"
	var="SOCIAL_URL_GOOGLE_PLUS_CODE" />
<c:set value="<%=SchoolsConstants.JB_RATING_SALARY%>"
	var="JB_RATING_SALARY" />
<c:set value="<%=SchoolsConstants.JB_RATING_WORK_LIFE_BAL%>"
	var="JB_RATING_WORK_LIFE_BAL" />
<c:set value="<%=SchoolsConstants.JB_COMPANY_CULTURE%>"
	var="JB_COMPANY_CULTURE" />
<c:set value="<%=SchoolsConstants.JB_CAREER_GROWTH%>"
	var="JB_CAREER_GROWTH" />
<c:set value="<%=SchoolsConstants.COMPANY_CARD_LIST_SIZE%>"
	var="COMPANY_CARD_LIST_SIZE" />
	
<c:set var="_compName" 	value="${content.title}"/>
<c:set var="_compId" 	value="${companyViewBean.companyMast.companyId}"/>
<c:if test="${not empty msg}">
						${msg }
						
</c:if>

<c:set var="countOfReviews" value="${content.review.count}" />
<c:set var="isCountOfReviewsKPlus" value="false" />
<c:if test="${countOfReviews > 999}">
	<c:set var="countOfReviews" value="${countOfReviews/1000}" />
	<c:set var="countOfReviews" value="${ countOfReviews + ( 1 - ( countOfReviews %1 ) ) % 1 }"/>
	<c:set var="isCountOfReviewsKPlus" value="true" />
</c:if>

<c:if test="${not empty companyBannerImage}">
	<c:set var="prepathValue" value="<%=WebConstants.BANNER_URL %>" />
	<c:set var="bgpath" value="${prepathValue}${companyBannerImage}" />
</c:if>
<c:if test="${empty companyBannerImage}">
	<c:set var="bgpath" value="<%=defaultBGPath%>" />
</c:if>
	<div class="row z2new company-details m_b10" style='background-image: url("${bgpath}")'>
			<div class="col-sm-10 position companyinfo">
				<h1>
					<c:if test="${not empty companyLogoImage}">
					<img class="companypagelogo" src="<%=WebConstants.LOGO_URL %>${companyLogoImage}" data-errsrc="round" data-font="45" data-width="97" data-center="center" alt="${content.title}" />
					</c:if>
				<c:if test="${empty companyLogoImage}">
					<span data-firstletter="${content.title}" class="width97 margincenter position" data-type="round" data-font="45"></span>
				</c:if>
				</h1>
				<h2>${content.title}</h2>
				<div class="font12 row ratting_star companyrate ">
					<span itemscope itemtype="http://data-vocabulary.org/Review-aggregate" class="fl fileupload">
						<span itemprop="rating" itemscope itemtype="http://data-vocabulary.org/Rating"> 
							<span itemprop="average">
								<c:choose>
									<c:when test="${content.review.oar ne null && content.review.oar > 2.5}"><fmt:formatNumber value="${content.review.oar}" pattern="0.0" />/5</c:when>
								    <c:otherwise>2.5/5</c:otherwise>
								 </c:choose>
							</span>
						
							<%-- <a itemprop="votes pad_l15" href="/company/${fn:replace(companyViewBean.companyMast.companyName,' ','-')}/review&txtCompId=${companyViewBean.companyMast.companyId}"> --%> 
							<a itemprop="votes pad_l15" href="${content.alias}#reviews"	target="_blank">
							(<fmt:formatNumber	value="${countOfReviews}"	pattern="0"	/><c:if test="${isCountOfReviewsKPlus eq true}">K</c:if> Reviews )
							</a>
								
						</span>
					</span>
				</div>
				<div class="col-sm-3 text-center colorfff companyrating">
					<div class="row" style="border:1px solid #ff0000">
						<div class="col-xs-3" style="background:#1c817e;">
							<div class="cmpratinginfo row">
								<strong>
								<fmt:formatNumber value="${content.review.ora}" pattern="0.0"  />/5
								</strong><br/> Academic Result
							</div>
						</div>
						<div class="col-xs-3" style="background:#d9823d;">
							<div class="cmpratinginfo row">
								<strong>
								<fmt:formatNumber value="${content.review.orb}" pattern="0.0"  />/5
								</strong><br/> Infrastructure and facilities
							</div>
						</div>
						<div class="col-xs-3" style="background:#333333;">
							<div class="cmpratinginfo row">
								<strong>
								<fmt:formatNumber value="${content.review.orc}" pattern="0.0"  />/5
								</strong><br/> Attention to students
							</div>
						</div>
						<div class="col-xs-3" style="background:#c1494b;">
							<div class="cmpratinginfo row">
								<strong>
							<fmt:formatNumber value="${content.review.ord}" pattern="0.0"  />/5
								</strong><br/> Co-curricular activities
							</div>
						</div>
						<div class="col-xs-3" style="background:#565a9d;">
							<div class="cmpratinginfo row">
								<strong>
							<fmt:formatNumber value="${content.review.ore}" pattern="0.0"  />/5
								</strong><br/> Quality of faculty
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix">
						
						<ul class="followpos inlineul">
							<!-- <li class="font24" data-ng-if="followData.followCount > 0"> -->
							<li>
								<input id="follow"  class="btn btn-primary btn-sm colorfff" onclick="follow(${content.nid},2,1);" value="FOLLOW" type="button" /> 
							</li>
							<li>
								<a href="/spedia/writeReview.html?nid=${content.nid}" class="btn btn-primary btn-sm colorfff"><span class="colorfff">WRITE REVIEW</span></a>
							</li>
							
						</ul>
			</div>
		</div>
	</div>
<!--########### Company Details with logo Container Ends Here ###########-->
