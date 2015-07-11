<c:if test="${not empty content.sd}">
<div class="tab_main">
	<ul>
		<p>
			Basic Details of <b>${content.title}</b>
		</p>
		<li><div>Name of School</div>
			<div>${content.sd.SN}</div></li>
		<li><div>Year of Foundation</div>
			<div>${content.sd.YOF}</div></li>
		<li><div>Affiliation Number</div>
			<div>${content.sd.AFF_NO}</div></li>
		<li><div>Status of The School</div>
			<div>${content.sd.SOS}</div></li>
		<li><div>Name of Trust/ Society/ Managing Committee</div>
			<div>${content.sd.TN}</div></li>
		<p>
			Contact Details of <b>${content.title}</b>
		</p>
		<li><div>Email</div>
			<div>${content.sd.E}</div></li>
		<li><div>Website</div>
			<div>${content.sd.W}</div></li>
		<li><div>Postal Address</div>
			<div>${content.sd.PA}</div></li>
		<li><div>Pin Code</div>
			<div>${content.sd.PIN}</div></li>
		<li><div>Phone No.</div>
			<div>${content.sd.PHONE_NO}</div></li>
	</ul>
</div>
</c:if>
<c:if test="${not empty content.schoolBean.LogoPath}">
	<img src="<%=WebConstants.LOGO_URL %>${content.schoolBean.LogoPath}"
		alt="${content.title}" data-errsrc="round" data-font="30"
		data-width="60" style="width:63px;" />
</c:if>
<c:if test="${ empty content.schoolBean.LogoPath}">
	<span data-firstletter="${content.title}" class="width60 position"
		data-type="round" data-font="30"></span>
</c:if>
<c:if test="${content.type eq 'group' and empty content.sd}">
					${content.body.value}
				</c:if>
<c:if test="${content.type eq 'group' and not empty content.sd}">
</c:if>
<c:if test="${content.type ne 'group'}">
					${content.body.value}
				</c:if>


