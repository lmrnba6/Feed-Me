$(document).ready(function(){

	 
$("#rating").click(function(){
	$("#ratingDiv").show();
	 $("#menuDiv").hide();
	 $('html, body').animate({
	        scrollTop: $("#ratingDiv").offset().top
	    }, 500);
});

$("#menu").click(function(){
	$("#ratingDiv").hide();
    $("#menuDiv").show();
    $('html, body').animate({
        scrollTop: $("#menuDiv").offset().top
    }, 500);
});

$("#addCart").click(function(){
	
	$.ajax({
		type:'GET',
		data: { restId:"${restaurant.restId}", mealId: "${m.restId}"},
		url: '/FeedMe/restaurant/addCart/${restId}/${mealId}',
			success: function(data){
				
				prompt("","");
				
			}		
	});
});

});