<%@ include file="/WEB-INF/pages/include.jsp"%>
<title>${content.title}</title>
<meta name="keywords" content="${content.title}" />
<!--######## Main Container Start Here ###########-->
<div class="container">
<ol class="breadcrumb">
					  <li><a href="/"><img src="<%=WebConstants.IMAGE_URL%>images/spacer.gif" class="cus-icon cus-home-small" alt="home" /></a></li>
					  <li><a href="/spedia/contentType.html?type=${content.type}">${fn:replace(content.type,'_',' ')}</a></li>
					  <li class="active"><a href="${group.alias}" >${group.title}</a></li>
				</ol>
</div>
<div class="container">
  <div class="left_coloum">
    <div class="details_grid">
    <div class="details_image">
    <c:if test="${not empty content.imageName}">
   	 <img id="contentImage" alt="content.imageName" src="${content.imageName}">
    </c:if>
    <c:if test="${ empty content.imageName}">
   		 <img id="contentImage" alt="content.imageName" src="">
   	 	 <c:if test="${content.type eq 'summer_camp'}">
		    <script type="text/javascript">
		    document.getElementById("contentImage").src='/spedia/images/summer_camp/'+random[0]+'.jpg';
		    </script>
		    </c:if>
		   <c:if test="${fn:contains(content.type, 'nursery_admission')}">
		    <script type="text/javascript">
		    	document.getElementById("contentImage").src='/spedia/images/nursery_admission/'+random[0]+'.jpg';
		    </script>
		    </c:if>
    </c:if>
    
    </div>
    <div class="title">${content.title}
    <div class="date_tag">25 July 2015</div>
    </div>
    <!-- <div class="detail_tag"><a href="javascript:void(0)">Lorem Ipsum is simply</a><a href="javascript:void(0)">Lorem Ipsum is simply</a><a href="javascript:void(0)">Lorem Ipsum is simply</a><a href="javascript:void(0)">Lorem Ipsum is simply</a></div> -->
    <div class="detail_content">
${content.body.value}    
    </div>
    
    
    
    </div>
    
   <!--  <div class="fb-comments" data-href="http://developers.facebook.com/docs/plugins/comments/" data-numposts="5" data-colorscheme="light"></div> -->
    
  </div>
  <div class="right_coloum">
    <div class="news_subscribe">
      <div class="news_text">Subscribe for news leatter</div>
      <div class="news_fields">
        <input type="text" placeholder="Enter your email address" />
        <input type="submit" value="SUBSCRIBE" />
      </div>
    </div>
   <%@include file="../recentNews.jsp"%>
   <%@include file="../amazon_336_280.jsp"%>
   <%@include file="../adsense_336_280.jsp"%>
  </div>
</div>


	