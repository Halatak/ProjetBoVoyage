<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<title>Test Carte</title>

<style>
#map-canvas {
	height: 600px;
	height: 600px;
	margin: 0px;
	padding: 0px
}
</style>

 
</head>

<body>
coucou

<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?"></script>

    <script type="text/javascript">
        var markerLat, markerLong;
        markerLat = [
            <c:forEach var="s" items="${listGeo}">
                <c:out value="${s.latitude}"/>,
            </c:forEach>
        ];
        markerLong = [
          <c:forEach var="s" items="${listGeo}">
              <c:out value="${s.longitude}"/>,
          </c:forEach>
        ];

        function initialize() {
            var map;
            var initlatlng = new google.maps.LatLng(markerLat[0],markerLong[0]);
            var mapOptions = {
                zoom: 6,
                center: new google.maps.LatLng(36,5),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
            var infowindow = new google.maps.InfoWindow(); 
            var marker, i;

            for (i = 0; i < markerLat.length; i++) {
                marker = new google.maps.Marker({
                    position: new google.maps.LatLng(markerLat[i], markerLong[i]),
                    map: map
                });

                google.maps.event.addListener(marker, 'click', (function(marker, i) {
                    return function() {
                        infowindow.setContent(markers[i]);
                        infowindow.open(map, marker);
                    }
                })(marker, i));
            }
        }

        google.maps.event.addDomListener(window, 'load', initialize);
    </script>

</body>
</html>