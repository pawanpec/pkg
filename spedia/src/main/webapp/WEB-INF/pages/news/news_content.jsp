<%@ include file="/WEB-INF/pages/include.jsp"%>
<title>${content.title}</title>
<meta name="keywords" content="${content.title}" />
<!--######## Main Container Start Here ###########-->
	<div class="row innerWrap">
	<div class="col-sm-12">
		<div class="col-sm-12">
			<div class="row">
				<ol class="breadcrumb">
					  <li><a href="/"><img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-home-small" alt="home" /></a></li>
					  <li><a href="/spedia/contentType.html?type=${content.type}">${fn:replace(content.type,'_',' ')}</a></li>
					  <li class="active"><a href="${group.alias}">${group.title}</li>
				</ol>
			</div>
			<div class="row">
				<section class="col-md-12">
					<article class="newsheadingblk notifyRow">
						<h2 class="size18"	style="text-transform: capitalize;">${content.title}</h1>
						<%-- <div class="text-right">
								 <fmt:formatDate pattern="MMMM dd, yyyy" value="${insight.creationDate}" /> by ${insight.createdBy}
						</div>
						<div class="clearfix">
						tags
						</div> --%>
					</article>
					
					<div class="clearfix newscontent notifyRow">
						<div class="newsflimg">
							<img alt="content.imageName" src="${content.imageName}">
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
	