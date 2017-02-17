<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<head>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Geocoding service</title>    
  <script defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB6CaUv5C6-tT2QBEdgJLt2bpAR18ZAbf4&callback=initMap"
	type="text/javascript"></script>
	  <body>
<script>    
        var geocoder;
        var map;        
        function codeAddress() {
            geocoder = new google.maps.Geocoder();
            var address = document.getElementById('address').value;
            geocoder.geocode({ 'address': address }, function (results, status) {
                if (status == google.maps.GeocoderStatus.OK) {                       

                    for (var component in results[0]['address_components']) {
                        for (var i in results[0]['address_components'][component]['types']) {
                            if (results[0]['address_components'][component]['types'][i] == "administrative_area_level_1") {
                                state = results[0]['address_components'][component]['long_name'];
                                alert(results[0]['address_components'][1]['long_name'] + ' , '  + state);
                            }
                        }
                    }                                           
                } else {
                    alert('Invalid Zipcode');
                }
            });
        }         

    </script>
  </head>

    <div id="panel">
      <input id="address" type="text" value="Sydney, NSW">
      <input type="button" value="Geocode" onclick="codeAddress()">
    </div>
    <div id="map-canvas"></div>
  </body>
</html>
