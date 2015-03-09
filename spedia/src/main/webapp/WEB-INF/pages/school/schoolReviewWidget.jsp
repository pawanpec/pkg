<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
School Reviews
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide">
Overall Rating
<fmt:formatNumber value="${content.review.oar}" pattern="0.0" />/5 (${content.review.count} Review)
<br/>
 <c:forEach items="${reviews}" var="review">
 ${review.review }
 <br/> <br/>
 
 
 </c:forEach>			
</div>						<!-- ==================== -->