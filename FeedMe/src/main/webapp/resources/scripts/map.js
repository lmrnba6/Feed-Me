function loadMap() {
		var latlng = new google.maps.LatLng(document.getElementById('lat').value,  document.getElementById('lan').value);
		var myOptions = {
			zoom : 15,
			center : latlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("map_container"),
				myOptions);

		var marker = new google.maps.Marker({
			position : latlng,
			map : map,
			title : ""
		});

	}