$(document).ready(function() {

	$('#editName').click(function() {
		$("#name input, #name button").prop("disabled", false);
		document.getElementsByName("firstName")[0].focus();

	});

	$('#editEmail').click(function() {
		$("#email input, #email button").prop("disabled", false);
		document.getElementsByName("mobile")[0].focus();

	});

	$('#editPassword').click(function() {
		$("#password input, #password button").prop("disabled", false);
		document.getElementsByName("oldPassword")[0].focus();

	});

	$('#editZip').click(function() {
		$("#zip input, #zip button").prop("disabled", false);
		document.getElementsByName("city")[0].focus();

	});

	$('#editAddress').click(function() {
		$("#address textArea, #address button").prop("disabled", false);
		document.getElementsByName("address")[0].focus();

	});

	$('#editCard').click(function() {
		$(".container input").prop("disabled", false);
		$(".container select").prop("disabled", false);
		document.getElementsByName("firstName")[0].focus();

	});

});