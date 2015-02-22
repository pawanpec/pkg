<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
function approveReview(rid) {
	 var queryString="?rid="+rid;
	 var followUrl="/spedia/approveReview.html"+queryString;
	  $.ajax({url: followUrl, success: function(result){
		  alert(result);
		  if(result=="1"){
			  //change the value of follow button to following.
			 // $("#follow").html("following");
		  }
         
      }});
}
function rejectReview(rid) {
	 var queryString="?rid="+rid;
	 var followUrl="/spedia/rejectReview.html"+queryString;
	  $.ajax({url: followUrl, success: function(result){
		  if(result=="1"){
			  //change the value of follow button to following.
			 // $("#follow").html("following");
		  }
        
     }});
}
</script>
All Reviews


<c:forEach items="${reviews}" var="review">
RID	${review.rid}
</c:forEach>

<table name="review">
	<c:forEach items="${reviews}" var="review">
		<tr>
			<th>RID</th>
			<td>${review.rid}</td>
			<th>RTEXT</th>
			<td>${review.review}</td>
			<th>RSTATUS</th>

			<td><input type="button" value="Approve"  onclick="approveReview('${review.rid}')" name="Approve">
				<input type="button" value="Reject" name="Reject" onclick="rejectReview('${review.rid}')"> </td>
		</tr>
	</c:forEach>
</table>
