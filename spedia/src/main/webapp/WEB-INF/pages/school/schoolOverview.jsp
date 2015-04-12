<!--########### COMPANY OVERVIEW WITH LOGO ENDS HERE ###########-->
		<div class="story-wrap z2new">
			<div class="row">
				<div class="text-left notifyRow">
					<c:if test="${not empty content.schoolBean.LogoPath}">
						<img src="<%=WebConstants.LOGO_URL %>${content.schoolBean.LogoPath}" alt="${content.title}" data-errsrc="round" data-font="30" data-width="60" style="width:63px;" />
					</c:if>
					<c:if test="${ empty content.schoolBean.LogoPath}">
						<span data-firstletter="${content.title}" class="width60 position" data-type="round" data-font="30"></span>
					</c:if>
					
				</div>
				<c:if test="${content.type eq 'group' and empty content.sd}">
					${content.body.value}
				</c:if>
				<c:if test="${content.type eq 'group' and not empty content.sd}">
				Basic Details of <b>${content.title}</b>
				<div id="overview">
					<p><strong>Name of School</strong>: <span	style="text-transform: capitalize">
					${content.sd.SN}</span></p>
					<p><strong>Year of Foundation</strong>: <span	style="text-transform: capitalize">
					${content.sd.YOF}</span></p>
					<p><strong>Affiliation Number</strong>: <span	style="text-transform: capitalize">
					${content.sd.AFF_NO}</span></p>
					<p><strong>Status of The School</strong>: <span	style="text-transform: capitalize">
					${content.sd.SOS}</span></p>
					<p><strong>Name of Trust/ Society/ Managing Committee</strong>: <span	style="text-transform: capitalize">
					${content.sd.TN}</span></p>
				</div>
				Contact Details of <b> ${content.title}</b>
				<div id="contactDetails">
					<p><strong>Email</strong>: <span	style="text-transform: capitalize">
					${content.sd.E}</span></p>
					<p><strong>Website</strong>: <span	style="text-transform: capitalize">
					${content.sd.W}</span></p>
					<p><strong>Postal Address</strong>: <span	style="text-transform: capitalize">
					${content.sd.PA}</span></p>
					<p><strong>Pin Code</strong>: <span	style="text-transform: capitalize">
					${content.sd.PIN}</span></p>
					<p><strong>Phone No.</strong>: <span	style="text-transform: capitalize">
					${content.sd.PHONE_NO}</span></p>
				</div>
				</c:if>
				<c:if test="${content.type ne 'group'}">
					${content.body.value}
				</c:if>
				
			</div>
				
		</div>
		