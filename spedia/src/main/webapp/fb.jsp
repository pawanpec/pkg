<html>
<%@ page import="com.spedia.utils.WebConstants"%>
<meta charset="UTF-8">
	<script src="<%=WebConstants.JS_URL %>js/jquery-1.10.2.min.js" type="text/javascript"></script> 
</head>
<script>
function saveFbGroupData(d) {
	// var queryString="?data="+d;
	 var aurl="/spedia/savefbgroupdata.html";
	 $.ajax({
		    url : aurl,
		    method : 'post',
		    data:'data='+escape(d),
		    success : function(data) {
		        console.log(data);

		    }
	 	   
	 		
		})
	
}
</script>
<body>
	<div id="fb-root"></div>
	<script>
$iLimit = 99;
$appId = '191358334217968';
  window.fbAsyncInit = function() {
    FB.init({
      appId      : $appId, // Set YOUR APP ID
     // channelUrl : 'http://hayageek.com/examples/oauth/facebook/oauth-javascript/channel.html', // Channel File
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });
 
    FB.Event.subscribe('auth.authResponseChange', function(response) 
    {
     if (response.status === 'connected') 
    {
        document.getElementById("message").innerHTML +=  "<br>Connected to Facebook";
        //SUCCESS
 
    }    
    else if (response.status === 'not_authorized') 
    {
        document.getElementById("message").innerHTML +=  "<br>Failed to Connect";
 
        //FAILED
    } else 
    {
        document.getElementById("message").innerHTML +=  "<br>Logged Out";
 
        //UNKNOWN ERROR
    }
    }); 
 
    };
            function sortMethod(a, b) {
    	            var x = a.name.toLowerCase();
    	            var y = b.name.toLowerCase();
    	            return ((x < y) ? -1 : ((x > y) ? 1 : 0));
            }
    function Login()
    {
 
        FB.login(function(response) {
           if (response.authResponse) 
           {
                getUserInfo();
                
            } else 
            {
             console.log('User cancelled login or did not fully authorize.');
            }
         },{scope: 'email,user_photos,user_friends'});
 
    }
 
  function getUserInfo() {
        FB.api('/me', function(response) {
 
      var str="<b>Name</b> : "+response.name+"<br>";
          str +="<b>Link: </b>"+response.link+"<br>";
          str +="<b>Username:</b> "+response.username+"<br>";
          str +="<b>id: </b>"+response.id+"<br>";
          str +="<b>Email:</b> "+response.email+"<br>";
          str +="<input type='button' value='Get Photo' onclick='getPhoto();'/>";
          str +="<input type='button' value='Get Friends' onclick='getFriends();'/>";
          str +="<input type='button' value='Logout' onclick='Logout();'/>";
          document.getElementById("status").innerHTML=str;
 
    });
        //getFriends();
        getGroupData();
    }
  function getGroupData() {
      FB.api('/1506585852913224/feed', function(response) {
         console.log("group data----"+JSON.stringify(response.data));
         saveFbGroupData(JSON.stringify(response.data));
      });
  }

    function getPhoto()
    {
      FB.api('/me/picture?type=normal', function(response) {
 
          var str="<br/><b>Pic</b> : <img src='"+response.data.url+"'/>";
          document.getElementById("status").innerHTML+=str;
 
    });
 
    }
    function Logout()
    {
        FB.logout(function(){document.location.reload();});
    }
    function getFriends()
    {
   
    // get friends
      FB.api('/me/friends', function(response) {
                            var result_holder = document.getElementById('result_friends');
    	                     var friend_data = response.data.sort(sortMethod);
    	 						console.log("friends data"+JSON.stringify(response));
    	                        var results = '';
    	                        for (var i = 0; i < friend_data.length; i++) {
    	                            results += '<div><img src="https://graph.facebook.com/' + friend_data[i].id + '/picture">' + friend_data[i].name + '</div>';
                            	}
     
                            // and display them at our holder element
    	                        result_holder.innerHTML = '<h2>Result list of your friends:</h2>' + results;
    	                    });
    }
 
  // Load the SDK asynchronously
  (function(d){
     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     ref.parentNode.insertBefore(js, ref);
   }(document));
 
</script>
	<div align="center">
		<h2>Facebook OAuth Javascript Demo</h2>

		<div id="status">
			Click on Below Image to start the demo: <br /> <img
				src="http://hayageek.com/examples/oauth/facebook/oauth-javascript/LoginWithFacebook.png"
				style="cursor:pointer;" onclick="Login()" />
		</div>

		<br /> <br /> <br /> <br /> <br />

		<div id="message">
			Logs:<br />
		</div>
		<div id="result_friends"></div>
	</div>
</body>
</html>