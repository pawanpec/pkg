<script>
function initialize() {
  var mapOptions = {
     center: { lat: ${content.location.latitude}, lng: ${content.location.longitude}},
          zoom: 8
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
}

function loadScript() {
  var script = document.createElement('script');
  script.type = 'text/javascript';
  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp' +
      '&signed_in=true&callback=initialize&key=AIzaSyDDDnST4FfwAhVEcG7pGY-G7oQWD_JnxYc';
  document.body.appendChild(script);
}

window.onload = loadScript;

    </script>
 <div id="map-canvas" class="cmpwho z2new story-wrap account-card interview-card">
 </div>