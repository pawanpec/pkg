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
function submitForm(formName)
{
  document.forms[formName].submit() ;
}
function onSelect()
{
  alert(this.id);
  alert(this.value);
}
</script>
<script type="text/javascript">
            window.onload = function () {
                var oTextbox = new AutoSuggestControl(document.getElementById("schoolSearchBox"), new StateSuggestions());        
            }
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
					src="<%=WebConstants.IMAGE_URL%>images/logo.png"
					alt="Schoolspedia"></a>
			</h1>
		</div>
		<nav class="main-mnu" id="navbar-collapse1">
			<ul class="nav navbar-nav">
				<li class="active home"><i class="top"></i><a href="/"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>home</span></a><i
					class="bot"></i></li>
				<li class="discover"><i class="top"></i><a href="<%=contextPath%>/searchSchool.html"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>Search
							School</span></a><i class="bot"></i></li>
				<li class="jobs"><i class="top"></i><a href="<%=contextPath%>/contentType.html?type=nursery_admission"><img
						src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" /><span>Nursery Admission</span></a><i class="bot"></i></li>
				<li class="interview"><i class="top"></i><a href="<%=contextPath%>/contentType.html?type=summer_camp"><img
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
			<form class="search-input col-xs-9 visible-sm visible-md visible-lg" name="searchSchool" method="post"
			 autocomplete="off" action="/spedia/search.html">
            <select name=slist id="stateList" style="float:right">
						<option value="Delhi">Delhi</option>
						<option value="Goa">Goa</option>
				</select>
				<div class="input-group ng-hide" style="width: 200px; display: inline-flex; float:right">
					  	<p><input type="text" id="schoolSearchBox"/></p>
						<img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" onclick="submitForm('searchSchool')"
						class="cus-icon cus-homesearch" />
					</span>
				</div>
				
			    <input
					style="visibility: visible;" type="hidden" id="nid"
					name="nid" value="">
			</form>
		</div>
	</div>
</header>
