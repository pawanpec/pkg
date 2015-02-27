<%@ page import="com.spedia.utils.WebConstants"%>
<div>
	<%@include file="searchHome.jsp" %>
	<%@include file="bannerHome.jsp" %>
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
							data-ng-click="homesearch.autocomplete == 2 ? homesearch.autocomplete = 0 : null "
							data-ng-init="homesearch = {isDisabled: false, class:'', autocomplete:2}"
							action="/jobbuzz/search.html" id="mainSearchForm" method="post"
							autocomplete="off">
							<tabset class="homepage-tabs"> <tab heading="Companies"
								class="ser-tabs"
								data-ng-click="mainSearchsubmenu('2','companies');">
							<div class="position">
								<img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
									class="cus-icon cus-homesearch" /> <input
									class="form-control serachctrl" type="text"
									id="compamySearchTextH" name="compamySearchTextH"
									data-ng-model="search.compamySearchTextH"
									placeholder="Enter School name e.g. Dps"
									typeahead-on-select='onSelectMainSearch($item, $model, $label)'
									data-ng-pattern="/^[a-zA-Z0-9]/" maxlength="100"
									typeahead="suggestion.companyName for suggestion in loadCompanies($viewValue) | limitTo:5"
									typeahead-min-length="3" class="form-control"
									aria-describedby="basic-companies"
									data-ng-keyup="$event.keyCode == 13 || $event.keyCode == 186 ? mainSearchSubmitCompany(search.compamySearchTextH) : null" />
							</div>
							</tab> </tabset>
						</form>
					</div>
				</div>
			</div>

			<div class="row homepagetab hidden-xs">
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-search"></i> Search Jobs <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Find a job you'll love from over 300,000 open positions</p>
					<a href="/jobbuzz/all-jobs.html?datacenter=7&amp;view=all"
						class="overlayanchor" target="_blank"></a>
				</div>
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-star"></i> Research Schools <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Love it? / Hate it? - Find what employees are saying</p>
					<a href="/discover/" class="overlayanchor" target="_blank"></a>
				</div>
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-screenshot"></i> Interview Questions
						<img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Be a hunter. Prepare from over 55,000 Interview Questions</p>
					<a href="/interview/" class="overlayanchor" target="_blank"></a>
				</div>
				<div class="col-sm-3 position">
					<h3>
						<i class="glyphicon glyphicon-tower"></i> Admission Insights <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Strategize! Improve your chances of landing your dream School</p>
					<a href="/insight/" class="overlayanchor" target="_blank"></a>
				</div>
			</div>
			<div class="overlayanchor homepattern"></div>
			<div class="overlayanchor">
				<img src="<%=WebConstants.IMAGE_URL%>images/video_screen.jpg"
					class="img100" />
			</div>
		</div>
	</div>
	
	<%@include file="featuredSchool.jsp" %>
	<%-- <%@include file="whySp.jsp" %> --%>

	<div class="row hidden-xs">
		<div class="margincenter col-sm-10 text-center">
			<h1 class="robotolight">
				WHAT Parents ARE <strong>SAYING</strong> ABOUT US
			</h1>
		</div>
	</div>
	<%-- <%@include file="testimony.jsp" %> --%>
	<div class="row fearturelist"></div>
</div>
