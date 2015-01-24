<!--########### Company Details with logo Start Here ###########-->
<div class="col-sm-6 item" data-ng-if="companyPhotoVideos.length > 0">
<div class="clearfix card-heading">
				<ul class="commands-btn">
					<li><a data-original-title="Help" href="javascript:void(0)"
						class="tooltipShow" data-toggle="tooltip" data-placement="top"
						title=""> <img
							src="<%=WebConstants.IMAGE_URL%>images/spacer.gif"
							class="cus-icon cus-help" alt="help">
					</a></li>
				</ul>
			</div>
	<div class="story-wrap z2new ng-scope">
		<div class="row text-left">
			<h3 class="notopmargin">VIDEOS &amp; PHOTOS <span class="error hidden-xs">({{companyvideos.length}})</span></h3>
			<div class="col-sm-6">
				<div class="row"> 
					<div class="cmpwho thumbnail">
						<div class="tablerow">
						<div data-ng-if="firstvideo.mediaType===0" class="thumb">
							<img src="<%=WebConstants.PHOTOS_URL %>{{firstvideo.mediaUrl}}" alt="f" />
						</div>
						<div data-ng-if="firstvideo.mediaType===1" class="thumb">
							<object type="application/x-shockwave-flash" data="https://www.youtube.com/v/{{getVideoID(firstvideo.mediaUrl)}}" 
								id="singlePlayer_overview" style="width:100%; height:100%;">
								<param name="allowfullscreen" value="true">
								<param name="wmode" value="transparent">
							</object>
						</div>
						</div>
					</div>
					<div class="notifyRow font12 ellipsetext"><em data-ng-bind="firstvideo.mediaText | cut:true:90:'...'"></em></div>
					<div class="row notifyRow font12 socialvideo">
						<div class="col-xs-5">
							<a href="javascript:void(0)" data-ng-if="pagecount!==0" data-ng-click="pagination(0)">&lt;</a>&nbsp;{{firstIndex}} - {{currIndex}} of {{companyvideos.length}} <a href="javascript:void(0)" data-ng-click="pagination(1)"  data-ng-if="currIndex <= (companyvideos.length-1)">&gt;</a>
						</div>
						<div class="col-xs-7 clearfix text-right sharev">
							<div class="sharev">
							<!-- 	Go to www.addthis.com/dashboard to generate a new set of sharing buttons -->
								<a
									href="https://api.addthis.com/oexchange/0.8/forward/twitter/offer?url=http%3A%2F%2Fwww.addthis.com&amp;pubid=ra-547423be70cb0a7f&amp;ct=1&amp;title=AddThis%20-%20Get%20likes%2C%20get%20shares%2C%20get%20followers&amp;pco=tbxnj-1.0"
									target="_blank"><img
									src="https://cache.addthiscdn.com/icons/v2/thumbs/32x32/twitter.png"
									border="0" alt="Twitter"></a> <a
									href="https://api.addthis.com/oexchange/0.8/forward/facebook/offer?url=http%3A%2F%2Fwww.addthis.com&amp;pubid=ra-547423be70cb0a7f&amp;ct=1&amp;title=AddThis%20-%20Get%20likes%2C%20get%20shares%2C%20get%20followers&amp;pco=tbxnj-1.0"
									target="_blank"><img
									src="https://cache.addthiscdn.com/icons/v2/thumbs/32x32/facebook.png"
									border="0" alt="Facebook"></a> <a
									href="https://api.addthis.com/oexchange/0.8/forward/linkedin/offer?url=http%3A%2F%2Fwww.addthis.com&amp;pubid=ra-547423be70cb0a7f&amp;ct=1&amp;title=AddThis%20-%20Get%20likes%2C%20get%20shares%2C%20get%20followers&amp;pco=tbxnj-1.0"
									target="_blank"><img
									src="https://cache.addthiscdn.com/icons/v2/thumbs/32x32/linkedin.png"
									border="0" alt="LinkedIn"></a> <a
									href="https://api.addthis.com/oexchange/0.8/forward/pinterest/offer?url=http%3A%2F%2Fwww.addthis.com&amp;pubid=ra-547423be70cb0a7f&amp;ct=1&amp;title=AddThis%20-%20Get%20likes%2C%20get%20shares%2C%20get%20followers&amp;pco=tbxnj-1.0"
									target="_blank"><img
									src="https://cache.addthiscdn.com/icons/v2/thumbs/32x32/pinterest.png"
									border="0" alt="Pinterest"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6 text-right">
				<div class="row">
					<div class="col-xs-6 font12 text-left hidden-xs">{{firstIndex}} - {{currIndex}} of {{companyvideos.length}}</div>
					<div class="col-xs-6 text-right hidden-xs">
						<a href="javascript:void(0)" data-ng-if="pagecount!==0" data-ng-click="pagination(0)" class="font18">&lt;</a>&nbsp;<a href="javascript:void(0)" data-ng-click="pagination(1)"  data-ng-if="currIndex <= (companyvideos.length-1)" class="font18">&gt;</a>
					</div>
					<div class="col-xs-12 videolist">
						<div class="row">
						<div class="col-xs-4 border m_b10" data-ng-repeat="gallery in companyvideos" data-ng-show="$index <= (pagecount*9 +8) && $index >= (pagecount*9 + 0)">
							<div class="thumbnail" data-ng-if="gallery.mediaType===0" data-ng-click="setLarge(gallery)">
								<img data-ng-src="<%=WebConstants.PHOTOS_URL %>{{gallery.mediaUrl}}" alt="" class="imgfullwidth" />
							</div>
							<div class="row thumbnail" data-ng-if="gallery.mediaType===1" data-ng-click="setLarge(gallery)">
								<img data-ng-src="http://img.youtube.com/vi/{{getVideoID(gallery.mediaUrl)}}/0.jpg" data-url="{{getVideoID(gallery.mediaUrl)}}" class="imgfullwidth" alt="Company Video" />
							</div>
						</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<!--########### Company Details with logo Container Ends Here ###########-->
