$(document).ready(function(){
	

var geocoder;
var map;
function codeAddress() {
	alert('Invalid Zipcode');
	geocoder = new google.maps.Geocoder();
	var address = document.getElementById('address').value;
	var id = document.getElementById('id').value;
	geocoder
			.geocode(
					{
						'address' : address
					},
					function(results, status) {
						if (status == google.maps.GeocoderStatus.OK) {

							for ( var component in results[0]['address_components']) {
								for ( var i in results[0]['address_components'][component]['types']) {
									if (results[0]['address_components'][component]['types'][i] == "administrative_area_level_1") {
										state = results[0]['address_components'][component]['long_name'];
										/*
										 * alert(results[0]['address_components'][2]['long_name'] + ' , ' +
										 * state);
										 */
										var lat = results[0].geometry.location
												.lat();
										var lan = results[0].geometry.location
												.lng();
										location.href = "main/" + id + "/"
												+ lat + "/" + lan + "/";
										/*
										 * window .open("map/" + lat + "/" + lan +
										 * "/", null,
										 * "height=200,width=400,status=yes,toolbar=no,menubar=no,location=no");
										 */
									}
								}
							}
						} else {
							alert('Invalid Zipcode');
						}
					});
}
});