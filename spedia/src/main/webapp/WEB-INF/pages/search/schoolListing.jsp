<li>
          <div class="school_title"><a href="/${newsContent.alias }" target="_blank"
						title="${newsContent.title}"><strong>${newsContent.title}</strong></a>
						<fmt:formatNumber value="${newsContent.review.oar}" pattern="0.0" />/5</div>
          <div class="school_description">
          <c:if test="${not empty newsContent.body.summary}">
					<p class="ellipsetext newscontentdesc">${fn:substring(newsContent.body.summary, 0, 100)}</p>
				</c:if>
				<c:if test="${empty newsContent.body.summary}">
					<p class="ellipsetext newscontentdesc">${fn:substring(newsContent.body.value, 0, 100)}</p>
				</c:if>
          </div>
          <div class="school_pic" data-ng-if="insight.imageName !== null"><a href="/${newsContent.alias }" target="_blank"
						title="${newsContent.title}">
					 <img alt="${newsContent.title}" id="contentImage"
						src="/spedia/images/static/${theCount.count}.jpg"
						style="width: 100%"></a></div>
          <div class="follow_row">
            <c:if test="${fn:contains(newsContent.f, uid)}">
								<input type="button" class="btn btn-xs btn-primary" id="followSchool_${index}" onclick="follow(${newsContent.nid},this);" value="FOLLOWING">
							</c:if>
							<c:if test="${not fn:contains(newsContent.f, uid)}">
								<input type="button" class="btn btn-xs btn-primary" id="followSchool_${index}" onclick="follow(${newsContent.nid},this);" value="FOLLOW">
							</c:if>
          </div>
        </li>
  