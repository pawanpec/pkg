<div class="col-sm-4 col-md-3 account-card interview-card">
	<!-- SINGLE JOB STARTS HERE  -->
	<div class="story-wrap z2new">
		<div class="social-share">
			<ul>
				<li><a href="#"><img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
						class="cus-icon cus-plike-white" /></a></li>
				<li><a href="#">+</a></li>
				<li class="social-list"><a href="#"><img
						class="cus-icon cus-soci-share" src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
						alt="share" /></a>
					<ul>
						<li><a href="#"><img class="cus-icon cus-soci-ln"
								src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" alt="share" /></a></li>
					</ul></li>
			</ul>
		</div>
		<div class="tag-list">
			<!-- <div class="tagitem color "><span>&nbsp;</span><a href="#">JavsScript</a></div>					
							<div class="tagitem color1"><span>&nbsp;</span><a href="#">Java</a></div>
							<div class="tagitem gn color2"><span>&nbsp;</span><a href="#">Java</a></div> -->
			<%-- <div class="tagitem color3"><span>&nbsp;</span><a href="#">${job.keySkill}</a></div> --%>
			<c:forEach items="${job.keySkills}" var="keySkill" varStatus="status">
				<div class="tagitem color${status.count}">
					<span>&nbsp;</span><a href="#">${keySkill}</a>
				</div>
			</c:forEach>
		</div>
		<div class="row m_t10 text-left">

			<h4>
				<a href="#interview-view.html?id{{data.commentId}}"><strong>${job.title}</strong></a>
			</h4>
			<div class="clearfix">
				<div class="media">
					<div class="cmplogo pull-left">
						<a href="#"><img src="images/company.jpg" style="width:27px"
							alt="wipro"></a>
					</div>
					<div class="media-body">
						<h5 class="media-heading">
							<a href="#">${job.companyName} (${job.experience} yrs.)</a>
						</h5>
						<span class="font12">${job.location}</span>
					</div>
				</div>
				<div class="ratting_star"></div>
			</div>

			<h5>
				<strong>Job description:</strong>
			</h5>
			<p class="font12">
				<c:choose>
					<c:when test="${fn:length(job.jobDesc) gt 250}">
							            ${fn:substring(job.jobDesc,0,249)}
							            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							            <a
							href="/url_to_show_more_details_for_aid=${job.adId}"
							class="showmore">read more</a>
					</c:when>
					<c:otherwise>
							           ${job.jobDesc}
							       </c:otherwise>
				</c:choose>
			</p>
			<div class="row m_b10">
				<div class="col-xs-12 viewinsight">
					<div class="col-xs-3">
						<div class="row">
							<img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-plike" /> <span>1.2k</span>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="row">
							<img class="cus-icon cus-pview" src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /> <span>1.2k</span>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="row">
							<img class="cus-icon cus-plus" src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /> <span>1.2k</span>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="row">
							<img class="cus-icon cus-pshare" src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /> <span>1.2k</span>
						</div>
					</div>
					<div class="col-xs-12 ratting_star"></div>
					<a href="#" class="btn btn-primary col-xs-5">APPLY</a>
				</div>
			</div>

		</div>
	</div>
	<!-- SINGLE JOB ENDS HERE  -->




</div>