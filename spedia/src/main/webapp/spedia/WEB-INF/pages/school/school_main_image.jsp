<%
int random=(int)Math.floor((Math.random()*10+1));
String defaultPath1=WebConstants.IMAGE_URL+"images/static/"+random+".jpg";
%>
<div class="details_image"><c:if test="${empty companyText.imagePath}">
								<img src='<%=defaultPath1%>' id="about_img" />
						   </c:if>
						   <c:if test="${not empty companyText.imagePath}">
							<img src='<%=WebConstants.SUB_SECTION_URL %>${companyText.imagePath}' id="about_img" />
</c:if>
</div>