<!--########### COMPANY OVERVIEW WITH LOGO ENDS HERE ###########-->
<div class="col-sm-3 item account-card interview-card" >
<div class="clearfix card-heading">
				<ul class="commands-btn">
					<li><a data-original-title="Help" href="javascript:void(0)"
						class="tooltipShow" data-toggle="tooltip" data-placement="top"
						title=""> <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-help" alt="help">
					</a></li>
				</ul>
			</div>
		<div class="story-wrap z2new">
			<div class="row">
				<div class="text-left notifyRow">
					<c:if test="${not empty companyLogoImage}">
						<img src="<%=WebConstants.LOGO_URL %>${companyLogoImage}" alt="${content.title}" data-errsrc="round" data-font="30" data-width="60" style="width:63px;" />
					</c:if>
					<c:if test="${ empty companyLogoImage}">
						<span data-firstletter="${content.title}" class="width60 position" data-type="round" data-font="30"></span>
					</c:if>
					
				</div>
				<div class="ratting_star text-left"> 
					<strong>${content.title}</strong>
				</div>
			${content.body.value}
			</div>
		</div>
	</div>
<!--########### COMPANY OVERVIEW WITH LOGO ENDS HERE ###########-->