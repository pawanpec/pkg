<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
School Reviews
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide">
 OverAll Rating
 <c:forEach items="${reviews}" var="review">
 ${review.review }
 <br/> <br/>
 
 
 </c:forEach>			
</div>						<!-- ==================== -->