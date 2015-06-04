<%@ include file="/WEB-INF/pages/include.jsp"%>
<title>${content.title}</title>
<div itemscope itemtype="http://data-vocabulary.org/Product"
	style="position: absolute; font-size:0px; left:0; height:0; width:0; line-height: 0; top:0; overflow: hidden;">
	<span itemprop="name">${content.title}</span> <img itemprop="image"
		src="<%=WebConstants.LOGO_URL %>${companyLogoImage}" />
	<c:forEach items="${jbSoldCompanyTextContainers}" var="companyText"
		varStatus="status">
		<c:if
			test="${fn:toLowerCase(fn:trim(companyText.sectionTitle)) eq 'about us'}">
			<span itemprop="description">${companyText.sectionText}</span>
		</c:if>
	</c:forEach>
	<span itemprop="review" itemscope
		itemtype="http://data-vocabulary.org/Review-aggregate"> <span
		itemprop="rating">${content.review.oar}</span><span itemprop="count">${content.review.count}
	</span>
	</span>
</div>



<div class="container">
	<ol class="breadcrumb">
		<li><a href="/"><img
				src="<%=WebConstants.IMAGE_URL %>images/spacer.gif"
				class="cus-icon cus-home-small" alt="home"></a></li>
		<c:if test="${not empty content.location.province}">
			<li class="active"><a
				href="/india/schools-in/${content.location.province}">Schools in
					${content.location.province}</a></li>
		</c:if>
		<c:if test="${not empty content.location.city}">
			<li class="active"><a
				href="/india/${content.location.province}/schools-in/${content.location.city}">Schools
					in ${content.location.city}</a></li>
		</c:if>
		<li class="active">${content.title}</li>
	</ol>
	<div class="title"><strong>${content.title}</strong></div>
	<%@include file="schoolBanner.jsp"%>
</div>
<div class="container">
	<div class="left_coloum">
		<div class="details_grid">
			<%@include file="school_main_image.jsp"%>
			<%@include file="school_main_content.jsp"%>
			<%@include file="adsense_728_90.jsp"%>
			<%@include file="schoolOverview.jsp"%>
			<%@include file="adsense_728_90.jsp"%>
			<%@include file="schoolmap.jsp"%>
		</div>
	</div>
	<div class="right_coloum">
		<div class="review_bars_green">
			<strong><fmt:formatNumber value="${content.review.ora}"
					pattern="0.0" />/5</strong><span>Academic Result</span>
		</div>
		<div class="review_bars_orange">
			<strong><fmt:formatNumber value="${content.review.orb}"
					pattern="0.0" />/5</strong> <span>Infrastructure and facilities</span>
		</div>
		<div class="review_bars_black">
			<strong><fmt:formatNumber value="${content.review.orc}"
					pattern="0.0" />/5</strong><span>Attention to students</span>
		</div>
		<div class="review_bars_red">
			<strong><fmt:formatNumber value="${content.review.ord}"
					pattern="0.0" />/5</strong><span>Co-curricular activities</span>
		</div>
		<div class="review_bars_blue">
			<strong><fmt:formatNumber value="${content.review.ore}"
					pattern="0.0" />/5</strong><span>Quality of faculty</span>
		</div>
		<%@include file="../adsense_336_280.jsp"%>
		<c:if test="${newsCount>0}">
			<%@include file="schoolNews.jsp"%>
		</c:if>
		<c:if test="${not empty reviews}">
			<%@include file="schoolReviewWidget.jsp"%>
		</c:if>
	</div>
</div>































<div class="container offsetWrap" id="navbar-collapse1Wrap">
	<div class="row innerWrap">
		<!--######## Main Container Start Here ###########-->
		<div class="row" style="padding-left:2%;">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12"></div>
				</div>
				<!--########### Company Banner with logo Start Here ###########-->

				<!--########### Company Banner with logo Container Ends Here ###########-->


				<div class="col-sm-12 m_t10">
					<div id="companypage">
						<!--########### Work for US Start Here ###########-->

						<!--########### Work for US Ends Here ###########-->

						<!--########### SCHOOL REVIEW WEDGIT HERE ###########-->


						<!--########### SCHOOL REVIEW WEDGIT HERE ###########-->
						<!--########### SCHOOL News WEDGIT Start HERE ###########-->

						<!--########### SCHOOL News WEDGIT END HERE ###########-->
						<!--########### Company Gallery START HERE ###########-->
						<%-- 	<%@include file="schoolGallery.jsp"%> --%>
						<!--########### Company Gallery ENDS HERE###########-->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--########### Main Container Ends Here ###########-->
</div>
