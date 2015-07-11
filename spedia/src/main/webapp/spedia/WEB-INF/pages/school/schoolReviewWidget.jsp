<div class="school_review">
<h2>School Reviews <span><fmt:formatNumber value="${content.review.oar}" pattern="0.0" />/5 (${content.review.count} Review)</span></h2>
<ul>
<c:forEach items="${reviews}" var="review">
<li>${review.review }</li>
</c:forEach>
</ul>
</div>