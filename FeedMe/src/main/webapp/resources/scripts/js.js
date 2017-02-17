

var geocoder;
var map;
function codeAddress() {
	geocoder = new google.maps.Geocoder();
	var address = document.getElementById('address').value;
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
										/* alert(results[0]['address_components'][2]['long_name'] + ' , '  + state); */
										var city = (results[0]['address_components'][2]['long_name'])
												.toString();
										location.href = "restaurant/list/"
												+ city;
									}

								}
							}
						} else {
							if (address !== "")
								alert('Invalid Zipcode');
						}
					});
};