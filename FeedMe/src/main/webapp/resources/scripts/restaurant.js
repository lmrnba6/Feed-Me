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



});