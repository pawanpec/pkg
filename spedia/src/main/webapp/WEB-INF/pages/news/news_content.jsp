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
				<section class="col-md-9">
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
			</div>
		</div>
		</div>
	</div>
	