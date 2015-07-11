<li class="col-sm-4">
	<div class="tile tile-height">
        <div class="school_title">
            <a href="/${newsContent.alias }" target="_blank"
                title="${newsContent.title}"><strong>${newsContent.title}</strong></a>
        </div>
        <div class="school_description">
            <c:if test="${not empty newsContent.body.summary}">
                <p class="ellipsetext newscontentdesc">${fn:substring(newsContent.body.summary, 0, 100)}</p>
            </c:if>
            <c:if test="${empty newsContent.body.summary}">
                <p class="ellipsetext newscontentdesc">${fn:substring(newsContent.body.value, 0, 100)}</p>
            </c:if>
        </div>
        <div class="school_pic">
            <a href="/${newsContent.alias }" target="_blank" title="${newsContent.title}"> </a>
            <c:if test="${newsContent.type eq 'summer_camp'}">
                <img id="contentImage" alt="${newsContent.title}"
                    src="/spedia/images/summer_camp/${theCount.count}.jpg"
                    >
            </c:if>
            <c:if test="${fn:contains(newsContent.type, 'nursery_admission')}">
                <img id="contentImage" alt="${newsContent.title}"
                    src="/spedia/images/nursery_admission/${theCount.count}.jpg"
                    >
            </c:if>
        </div>
        </div>
</li>




