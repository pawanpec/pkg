	<div class="normal_listing" itemscope=""
			itemtype="http://schema.org/LocalBusiness">
			<div class="row rowpdng">
				<div class="col-lg-2 hidden-xs" style="padding:0;">
					<a
						href="${newsContent.alias }"><img
						src="images/static/1.jpg" alt="${newsContent.title }"
						title="${newsContent.title }" width="108" height="60"
						class="img-border"> </a>
				</div>
				<div class="innerdiv">
					<h1>
						<a itemprop="url" class="biznme_txt"
							title="${newsContent.title }" id="${newsContent.nid }"
							href="${newsContent.alias }"><span
							style="color:#3273da;right:0px;top:0px;" itemprop="name">${newsContent.title }</span> </a>
					</h1>
				</div>
					<div class="row" style="border-top:1px solid #e3e3e3;">
						<div class="col-lg-2" style="padding:0;">
							<img class="rating"
								src="images/star5.png"
								title="Poor">
						</div>
						<div class="col-lg-4" style="padding:0;">
							<ol>
							<c:if test="${newsContent.f.size>0}">
								<li class=""><a rel="nofollow"
									href="javascript:openAjaxPopup('favourite/getfavusers/53251/business/1')"
									title="Follow ${newsContent.title }"
									class="link1">${newsContent.f.size} Follow </a></li>
							 </c:if>
								<li class="last"><a
									href="${newsContent.alias }/review-rating"
									title="Read reviews of ${newsContent.title }" class="link1">${newsContent.review.count }
										Review </a></li>
							</ol>
						</div>
						
						<!-- <div class="col-lg-2" data-id="comparePopup"
							title="Compare KGT International School with other similar businesses ">
							<a href=""
								onclick="compareListingsData('282','53251');return false;"><input
								type="button" name="" value="Compare" class="Afc_button"></a>
						</div> -->
					</div>
				
			</div>
		</div>