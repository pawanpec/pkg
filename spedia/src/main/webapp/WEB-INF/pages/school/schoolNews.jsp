<c:forEach items="${news}" var="newsContent">						
      <div class="news_tick">
        <div class="image"></div>
        <div class="image_data">
          <div class="news_title"><a href="/${newsContent.alias}">${newsContent.title }</a></div>
        <%--   <div class="news_desc">${newsContent.body.summary}.</div> --%>
        </div>
      </div>
</c:forEach>      
