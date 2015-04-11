<title>Home Page</title>
<div>
	<%-- <%@include file="searchHome.jsp"%>
	<%@include file="bannerHome.jsp"%> --%>
</div>
<div class="clearfix"></div>
<div class="homepage">
	<!--******* Feature Screen *************-->
	<div class="position">
		<div class="container-fluid serachbanner">
			<div class="margincenter col-sm-10 text-center position serachblk">
				<h1 class="robotolight nobotmargin heading">
					<strong>School Search Made Easy</strong>
				</h1>
				<h1 class="robotolight notopmargin hidden-xs">&nbsp;</h1>
				<div class="row text-center">
					<div class="col-xs-12 col-sm-9 margincenter position">
						<form
							class="search-input col-xs-9 visible-sm visible-md visible-lg"
							name="searchSchool" method="post" autocomplete="off"
							action="/spedia/search.html">
							<select name=slist id="stateList" style="float:right">
								<option value="Delhi">Delhi</option>
								<option value="Goa">Goa</option>
							</select>
							<div class="input-group"
								style="width: 200px; display: inline-flex; float:right">
								<p>
									<input type="text" id="schoolSearchBox" />
								</p>
							</div>
							<input style="visibility: visible;" type="hidden" id="nid"
								name="nid" value="">
						</form>
					</div>
				</div>
			</div>

			<div class="row homepagetab hidden-xs">
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-search"></i> Search Schools <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Find school near to your home</p>
					<a href="searchSchool.html"
						class="overlayanchor" target="_blank"></a>
				</div>
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-screenshot"></i> Follow School <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Follow School to get School Update in your Inbox</p>
				</div>
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-tower"></i>Get Admission ALert <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Strategize! Improve your chances of landing your dream
						School</p>
					<a href="contentType.html?type=nursery_admission" class="overlayanchor" target="_blank"></a>
				</div>
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-star"></i> Research Schools <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Review/Rating - Find what Parents are saying</p>
				</div>
			</div>
			<div class="overlayanchor homepattern"></div>
			<div class="overlayanchor">
				<img src="<%=WebConstants.IMAGE_URL%>images/video_screen.jpg"
					class="img100" />
			</div>
		</div>
	</div>

	<%@include file="featuredSchool.jsp"%>
	<%@include file="whySp.jsp" %>
	<div class="row hidden-xs">
		<div class="margincenter col-sm-10 text-center">
			<h1 class="robotolight">
				WHAT Parents ARE <strong>SAYING</strong> ABOUT US
			</h1>
		</div>
	</div>
	  <%@include file="testimony.jsp" %> 
	<div class="row fearturelist"></div>
</div>
