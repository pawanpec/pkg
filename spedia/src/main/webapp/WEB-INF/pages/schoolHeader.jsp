<%@ include file="include.jsp" %>
	<div class="navbar navbar-inverse hidden-xs topheader"> 
	    <div class="container-fluid">
			<!--Top Navigation-->
			<div class="row">
				<div class="navbar-header">
					<button data-target=".navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				</div>
				<nav class="navbar-collapse collapse topnavbar">
				<div class="row">
					<ul class="nav navbar-nav">
					 <!--  <li><a href="http://www.timesjobs.com/" target="_blank">TimesJobs</a></li>
					  <li><a href="/"><strong>Job Buzz</strong></a></li>
					  <li><a href="http://stepahead.timesjobs.com/" target="_blank">StepAhead</a></li>
					  <li><a href="http://www.techgig.com/" target="_blank">TechGig</a></li> -->
					</ul>
				</div>
				</nav>
			</div>
			<!--  Top Navigation  --> 
	    </div>
	  </div>
	  <header id="fixedNavigation" class="clearfix">
		<div class="clearfix z2new" id="fixed">
			<div class="xs-headerl">
			  <button type="button" class="navbar-toggle mobilemnubtn" id="navbar-toggle" data-target="#navbar-collapse1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <h1 class="logo"><a href="/"><img src="<%=WebConstants.IMAGE_URL %>images/jobuzz_logo.png" alt="JobBuzz"></a></h1>
			</div>
			<nav class="main-mnu" id="navbar-collapse1">
				<ul class="nav navbar-nav">
					<li class="active home"><i class="top"></i><a href="/"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /><span>home</span></a><i class="bot"></i></li>
					<li class="discover"><i class="top"></i><a href="/discover/"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /><span>discover</span></a><i class="bot"></i></li>
					<li class="jobs"><i class="top"></i><a href="/jobs/all/"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /><span>jobs</span></a><i class="bot"></i></li>
					<li class="interview"><i class="top"></i><a href="/interview/"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /><span>interviews</span></a><i class="bot"></i></li>
					<li class="insights"><i class="top"></i><a href="/insight/all/"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /><span>insights</span></a><i class="bot"></i></li>
					<li class="logosm visible-xs"><a href="/"><img src="<%=WebConstants.IMAGE_URL %>images/jobuzz_logo.png" alt="JobBuzz"></a></li>
				</ul>
				<div class="clearfix visible-sm"></div>
			</nav>
			<div class="navbar-right right-mnu position">
				<a href="javascript:void(0);" data-ng-click="mobileSearchvisible(null);  $event.stopPropagation();" class="search mobileserbtn" data-ng-show="!isMobileSearch"><img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-homesearch" /></a>
				<ul class="notification xs-headerr ng-hide" data-ng-show="(isLoginInfo.loginId == null || isLoginInfo.loginId == '') && !isMobileSearch" data-ng-if="(isLoginInfo.loginId == null || isLoginInfo.loginId == '')">
					<li><a href="javascript:openmodal('loginCtrl')" class="pageview" pageurl="login">Login</a></li>
					<li><a href="javascript:openmodal('signUpctrl')" class="pageview" pageurl="register">Register</a></li>
				</ul>
	
				<ul class="notification xs-headerr ng-hide" data-ng-show="(isLoginInfo.loginId != null && isLoginInfo.loginId != '') && !isMobileSearch">
					<li class="dropdown acc-sett">
						<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
							<img class="tblecell" data-ng-if="isLoginInfo.profilePic != null && isLoginInfo.profilePic != ''" data-ng-src="{{isLoginInfo.profilePic}}" style="width:32px;" />
							<span data-ng-if="isLoginInfo.profilePic == null || isLoginInfo.profilePic == ''" data-firstletter="{{isLoginInfo.firstName}}" data-test="{{isLoginInfo.firstName}}" class="profilepic position" data-type="circle" data-font="16"></span>
							<span class="tblecell">
								<span class="visible-lg" data-ng-bind="isLoginInfo.firstName"></span> 
								<span class="caret"></span>
							</span>
					</a>
						  <ul class="dropdown-menu" role="menu">
							<li><span>Hello, <strong data-ng-bind="isLoginInfo.firstName"></strong></span></li>
							<li class="divider"></li>
							<li><a href="<%=WebConstants.APPLICATION_CONTEXT  %>profile-overview.html">Your Profile</a></li>
							<%-- <li><a href="<%=WebConstants.APPLICATION_CONTEXT  %>account-setting.html">Account Settings</a></li> --%>
							<!-- <li><a href="#">Your Posts</a></li> -->
							<li class="divider"></li>
							<li><a href="javascript:void(0)" data-ng-click="signOut()" class="text-right">Sign Out <i class="glyphicon glyphicon-log-out"></i></a></li>						
						  </ul>
						</li>
					</ul>
				<form class="search-input col-xs-9 visible-sm visible-md visible-lg" data-ng-init="scope = {isVisible: false, class:'', autocomplete:2}" action="/jobbuzz/search.html" id="searchForm" data-ng-class="isMobileSearch ? 'visible-xs' : 'f'" method="post" data-ng-click="$event.stopPropagation();" autocomplete="off">
					<div class="input-group ng-hide" data-ng-show="search.searchBy==3 || search.searchBy==-1">
					    <span class="input-group-addon jobs" title="jobs" data-ng-click="visibleOption(null); $event.stopPropagation();" id="basic-job"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search companies" /> <span class="caret"></span></span>
					    <input type="text"	id="jobsSearchText"	name="jobsSearchText" data-ng-model="search.jobsSearchText" maxlength="100" placeholder="E.g. Java Developer 3-5 years Pune" 
					  			typeahead-on-select='onSelect($item, $model, $label)'
					  			data-ng-pattern="/^[a-zA-Z0-9]/"
					  			typeahead="suggestion for suggestion in loadJobs($viewValue) | limitTo:5" 
					  			typeahead-min-length="3" class="form-control"
					  			data-ng-keyup="$event.keyCode == 13 || $event.keyCode == 186 ? headerSearchSubmitJob(search.jobsSearchText) : null" aria-describedby="basic-job" />
					  	<span class="input-group-addon mobileserbtn mobileserbtnw"  data-ng-show="isMobileSearch" data-ng-click="headerSearchSubmitJob(search.jobsSearchText)">
					  		<img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-homesearch" />
					  	</span>
				    </div>
					<div class="input-group ng-hide" data-ng-show="search.searchBy==1">
					    <span class="input-group-addon interview" title="interviews" data-ng-click="visibleOption(null); $event.stopPropagation();" id="basic-interview"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search interview" /><span class="caret"></span></span>
					    <input type="text"	id="interviewSearchText" name="interviewSearchText" maxlength="100" data-ng-model="search.interviewSearchText"  placeholder="Enter Skill, Company or Role" 
					  			typeahead-on-select='onSelect($item, $model, $label)'
					  			typeahead="suggestion.skillName for suggestion in loadInterviews($viewValue) | limitTo:5"
					  			data-ng-pattern="/^[a-zA-Z0-9]/"
					  			typeahead-min-length="3" class="form-control" aria-describedby="basic-interview" 
					  			data-ng-keyup="$event.keyCode == 13 || $event.keyCode == 186 ? headerSearchSubmitInterview(search.interviewSearchText) : null"/>
					  	<span class="input-group-addon mobileserbtn mobileserbtnw"  data-ng-show="isMobileSearch" data-ng-click="headerSearchSubmitInterview(search.interviewSearchText)">
					  		<img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-homesearch" />
					  	</span>
					</div>
					<div class="input-group ng-hide" data-ng-show="search.searchBy==2">
					    <span class="input-group-addon companies" title="companies" data-ng-click="visibleOption(null); $event.stopPropagation();" id="basic-companies"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search jobs" /><span class="caret"></span></span>
					    <input 	type="text"	id="compamySearchText"	name="compamySearchText" maxlength="100" data-ng-model="search.compamySearchText"  placeholder="Enter company name e.g. Google" 
					  			typeahead-on-select='onSelect($item, $model, $label)' data-ng-pattern="/^[a-zA-Z0-9]/"  class="form-control"
					  			typeahead="suggestion.companyName for suggestion in loadCompanies($viewValue) | limitTo:5" typeahead-min-length="3"
					  			data-ng-keyup="$event.keyCode == 13 || $event.keyCode == 186 ? headerSearchSubmitCompany(search.compamySearchText) : null"  aria-describedby="basic-companies" />
					  	<span class="input-group-addon mobileserbtn mobileserbtnw"  data-ng-show="isMobileSearch" data-ng-click="headerSearchSubmitCompany(search.compamySearchText)">
					  		<img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-homesearch" />
					  	</span>
					</div>
					
					<div class="input-group ng-hide" data-ng-show="search.searchBy==4">
					    <span class="input-group-addon {{scope.class}}" title="{{scope.class}}" data-ng-click="visibleOption(null); $event.stopPropagation();" id="basic-people"><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search compnies" /><span class="caret"></span></span>
					  	<input 	type="text"	id="peopleSearchText"	name="peopleSearchText" maxlength="100" data-ng-model="search.peopleSearchText"  placeholder="{{scope.class}}" 
					  			typeahead-on-select='onSelect($item, $model, $label)'
					  			data-ng-pattern="/^[a-zA-Z0-9]/" typeahead-min-length="3" class="form-control"
					  			data-ng-keyup="$event.keyCode == 13 || $event.keyCode == 186 ? submitform() : null" aria-describedby="basic-people" />
					  	<span class="input-group-addon mobileserbtn mobileserbtnw"  data-ng-show="isMobileSearch" data-ng-click="submitform()">
					  		<img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="cus-icon cus-homesearch" />
					  	</span>
					 </div>
					 <div>
					 	
					 </div>
					 	<ul class="dropdown-menu search-submenu" style="left: 14px; width:80px; padding: 0;" data-ng-class="scope.isVisible === true ? 'display-blk':'ng-hide'">
							<li><!-- jobs -->
								<a  data-ng-click="searchsubmenu('3','jobs',null);" href="javascript:void(0)">
								  <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search companies" />
								  <span >jobs</span>
							  </a>
							</li>
							<li><!-- compnies -->
								<a data-ng-click="searchsubmenu('2','companies',null);" href="javascript:void(0)">
								  <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search jobs" />
								  <span>companies</span>
						  		</a>
							</li>
							<li><!-- interview -->
								<a data-ng-click="searchsubmenu('1','interview',null);" href="javascript:void(0)">
								  <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search interview" />
								  <span >interview</span>
								</a>
							</li>
						<!--<li> people 
								<a  data-ng-click="searchsubmenu('4','people'); scope.isVisible = false;">
								  <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="search people" />
								  <span >people</span>
							  </a>
							</li>-->
						</ul>
						<input style="visibility: visible;"	type="hidden"	id="searchBy"	name="searchBy"	value=""	data-ng-model="search.searchBy">
						<input style="visibility: visible;"	type="hidden"	id="compId"	name="compId"	value=""	data-ng-model="search.compId">
				</form>
			</div>
		</div>
	</header>
