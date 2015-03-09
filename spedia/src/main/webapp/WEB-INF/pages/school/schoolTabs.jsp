
<%
int random=(int)Math.floor((Math.random()*10+1));
String defaultPath1=WebConstants.IMAGE_URL+"images/static/"+random+".jpg";
%>

<div class="col-sm-6 item" >
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
	<!--########### About School ###########-->
			<div class="row">
				<div class="col-sm-12">
					<div class="cmpwho z2new story-wrap account-card interview-card">
						<div class="cmpimg">
							<c:if test="${empty companyText.imagePath}">
								<img src='<%=defaultPath1%>' id="about_img" />
						   </c:if>
						   <c:if test="${not empty companyText.imagePath}">
							<img src='<%=WebConstants.SUB_SECTION_URL %>${companyText.imagePath}' id="about_img" />
						   </c:if>
						</div>
						<div class="cmpwhodetail">
							<h3>About Us</h3>
							${content.body.summary}
						</div>
					</div>
				</div>
				<!--########### School Map Start Herr ###########-->
					<%@include file="schoolmap.jsp"%>
				<!--########### School Map Ends Here ###########-->
			</div>
		
	<!--########### About School Ends Here ###########-->
</div>
