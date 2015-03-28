
<%
int random=(int)Math.floor((Math.random()*10+1));
String defaultPath1=WebConstants.IMAGE_URL+"images/static/"+random+".jpg";
%>

<div class="col-sm-9 item" style="padding-left:2%;" >
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
			</div>
		
	<!--########### About School Ends Here ###########-->
	<!--########### Company OverView with logo Start Here ###########-->
	<%@include file="schoolOverview.jsp"%>
	<!--########### Company OverView with logo END Here ###########-->
	<!--########### School Map Start Herr ###########-->
	 <%@include file="schoolmap.jsp"%> 
		<!--########### School Map Ends Here ###########-->
</div>
