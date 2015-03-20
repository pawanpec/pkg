<!--########### School REVIEW WEDGIT STARTS HERE ###########-->
<div class="col-sm item account-card interview-card" >

		<div class="story-wrap z2new">
			<div class="row">
				<div class="text-left notifyRow">
School News
<div class="col-sm-9 col-md-3 item account-card interview-card ng-hide">
 <c:forEach items="${news}" var="newsContent">
 <a href="/${newsContent.alias}" target="_blank"> ${newsContent.title }</a>

  <br/> 
 </c:forEach>			
</div>						<!-- ==================== -->


</div>
		</div>
