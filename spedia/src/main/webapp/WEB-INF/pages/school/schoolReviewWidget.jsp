<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide">
 <c:forEach items="${reviews}" var="review">
 ${review.review }
 
 </c:forEach>			
</div>						<!-- ==================== -->