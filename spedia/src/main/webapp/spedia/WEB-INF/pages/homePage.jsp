<%@ include file="include.jsp" %>
<title>Nursery Admission Update,Summer Camps,Search Schools |Schoolspedia</title>
<div class="container">
  <div class="sliders_row">
    <div class="banner">
      <ul class="bxslider">
        <li><img src="images/im1.jpg" /></li>
        <li><img src="images/im2.jpg" /></li>
      </ul>
    </div>
    <div class="banner_right">
      <div class="news_subscribe">
        <h4>Recent News</h4>
      </div>
 		<%@include file="recentNews.jsp"%>
   </div>
  </div>
</div>
  <%@include file="sp_theme.jsp"%>
<div class="container"> 
  <%@include file="featuredSchool.jsp"%>
</div>

















<div class="clearfix"></div>
<div class="homepage">
	<!--******* Feature Screen *************-->
	

	
	<%@include file="whySp.jsp" %>
    <div class="what-parents">    
     <div class="container">   
        <div class="row hidden-xs">
            <div class="margincenter col-sm-10 text-center">
                <h2 class="robotolight">
                    WHAT Parents ARE <strong>SAYING</strong> ABOUT US
                </h2>
            </div>
        </div>
          <%@include file="testimony.jsp" %> 
         
        <div class="row fearturelist"></div>
    </div>
    </div>
</div>
