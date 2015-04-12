<!--########### School REVIEW WEDGIT STARTS HERE ###########-->


	<div class="story-wrap z2new">
		<div class="row">
			<div class="text-left notifyRow">
				School News
				<div>
				<ul>
						<c:forEach items="${news}" var="newsContent">
						<li>
						<a href="/${newsContent.alias}" target="_blank">
							${newsContent.title }</a></li>
					</c:forEach>
					<ul>
				</div>


			</div>
		</div>
