<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
<div class="col-sm-3 item account-card interview-card">

	<div class="story-wrap z2new">
		<div class="row">
			<div class="text-left notifyRow">
				School Reviews
				<div>
					Overall Rating
					<fmt:formatNumber value="${content.review.oar}" pattern="0.0" />
					/5 (${content.review.count} Review) <br />
					<ul>
					<c:forEach items="${reviews}" var="review">
					<li>
 						${review.review }</li>
					</c:forEach>
					</ul>
				</div>


			</div>
		</div>
	</div>
	<!-- ==================== -->