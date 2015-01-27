<%@ include file="/WEB-INF/pages/include.jsp"%>
<!--######## Main Container Start Here ###########-->
	<div class="row innerWrap">
	<div class="col-sm-12">
		<div class="col-sm-12">
			<div class="row">
				<ol class="breadcrumb">
					  <li><a href="/"><img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-home-small" alt="home" /></a></li>
					  <li><a href="/insight/all/">${content.type}</a></li>
					  <li class="active"><a href="${group.alias}">${group.title}</li>
				</ol>
			</div>
			<div class="row">
				<section class="col-md-12">
					<article class="newsheadingblk notifyRow">
						<h2 class="size18"	style="text-transform: capitalize;">${content.title}</h1>
						<div class="text-right">
								 <fmt:formatDate pattern="MMMM dd, yyyy" value="${insight.creationDate}" /> by ${insight.createdBy}
						</div>
						<div class="clearfix">
						tags
							<%-- <c:forEach	items="${insight.jbInsightTags}" var="insightTag">
								 <c:if test="${not empty insightTag.tagName}"> 
									<c:set	value="${insightTag.tagType}"	var="tagType"/>
									<c:set	value="${insightTag.tagId}"	var="tagId"/>
									<c:set	value="${insightTag.tagName}"	var="tagName"/>
									<c:if test="${ insightTag.tagType eq INSIGHT_COMPANY_TYPE}">
										<span class="label flcompany">${insightTag.tagName}</span>
									</c:if>
									<c:if test="${insightTag.tagType ne INSIGHT_COMPANY_TYPE}">
										<span class="label flrole">${insightTag.tagName}</span>
									</c:if>
								 </c:if> 
							</c:forEach> --%>
						</div>
						<div class="row notifyRow">
							<!-- <div class="col-xs-6">
								<ul class="notification">
									<li><a href="#"><span class="upvote"><img src="http://53.jobbuzz.timesjobs.com/images/spacer.gif" class="cus-icon cus-plike-white">Upvote</span> <span class="likebtn">414</span></a></li>
									<li><a href="#" class="likebtn"><img class="cus-icon cus-pshare-white" src="http://53.jobbuzz.timesjobs.com/images/spacer.gif"> <span>1.2k</span></a></li>							
								</ul>
							</div> -->
						</div>
					</article>
					
					<div class="clearfix newscontent notifyRow">
						<div class="newsflimg">
							<img alt="" src="${insight.imageName}">
						</div>
						${content.body.value}
					</div>
				</section> 
				<aside class="col-md-3" style="display: none;">
					<div class="clearfix">
						<div class="z2new story-wrap company-detail">
								<h3>Trending Now</h3>
								<div class="row notifyRow swrap">
								<div class="col-xs-12">
									<div class="col-xs-4"><a href="#" class="row"><img src="images/story.jpg" class="img100" /></a></div>
									<div class="col-xs-8">
										<div class="row">
										<h4><a href="#">Air war in Syria could last years says sources</a></h4>
										<span class="display-blk"><em>4 h ago</em> on <u>Yanko Design</u></span>
										</div>
									</div>
								</div>
								</div>
						</div>
					</div>
					<div class="clearfix z1 similarquestion">
						<h3>Similar questions</h3>
						<div class="clearfix simquesList">
							<div class="olcount">1</div>
							<div class="col-xs-12 swrap">
								<div class="row">
									<h4><a href="#">Whats the best way to sink the iTune with iPhone?</a></h4>
									<ul>
										  <li><a href="#">125 Answers</a></li>
										  <li><a href="#">125 Upvotes</a></li>
										  <li><a href="#">125 Views</a></li>
									</ul>	
								</div>					
								</div>					
						</div>
						<div class="clearfix simquesList">
							<div class="olcount">2</div>
							<div class="col-xs-12 swrap">
							<div class="row">
									<h4><a href="#">Whats the best way to sink the iTune with iPhone?</a></h4>
									<ul>
										  <li><a href="#">125 Answers</a></li>
										  <li><a href="#">125 Upvotes</a></li>
										  <li><a href="#">125 Views</a></li>
									</ul>
									
							</div>									</div>		
						</div>
						<div class="clearfix simquesList">
							<div class="olcount">3</div>
							<div class="col-xs-12 swrap">
							<div class="row">
									<h4><a href="#">Whats the best way to sink the iTune with iPhone?</a></h4>
									<ul>
										  <li><a href="#">125 Answers</a></li>
										  <li><a href="#">125 Upvotes</a></li>
										  <li><a href="#">125 Views</a></li>
									</ul>								</div>					
							</div>
						</div>
						<div class="text-right"><a href="#" class="showmore">Show All Interview Questions (58K)</a></div>
					</div>
					
				</aside>
			</div>
		</div>
		</div>
	</div>
	