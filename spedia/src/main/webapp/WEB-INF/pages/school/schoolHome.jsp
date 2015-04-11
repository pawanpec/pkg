<%@ include file="/WEB-INF/pages/include.jsp"%>
<title>${content.title}</title>
	<div itemscope itemtype="http://data-vocabulary.org/Product" 
		style="position: absolute; font-size:0px; left:0; height:0; width:0; line-height: 0; top:0; overflow: hidden;" >
		<span itemprop="name">${content.title}</span>
		<img itemprop="image" src="<%=WebConstants.LOGO_URL %>${companyLogoImage}" />
		<c:forEach items="${jbSoldCompanyTextContainers}" var="companyText" varStatus="status">
			<c:if test="${fn:toLowerCase(fn:trim(companyText.sectionTitle)) eq 'about us'}">
				<span itemprop="description">${companyText.sectionText}</span>
			</c:if>
		</c:forEach>
		<span itemprop="review" itemscope itemtype="http://data-vocabulary.org/Review-aggregate">
	    	<span itemprop="rating">${content.review.oar}</span><span itemprop="count">${content.review.count} </span>
	  	</span>
	</div>
	<div class="container-fluid offsetWrap" id="navbar-collapse1Wrap">
		<div class="row innerWrap">
			<!--######## Main Container Start Here ###########-->
			<div class="row" style="padding-left:2%;">
				<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">	
						<ol class="breadcrumb">
							  <li><a href="/"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-home-small" alt="home"></a></li>
							  <li class="active"><a href="/india/schools-in/${content.location.province}">Schools in ${content.location.province}</a></li>
							  <li class="active"><a href="/india/${content.location.province}/schools-in/${content.location.city}">Schools in ${content.location.city}</a></li>
							  <li class="active">${content.title}</li>
						</ol>
					</div>
				</div>
					<!--########### Company Banner with logo Start Here ###########-->
					<%@include file="schoolBanner.jsp"%>
					<!--########### Company Banner with logo Container Ends Here ###########-->

				
					<div class="col-sm-12 m_t10">
						<div id="companypage">
						<!--########### Work for US Start Here ###########-->
								<%@include file="schoolTabs.jsp"%>
						<!--########### Work for US Ends Here ###########-->
						
						<!--########### SCHOOL REVIEW WEDGIT HERE ###########-->
						<c:if test="${not empty reviews}">
							<%@include file="schoolReviewWidget.jsp"%>
						</c:if>
						<%@include file="adsense_320_100.jsp"%>
						<!--########### SCHOOL REVIEW WEDGIT HERE ###########-->
						<!--########### SCHOOL News WEDGIT Start HERE ###########-->
						<c:if test="${newsCount>0}">
							<%@include file="schoolNews.jsp"%>
						</c:if>
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
