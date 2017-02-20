$(document).ready(function(){

	 
$("#rating").click(function(){
	$("#ratingDiv").show();
	 $("#menuDiv").hide();
	 $("#infoDiv").hide();
	 $('html, body').animate({
	        scrollTop: $("#ratingDiv").offset().top
	    }, 500);
});

$("#menu").click(function(){
	$("#ratingDiv").hide();
    $("#menuDiv").show();
    $("#infoDiv").hide();
    $('html, body').animate({
        scrollTop: $("#menuDiv").offset().top
    }, 500);
});

$("#info").click(function(){
	$("#ratingDiv").hide();
    $("#menuDiv").hide();
    $("#infoDiv").show();
    $('html, body').animate({
        scrollTop: $("#menuDiv").offset().top
    }, 500);
});


$(".picture").hide();


$("#changePicture").click(function(){
	
	$(".picture").show();
});

$('#editName').click(function() {
	$("#name input, #name button").prop("disabled", false);
	document.getElementsByName("name")[0].focus();

});

$('#editAddress').click(function() {
	$("#address input, #description button").prop("disabled", false);
	document.getElementsByName("address")[0].focus();

});

$('#editDelivery').click(function() {
	$("#delivery input, #delivery button, #delivery select").prop("disabled", false);

});

$('#editCity').click(function() {
	$("#city input, #city button").prop("disabled", false);
	document.getElementsByName("city")[0].focus();

});

});
