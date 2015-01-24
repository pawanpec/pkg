<!--########### COMPANY REVIEW WEDGIT STARTS HERE ###########-->
<!-- =================== -->
<div class="col-sm-4 col-md-3 item account-card interview-card ng-hide" data-ng-hide="reviewWedgitData.length > 0">
 <div class="clearfix card-heading">
		<ul class="commands-btn">
			<li><a data-original-title="Help" href="javascript:void(0)"
				class="tooltipShow" data-toggle="tooltip" data-placement="top"
				title=""> <img
					src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-help" alt="help">
			</a></li>
		</ul>
	</div>
<div class="story-wrap z2new company-detail">
	<div class="social-share">
		<ul>
			<li><a href="javascript:void(0)" 
					data-upvote data-obtype="R" 
					data-obid="{{reviewWedgitData.reviewId}}" 
					data-upelement="span#vote-{{reviewWedgitData.reviewId}}" 
					data-dsclass="upvoted" 
					data-preload="" 
					data-ng-class="reviewWedgitData.isUpVoted=='true' ?'upvoted':'dd'">
					<img class="cus-icon cus-plike-white" src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" />
				</a>
			</li>
			<li class="social-list"><a href="javascript:void(0)"><img alt="share" src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-soci-share"></a>
				<div data-addthis-toolbox data-url="<%=WebConstants.APPLICATION_URL%>{{reviewWedgitData.reviewURL}}" data-title="{{reviewWedgitData.reviewTitle}}" id="bp-{{reviewWedgitData.reviewId}}" class="list addthis_toolbox">
			        <a class="lista addthis_button_facebook"></a>
			        <a class="lista addthis_button_twitter"></a>
			        <a class="lista addthis_button_google_plusone_share"></a>
			        <a class="lista addthis_button_email"></a>
			        <a class="lista addthis_button_reddit"></a>
			        <a class="lista addthis_button_linkedin"></a>
			        <!-- <a class="lista addthis_button_pinterest"></a> -->
		      	</div>
			</li>
		</ul>
	</div>
	<span class="recommendationstatus depends {{getStatus(reviewWedgitData.reviewOverallRating)}}" style="display: none;">
		<img class="cus-icon" src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" alt="status" />
	</span>
	<h3 class="ellipsetext"><a target="_blank" data-ng-href="{{reviewWedgitData.reviewURL}}" data-ng-bind="reviewWedgitData.reviewTitle"></a></h3>
	<div class="row">
		<div class="col-xs-12">
			<p><strong><span data-ng-bind="reviewWedgitData.modifiedDate"></span>,</strong> by <span data-ng-bind="reviewWedgitData.employerType"></span> employee working as <strong data-ng-bind="reviewWedgitData.employeeDesignation"></strong></p>
		</div>
	</div>
	
	
	<div class="col-sm-12 text-center colorfff companyrating positionCard">
		<div class="row">
			<div class="col-xs-3" style="background:{{color[$index].code}}" data-ng-init="color=[{code:'#1c817e'},{code:'#d9823d'},{code:'#333333'},{code:'#c1494b'}]" data-ng-repeat="rate in reviewWedgitData.ratings">	
				<div class="cmpratinginfo row">
					<strong><strong data-ng-bind="rate.value"></strong>/5</strong>
					<label data-ng-bind="rate.key"></label>
				</div>
			</div>
		</div>
	</div>
	<div class="row notifyRow cus-clearfix notification">
	</div>
	<div class="row notifyRow text-center cus-clearfix notification">
		<div class="col-xs-8 viewinsight margincenter">
			<div class="col-xs-6 viewin">
				<div class="row">
					<img class="cus-icon cus-plike"
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"> 
						<span id="vote-{{reviewWedgitData.reviewId}}" data-ng-bind="reviewWedgitData.cntVoteUp"></span>
				</div>
			</div>
			<div class="col-xs-6 viewin">
				<div class="row">
					<img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-pview"> 
					<span data-ng-bind="reviewWedgitData.cntView"></span>
				</div>
			</div>
		</div>
	</div>
</div>
					
</div>						<!-- ==================== -->