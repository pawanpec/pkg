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