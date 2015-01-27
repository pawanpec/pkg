<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
School News
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide">
 <c:forEach items="${news}" var="newsContent">
 ${newsContent.title }
  <br/> <br/>
 </c:forEach>			
</div>						<!-- ==================== -->