<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<script>
function approveReview(rid) {
	alert(rid);
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


<display:table name="${reviews}" id="row">
  <display:column property="rid" title="RID" />
  <display:column property="review" title="Text"  />
  <display:column title="Approve">  <input type="button" value="Approve"  onclick="approveReview('${pageScope.row.rid}')" name="Approve"></display:column>
  <display:column title="Reject">
  <input type="button" value="Reject" name="Reject" onclick="rejectReview('${pageScope.row.rid}')"></display:column>
</display:table>
