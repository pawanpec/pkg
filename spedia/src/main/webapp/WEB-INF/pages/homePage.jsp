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
					<strong>Make Smarter Career Decisions</strong>
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
									placeholder="Enter company name e.g. Google"
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
						<i class="glyphicon glyphicon-star"></i> Research Companies <img
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
						<i class="glyphicon glyphicon-tower"></i> Career Insights <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-right-chevron" />
					</h3>
					<p>Strategize! Improve your chances of landing your dream job</p>
					<a href="/insight/" class="overlayanchor" target="_blank"></a>
				</div>
			</div>
			<div class="overlayanchor homepattern"></div>
			<div class="overlayanchor">
				<img src="<%=WebConstants.IMAGE_URL%>images/video_screen.jpg"
					class="img100" />
			</div>
			<video width="100%" class="overlayanchor hidden-xs" autoplay=""
				loop="">
				<source src="<%=WebConstants.IMAGE_URL%>images/movie.mp4"
					type="video/mp4" />
			</video>
		</div>
	</div>
	<%-- <div class="row notifyRow homelinks visible-xs">
		<div class="col-sm-3 position">
			<h3><i class="glyphicon glyphicon-search"></i> Search Jobs <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-right-chevron" /></h3>
			<p>Find a job you'll love from over 300,000 open positions</p>
			<a href="/jobbuzz/all-jobs.html?datacenter=7&amp;view=all" class="overlayanchor" target="_blank"></a>
		</div>
		<div class="col-sm-3 position">
			<h3><i class="glyphicon glyphicon-star"></i> Research Companies <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-right-chevron" /></h3>
			<p>Love it? / Hate it? - Find what employees are saying</p>
			<a href="/discover/" class="overlayanchor" target="_blank"></a>
		</div>
		<div class="col-sm-3 position">
			<h3><i class="glyphicon glyphicon-screenshot"></i> Interview Questions <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-right-chevron" /></h3>
			<p>Be a hunter. Prepare from over 55,000 Interview Questions</p>
			<a href="/interview/" class="overlayanchor" target="_blank"></a>
		</div>
		<div class="col-sm-3 position">
			<h3><i class="glyphicon glyphicon-tower"></i> Career Insights <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-right-chevron" /></h3>
			<p>Strategize! Improve your chances of landing your dream job</p>
			<a href="/insight/all/" class="overlayanchor" target="_blank"></a>
		</div>
	</div> --%>
	<div class="container-fluid fearturelist">
		<div class="margincenter col-sm-10 text-center">
			<h2 class="robotolight font36">
				<strong>FEATURED COMPANIES</strong>
			</h2>
		</div>
		<div class="margincenter col-sm-11"
			data-ng-controller="topCompaniesCTRL">
			<div class="row">
				<div class="col-sm-3" data-ng-repeat="topCompany in topCompanies"
					ng-if="$index < 4">
					<div class="companyarea clearfix">
						<div class="text-right">
							<input type="button"
								data-ng-show="topCompany.followingCompany==0"
								class="btn btn-xs btn-primary" value="FOLLOW"
								data-ng-click="topCompany.followingCompany=2;followCompany(topCompany,1);">
							<input type="button"
								data-ng-show="topCompany.followingCompany==1"
								class="btn btn-xs btn-primary" value="UNFOLLOW"
								data-ng-click="topCompany.followingCompany=2;followCompany(topCompany,0);">
							<span data-ng-show="topCompany.followingCompany == 2"
								class="btn btn-primary btn-xs colorfff"><img
								src="<%=WebConstants.IMAGE_URL%>images/followloader.gif"
								class="logo" alt="loader" /></span>
						</div>
						<div class="clearfix notifyRow">
							<div class="media">
								<div class="cmplogo pull-left width48">
									<a href="{{topCompany.companySeoUrl}}"><img
										data-ng-src="<%=WebConstants.LOGO_URL%>{{topCompany.companyLogo}}"
										alt="{{topCompany.companyName}}" data-errsrc="round"
										data-font="18" data-width="48" /></a>
								</div>
								<div class="media-body">
									<h5 class="media-heading ellipsesingle redcolor nobotmargin">
										<a href="{{topCompany.companySeoUrl}}" target="_blank"
											data-ng-bind="topCompany.companyName"
											title="{{topCompany.companyName}}"></a>
									</h5>
									<em class="font10 display-blk">{{topCompany.companyLocation}}</em>
									<div>
										<input type="number"
											data-star-rating="{{topCompany.companyOverAllRating}}"
											name="reviewrate" readonly="true" min="0" max="5"
											data-ng-model="review.overallRating"
											value="{{topCompany.companyOverAllRating}}" step="0.1"
											data-rate="0" data-stars="5" data-size="xs"
											data-default-caption="{rating}/5" />
									</div>
								</div>
							</div>
						</div>
						<div class="clearfix notifyRow text-center homepageimg">
							<div class="">
								<img data-ng-if='topCompany.defaultImage == false'
									data-ng-src="<%=WebConstants.PHOTOS_URL%>{{topCompany.companyImage}}"
									class="img100" alt="{{topCompany.companyName}}" /> <img
									data-ng-if='topCompany.defaultImage == true'
									data-ng-src="<%=WebConstants.PHOTOS_URL%>{{topCompany.companyImage}}{{imageIndex[$index]}}.jpg"
									class="img100" alt="{{topCompany.companyName}}" />
							</div>
						</div>
						<div class="clearfix text-center">
							<ul class="infolist">
								<li data-ng-if="topCompany.jobCount > 0"><a
									data-ng-href="{{topCompany.companyJobSeoUrl}}" target="_blank">{{topCompany.jobCount
										| formatJBCountUpto1Decimal}} Jobs</a></li>
								<li data-ng-if="topCompany.reviewCount > 0"><a
									data-ng-href="{{topCompany.companyReviewSeoUrl}}"
									target="_blank">{{topCompany.reviewCount |
										formatJBCountUpto1Decimal}} Reviews</a></li>
								<li data-ng-if="topCompany.interviewCount > 0"><a
									data-ng-href="{{topCompany.companyInterviewSeoUrl}}"
									target="_blank">{{topCompany.interviewCount |
										formatJBCountUpto1Decimal}} Interviews</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--******* feature Screen *************-->
	<!--******* Why JobBuzz *************-->
	<div class="fearturelist fearturecontainer hidden-xs">
		<div class="row">
			<div class="margincenter col-sm-10 text-center">
				<h2 class="robotolight font36">
					WHY <strong data-ng-bind="jbCounts.userCount">3100000</strong>
					USERS USE JOBBUZZ?
				</h2>
				<h3 class="font16 col-sm-12">JobBuzz has consistently helped
					them take career decisions based on the most authentic data
					available online. Every interview question, company review, salary
					data and job on JobBuzz has been carefully moderated by our
					experts.</h3>
			</div>
		</div>
		<div class="container fearturelist">
			<div class="margincenter col-xs-10">
				<section class="row notifyRow">
					<div class="col-sm-6">
						<div class="clearfix">
							<div class="col-sm-10 col-md-8 notifyRow">
								<article class="media ">
									<span class="pull-left"> <img
										src="<%=WebConstants.IMAGE_URL%>images/icon-home-tea.png"
										alt="Simplifying Decisions" /></span>
									<div class="media-body">
										<h4 class="notopmargin">Simplifying Decisions</h4>
										<p class="font12">We empower you to make decisions by
											arming you with cutting edge data.</p>
									</div>
								</article>
							</div>
						</div>
						<div class="clearfix">
							<div class="col-sm-10 col-md-8 notifyRow">
								<article class="media ">
									<span class="pull-left"> <img
										src="<%=WebConstants.IMAGE_URL%>images/benifit.png"
										alt="Its Free and Rewarding" /></span>
									<div class="media-body ">
										<h4 class="notopmargin">Its Free and Rewarding</h4>
										<p class="font12">We will never charge you for using our
											services.</p>
									</div>
								</article>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="clearfix">
							<div class="col-sm-10 col-md-8 notifyRow">
								<article class="media ">
									<span class="pull-left"><img
										src="<%=WebConstants.IMAGE_URL%>images/icon-home-reach.png"
										alt="Huge Community" /></span>
									<div class="media-body ">
										<h4 class="notopmargin">Huge Community</h4>
										<p class="font12">Make choices based on the experience of
											lakhs of fellow JBians.</p>
									</div>

								</article>
							</div>
						</div>
						<div class="clearfix">
							<div class="col-sm-10 col-md-8 notifyRow">
								<article class="media ">
									<span class="pull-left"><img
										src="<%=WebConstants.IMAGE_URL%>images/icon-home-privacy.png"
										alt="Unmatched Privacy" /></span>
									<div class="media-body ">
										<h4 class="notopmargin">Unmatched Privacy</h4>
										<p class="font12">Your identity is safe with us at all
											times. Contribute without fear.</p>
									</div>
								</article>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<!--************* Why JobBuzz ****************-->

	<div class="row hidden-xs">
		<div class="margincenter col-sm-10 text-center">
			<h1 class="robotolight">
				WHAT USERS ARE <strong>SAYING</strong> ABOUT US
			</h1>
		</div>
	</div>
	<div class="container fearturelist hidden-xs">
		<div class="margincenter col-xs-10">
			<section class="row notifyRow">
				<div class="col-sm-4">
					<article class="media">
						<span class="pull-left profile-homewrap z1"> <img
							src="<%=WebConstants.IMAGE_URL%>images/pic1.jpg" alt="profile" /></span>
						<div class="media-body">
							<p>
								<em>Was it ever your dream to be in one of the top-notch
									companies in India &amp; you thought the interview rounds were
									too hard. Then look no further.</em>
							</p>
							<span class="display-blk font18"><strong>Ashima
									Gupta</strong></span> <span class="error">Pune</span>
						</div>
					</article>
				</div>
				<div class="col-sm-4">
					<article class="media">
						<span class="pull-left profile-homewrap z1"> <img
							src="<%=WebConstants.IMAGE_URL%>images/pic2.jpg" alt="profile" /></span>
						<div class="media-body">
							<p>
								<em>Before Jobbuzz I used to collect all the questions
									&amp; categorize them in different sections - phew!! it was a
									painful job - If that work has already been done by
									someone(very decently), why not use it.</em>
							</p>
							<span class="display-blk font18"><strong>Manoj
									Bansal</strong></span> <span class="error">Noida</span>
						</div>
					</article>
				</div>
				<div class="col-sm-4">
					<article class="media">
						<span class="pull-left profile-homewrap z1"> <img
							src="<%=WebConstants.IMAGE_URL%>images/pic3.jpg" alt="profile" /></span>
						<div class="media-body">
							<p>
								<em>Invaluable asset for job seeker to compare companies
									and search through a lot of open positions.</em>
							</p>
							<span class="display-blk font18"><strong>Kritika
									Joshi</strong></span> <span class="error">Bangalore</span>
						</div>
					</article>
				</div>
			</section>
		</div>
	</div>
	<div class="row fearturelist"></div>
</div>
