	<div class="clearfix counter-detail">
		<h5>
			<img src="<%=WebConstants.IMAGE_URL %>images/loved.png" class="amazing" /> 
				<!-- <span class="counter"> 
				<span data-val="5"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
				<span data-val="3"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
				<span data-val="4"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
				<span data-val="8"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
				<span data-val="1"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
				<span data-val="2"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
				<span data-val="6"><b><i>0</i><i>1</i><i>2</i><i>3</i><i>4</i><i>5</i><i>6</i><i>7</i><i>8</i><i>9</i></b></span>
			</span> -->
			<span data-ng-bind="jbCounts.userCount"></span>
			<img src="<%=WebConstants.IMAGE_URL %>images/amazing.png" class="amazing" />
		</h5>
	</div>
	<div class="container-fluid footer-info hidden-xs">
		<div class="col-sm-5ths">
			<div class="footer-desc">
				<strong><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="discover" /></strong> 
				<strong data-ng-bind="jbCounts.companyCount"></strong>
				<p>great companies to discover best</p>
			</div>
		</div>
		<div class="col-sm-5ths">
			<div class="footer-desc">
				<strong><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="job" /></strong> 
				<strong data-ng-bind="jbCounts.interviewQuestionCount"></strong>
				<p>awesome questions to prepare better</p>
			</div>
		</div>
		<div class="col-sm-5ths">
			<div class="footer-desc">
				<strong><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="interview" /></strong>
				<strong data-ng-bind="jbCounts.interviewAnswerCount"></strong>
				<p>cool answers to take wise decisions</p>
			</div>
		</div>
		<div class="col-sm-5ths">
			<div class="footer-desc">
				<strong><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="review" /></strong> 
				<strong data-ng-bind="jbCounts.reviewCount"></strong>
				<p>company reviews to stay informed</p>
			</div>
		</div>
		<div class="col-sm-5ths">
			<div class="footer-desc">
				<strong><img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" class="salary" /></strong> 
				<strong data-ng-bind="jbCounts.jobCount"></strong>
				<p>jobs from top companies</p>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="groupcmp">
			<div class="row">
				<ul class="nav nav-pills navbar-left">
					<li><a href="/discover/">discover</a></li>
					<li><a href="/jobs/all/">jobs</a></li>
					<li><a href="/interview/">interviews</a></li>
				</ul>
				<ul class="nav nav-pills navbar-right">
					<li><a href="/jobbuzz/jobuzz_faq.html" target="_blank">faq</a></li>
					<li><a href="/jobbuzz/termsofuse.html" target="_blank">terms of use</a></li>
					<li><a href="/jobbuzz/privacypolicy.html" target="_blank">privacy policy</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container-fluid hidden-xs">
		<div class="groupcmp">
			<h6>TBS Network</h6>
		</div>
	</div>
	<div class="container-fluid hidden-xs">
		<ul class="groupcmp">
			<li class="timejob"><a target="_blank"
				href="http://www.timesjobs.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="techgig"><a target="_blank"
				href="http://www.techgig.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="magicb"><a target="_blank"
				href="http://www.magicbricks.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="simplym"><a target="_blank"
				href="http://www.simplymarry.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="ad2book"><a target="_blank"
				href="http://www.ads2book.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="jobbuzz"><a target="_blank"
				href="http://jobbuzz.timesjobs.com/"> <img
					src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="dialb"><a target="_blank"
				href="http://bpo.timesjobs.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="tcnext"><a target="_blank"
				href="http://www.tcnext.com/"> <img src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
			<li class="stepahead"><a target="_blank"
				href="http://stepahead.timesjobs.com/"> <img
					src="<%=WebConstants.IMAGE_URL %>images/spacer.gif" /></a></li>
		</ul>
	</div>
	<div class="container-fluid">
		<div class="text-center size10">Copyright &copy; Times Business Solutions (a Division of Times Internet Ltd.) 2015. Indiatimes Classified Network.</div>
	</div>

<%-- 	
<!-- ###### Login Popup code ############-->  
	<div class="modal fade loginCtrl" id="myModallogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" inputcontrol>
	  
	  <%@ include file="login.jsp" %>
	  </div>
	</div> 
<!-- ###### Login Popup code ############ -->

<!-- ###### SignUp Popup code ############ -->
<div class="modal fade signUpctrl" id="myModalSignup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	  <%@ include file="jobbuzzRegistrationPage.jsp" %>	
	  </div>
</div> 
<!-- ###### SignUp Popup code ############ -->


<!-- ###### Forget Password Popup code ############ -->
<div class="modal fade forgetctrl" id="myModalSignup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	  <%@ include file="forgetPassword.jsp" %>
		
	  </div>
</div> 
<!-- ###### Forget Password Popup code ############ -->

<!-- ###### Change Password Popup code ############ -->
<div class="modal fade changectrl" id="myModalSignup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	  <%@ include file="changePassword.jsp" %>
		
	  </div>
</div>  --%>
<!-- ###### Change Password Popup code ############ -->
<script type="text/javascript">
   var _mfq = _mfq || [];
   (function() {
       var mf = document.createElement("script"); mf.type = "text/javascript"; mf.async = true;
       mf.src = "//cdn.mouseflow.com/projects/12816a3d-af32-4006-b7da-cd9ec85130d7.js";
       document.getElementsByTagName("head")[0].appendChild(mf);
   })();
</script>
