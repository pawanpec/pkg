<%@ include file="include.jsp"%>

<script type="text/javascript">
function submitForm(formName)
{
 var value= document.getElementById("schoolSearchBox").value;
 var nid= document.getElementById("nid").value;
  document.forms[formName].submit() ;
}
</script>
<script type="text/javascript">
            window.onload = function () {
                var oTextbox = new AutoSuggestControl(document.getElementById("schoolSearchBox"),document.getElementById("nid"), new StateSuggestions());        
            }
</script>
<script>
$(document).ready(function(){
  $('.bxslider').bxSlider({
	  auto:true
	  });
	  
	  
	  $(".selector").click(function(){
		  $(".down_data").toggle();		  
	  });
	  
	  
	$(".down_data li").click(function(){
  	var input_val = $(this).find("span").html() 
    $("#schoolSearchBox").attr('placeholder','Search school in '+input_val);
	$(".down_data").hide();	

 
	  });
	  
	  
  





});
</script>
<div class="top_header">
    <div class="container">
        <div class="social_icons">
            <ul>
            <li class="facebook"><a href=""><i class="fa fa-facebook"></i></a></li>
            <li class="twitter"><a href=""><i class="fa fa-twitter"></i></a></li>
            <li class="google"><a href=""><i class="fa fa-google"></i></a></li>
            <li class="linkdin"><a href=""><i class="fa fa-linkedin"></i></a></li>
            <li class="email"><a href=""><i class="fa fa-envelope"></i></a></li>
            <li class="chat"><a href=""><i class="fa fa-weixin"></i></a></li>
            <c:if test="${not pageContext.request.userPrincipal.authenticated}">
            <li class="facebook_login"><a href="javascript:void(0)" onclick="Login()"><img src="<%=WebConstants.IMAGE_URL%>images/facebook_login.png"  /></a></li>
            </c:if>
            <li style="display:none;"><c:if test="${pageContext.request.userPrincipal.authenticated}">
                                Hi,${username }
                                <input type='button' value='Logout' onclick='Logout();'/>
                            </c:if></li>
            </ul>
        </div>
    </div>
</div>




<header id="fixedNavigation" class="clearfix">
	<div class="clearfix z2new" id="fixed">
    <div class="container">
		<div class="xs-headerl">
			<button type="button" class="navbar-toggle mobilemnubtn"
				id="navbar-toggle" data-target="#navbar-collapse1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="logo">
				<a href="/"><img
					src="<%=WebConstants.IMAGE_URL%>images/logo.png"
					alt="Schoolspedia"></a>
			</div>
		</div>
		<nav class="main-mnu" id="navbar-collapse1">
			<ul class="nav navbar-nav">
				<li class="home"><i class="top"></i><a href="/"><img
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
        
        
        
        
        
        <div class="new_form_header">
        <div class="down_data">
        <ul>
        <li><i class="fa fa-area-chart"></i> <span>Delhi</span></li>
        <li><i class="fa fa-area-chart"></i> <span>Goa</span></li>
        </ul>
        </div>
        <div class="selector"><i class="fa fa-ship"></i></div>
        <form name="searchSchool" method="post"
			 autocomplete="off" action="/spedia/search.html">
        <input type="text" placeholder="Search schools" id="schoolSearchBox" />
        <input type="hidden" id="nid" name="nid" value="">
        </form>
        </div>
        
        
        
		<div class="navbar-right right-mnu position" style="display:none;">
			<div id="status">
				<c:if test="${not pageContext.request.userPrincipal.authenticated}">
					<img
						src="<%=WebConstants.IMAGE_URL%>images/flogin.jpg" alt="FB Login"
						style="cursor:pointer;" onclick="Login()" />
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.authenticated}">
					Hi,${username }
					<input type='button' value='Logout' onclick='Logout();'/>
				</c:if>
			</div>
			<form class="search-input col-xs-9 visible-sm visible-md visible-lg" name="searchSchool" method="post"
			 autocomplete="off" action="/spedia/search.html">
            <select name=slist id="stateList" style="float:right">
						<option value="Delhi">Delhi</option>
						<option value="Goa">Goa</option>
				</select>
				<div class="input-group ng-hide" style="width: 200px; display: inline-flex; float:right">
					  	<p><input type="text" id="schoolSearchBox" onselect="submitForm('searchSchool')"/></p>
					  		    
				</div>
				
		
			</form>
		</div>
	</div></div>
</header>
<div class="gap_40"></div>