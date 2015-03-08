<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
School News
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide">
 <c:forEach items="${news}" var="newsContent">
 <a href="/${newsContent.alias}" target="_blank"> ${newsContent.title }</a>

  <br/> 
 </c:forEach>			
</div>						<!-- ==================== -->