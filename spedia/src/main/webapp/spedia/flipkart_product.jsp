<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src="http://coenraets.org/tutorials/mustache/js/mustache.js"></script>
<style>
.gd-row:after {
    clear: both;
    content: ".";
    display: block;
    height: 0;
    visibility: hidden;
    width: 640px;
}
.gd-col {
    float: left;
    padding-left: 14px;
    position: relative;
    width: 200px;
} 
</style>
<script>

function jsonpCallbackTest(jsonp) {
    alert("success");
}
$.ajax({
// the URL for the request
url: "http://176.58.123.155:8080/Affiliate/flipkart/getProductDetails",
// the data to send (will be converted to a query string)
crossDomain: true,
data: {
category:'mobiles',
},
// whether this is a POST or GET request
type: "GET",
dataType: "json",
//jsonpCallback: "jsonpCallbackTest",
// code to run if the request succeeds;
// the response is passed to the function
success: function( json ) {
        var template = $('#productTpl').html();
        var html="";
        for(i=0;i<47;i++){
        		 var a=Math.floor((Math.random() * json['productInfoList'].length)); 
                 html = html+Mustache.to_html(template, json['productInfoList'][a]);
        }
        $('#productArea').html(html);
},
// code to run if the request fails; the raw request and
// status codes are passed to the function
error: function( xhr, status, errorThrown ) {
console.log( "Sorry, there was a problem!"+errorThrown+ status);
console.log( "Error: " + errorThrown );
console.log( "Status: " + status );

console.dir( xhr );
},
// code to run regardless of success or failure
complete: function( xhr, status ) {
//alert( "The request is complete!" );
}
});
</script>
<div id="productArea" class="gd-row"></div>
<script id="productTpl" type="text/template">
<div class="gd-col">
	<div class="prod-img text-center">
		<a target="_blank"
			href="{{productBaseInfo.productAttributes.productUrl}}">
			<img
			src="{{productBaseInfo.productAttributes.imageUrls.75x75}}">
		</a>
	</div>
	<div class="prod-info">
		<a target="_blank"
			href="{{productBaseInfo.productAttributes.productUrl}}"
			class="prod-title" title="{{productBaseInfo.productAttributes.title}}">{{productBaseInfo.productAttributes.title}}</a>

		<p class="list-price">List Price Rs.{{productBaseInfo.productAttributes.maximumRetailPrice.amount}}</p>

		<p class="price">
		Our Price <strong>Rs.{{productBaseInfo.productAttributes.sellingPrice.amount}}</strong>
		</p>
	</div>
	<a target="_blank"
		href="{{productBaseInfo.productAttributes.productUrl}}"
		class="fclear buy-now orange">Buy Now</a>
</div>
</script>