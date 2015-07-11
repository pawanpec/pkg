<c:forEach items="${relatedContent}" var="newsContent"
	varStatus="theCount">
	<div class="news_tick">
		<div class="image">
			<c:if test="${newsContent.type eq 'summer_camp'}">
				<img id="contentImage" alt="${newsContent.title}"
					src="/spedia/images/summer_camp/${theCount.count}.jpg"
					style="width: 100%">
			</c:if>
			<c:if test="${fn:contains(newsContent.type, 'nursery_admission')}">
				<img id="contentImage" alt="${newsContent.title}"
					src="/spedia/images/nursery_admission/${theCount.count}.jpg"
					style="width: 100%">
			</c:if>
		</div>
		<div class="image_data">
			<div class="news_title">
				<a href="/${newsContent.alias }" target="_blank"
					title="${newsContent.title}">${newsContent.title}</a>
			</div>
		</div>
	</div>
</c:forEach>