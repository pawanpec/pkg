<%@ include file="include.jsp"%>

<script type="text/javascript">
function registerUser(data) {
	 var queryString="?data="+data+"&socialType=fb";
	 var aurl="/spedia/registerUser.html"+queryString;
	  $.ajax({url: aurl, success: function(result){
		  console.log("after login "+result);
		  if(result=="1"){
			//  window.location = "http://dev.timesjobs.com/spedia/userHome.html";
		  }
		 
     }});
}
</script>
<div id="fb-root"></div>
<script>
	window.fbAsyncInit = function() {
		FB.init({
			appId : '888488191171642', // Set YOUR APP ID
			// channelUrl : 'http://hayageek.com/examples/oauth/facebook/oauth-javascript/channel.html', // Channel File
			status : true, // check login status
			cookie : true, // enable cookies to allow the server to access the session
			xfbml : true
		// parse XFBML
		});

		FB.Event
				.subscribe(
						'auth.authResponseChange',
						function(response) {
							if (response.status === 'connected') {
								//SUCCESS
								getUserInfo();

							} else if (response.status === 'not_authorized') {
								document.getElementById("status").innerHTML += "<br>Connected to Facebook";

								//FAILED
							} else {
								document.getElementById("status").innerHTML += "<br>Logged Out";

								//UNKNOWN ERROR
							}
						});

	};

	function Login() {

		FB.login(
						function(response) {
							if (response.authResponse) {
								getUserInfo();
							} else {
								console
										.log('User cancelled login or did not fully authorize.');
							}
						}, {
							scope : 'email,read_friendlists'
						});

	}

	function getUserInfo(status) {
		FB.api('/me', function(response) {
			console.log(JSON.stringify(response));
			registerUser(JSON.stringify(response));
			var str='Hi, ' + response.name + '!';
			str += "<input type='button' value='Logout' onclick='Logout();'/>";
			document.getElementById("status").innerHTML = str;

		});
	}
	function Logout() {
		FB.logout(function() {
			document.location.reload();
		});
	}
	// Load the SDK asynchronously
	(function(d) {
		var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement('script');
		js.id = id;
		js.async = true;
		js.src = "//connect.facebook.net/en_US/all.js";
		ref.parentNode.insertBefore(js, ref);
	}(document));
</script>
<div class="navbar navbar-inverse hidden-xs topheader">
	<div class="container-fluid">
		<!--Top Navigation-->
		<div class="row">
			<div class="navbar-header">
				<button data-target=".navbar-collapse" data-toggle="collapse"
					class="navbar-toggle" type="button">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
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
			<button type="button" class="navbar-toggle mobilemnubtn"
				id="navbar-toggle" data-target="#navbar-collapse1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<h1 class="logo">
				<a href="/"><img
					src="<%=WebConstants.IMAGE_URL%>images/jobuzz_logo.png"
					alt="JobBuzz"></a>
			</h1>
		</div>
		<nav class="main-mnu" id="navbar-collapse1">
			<ul class="nav navbar-nav">
				<li class="active home"><i class="top"></i><a href="/"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>home</span></a><i
					class="bot"></i></li>
				<li class="discover"><i class="top"></i><a href="/discover/"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>Search
							School</span></a><i class="bot"></i></li>
				<li class="jobs"><i class="top"></i><a href="/jobs/all/"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>School
							Jobs</span></a><i class="bot"></i></li>
				<li class="interview"><i class="top"></i><a href="/interview/"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>Summer
							Camp</span></a><i class="bot"></i></li>
				<li class="logosm visible-xs"><a href="/"><img
						src="<%=WebConstants.IMAGE_URL%>images/jobuzz_logo.png"
						alt="JobBuzz"></a></li>
			</ul>
			<div class="clearfix visible-sm"></div>
		</nav>
		<div class="navbar-right right-mnu position">
			<div id="status">
				<img
					src="<%=WebConstants.IMAGE_URL%>images/flogin.jpg" alt="FB Login"
					style="cursor:pointer;" onclick="Login()" />
			</div>
			<form class="search-input col-xs-9 visible-sm visible-md visible-lg"
				data-ng-init="scope = {isVisible: false, class:'', autocomplete:2}"
				action="/jobbuzz/search.html" id="searchForm"
				data-ng-class="isMobileSearch ? 'visible-xs' : 'f'" method="post"
				data-ng-click="$event.stopPropagation();" autocomplete="off">
				<div class="input-group ng-hide"
					data-ng-show="search.searchBy==3 || search.searchBy==-1">
					<input type="text" id="jobsSearchText" name="jobsSearchText"
						data-ng-model="search.jobsSearchText" maxlength="100"
						placeholder="E.g. Java Developer 3-5 years Pune"
						typeahead-on-select='onSelect($item, $model, $label)'
						data-ng-pattern="/^[a-zA-Z0-9]/"
						typeahead="suggestion for suggestion in loadJobs($viewValue) | limitTo:5"
						typeahead-min-length="3" class="form-control"
						data-ng-keyup="$event.keyCode == 13 || $event.keyCode == 186 ? headerSearchSubmitJob(search.jobsSearchText) : null"
						aria-describedby="basic-job" /> <span
						class="input-group-addon mobileserbtn mobileserbtnw"
						data-ng-show="isMobileSearch"
						data-ng-click="headerSearchSubmitJob(search.jobsSearchText)">
						<img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
						class="cus-icon cus-homesearch" />
					</span>
				</div>
				<input style="visibility: visible;" type="hidden" id="searchBy"
					name="searchBy" value="" data-ng-model="search.searchBy"> <input
					style="visibility: visible;" type="hidden" id="compId"
					name="compId" value="" data-ng-model="search.compId">
			</form>
		</div>
	</div>
</header>
