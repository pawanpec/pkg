	window.fbAsyncInit = function() {
		FB.init({
			appId : '191358334217968', // Set YOUR APP ID
			// channelUrl : 'http://hayageek.com/examples/oauth/facebook/oauth-javascript/channel.html', // Channel File
			status : true, // check login status
			cookie : true, // enable cookies to allow the server to access the session
			xfbml : true
		// parse XFBML
		});

		FB.Event
				.subscribe(
						'auth.authResponseChange',
						function(response) {
							if (response.status === 'connected') {
								//SUCCESS
								if(!isLogin){
									getUserInfo();
								}
							} else if (response.status === 'not_authorized') {
								document.getElementById("status").innerHTML += "<br>Connected to Facebook";

								//FAILED
							} else {
								document.getElementById("status").innerHTML += "<br>Logged Out";

								//UNKNOWN ERROR
							}
						});

	};

	function Login() {
		FB.login(
						function(response) {
							if (response.authResponse) {
								getUserInfo();
							} else {
								console
										.log('User cancelled login or did not fully authorize.');
							}
						}, {
							scope : 'email,read_friendlists'
						});

	}

	function getUserInfo(status) {
		FB.api('/me', function(response) {
			console.log(JSON.stringify(response));
			registerUser(JSON.stringify(response));
			var str='Hi, ' + response.name + '!';
			str += "<input type='button' value='Logout' onclick='Logout();'/>";
			document.getElementById("status").innerHTML = str;

		});
	}
	function Logout() {
		FB.logout(function() {
			logoutFROMSP();
			document.location.reload();
		});
	}
	(function(d) {
		var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
		if (d.getElementById(id)) {
			return;
		}
		js = d.createElement('script');
		js.id = id;
		js.async = true;
		js.src = "//connect.facebook.net/en_US/all.js";
		ref.parentNode.insertBefore(js, ref);
	}(document));
