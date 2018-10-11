$(document).ready(function(){
	
	$("#submit-button").click(function(){
		
		if($("#firstname").val() == "") {
			$("#firstname-error").text("*Enter your first name").show();
			event.preventDefault();
		}
		
		if($("#lastname").val() == "") {
			$("#lastname-error").text("*Enter your first name").show();
			event.preventDefault();
		}
		
		if($("#card").val() == "") {
			$("#card-error").text("*Enter your credit card number").show();
			event.preventDefault();
		}
		
		if($("#security").val() == "") {
			$("#security-error").text("*Missing code").show();
			event.preventDefault();
		}
		
		if($("#address").val() == "") {
			$("#address-error").text("*Enter your address").show();
			event.preventDefault();
		}
		
		if($("#city").val() == "") {
			$("#city-error").text("*Enter your city").show();
			event.preventDefault();
		}
		
		if($("#postal").val() == "") {
			$("#postal-error").text("*Enter your postal code").show();
			event.preventDefault();
		}
		
		if($("#phone").val() == "") {
			$("#phone-error").text("*Enter your postal code").show();
			event.preventDefault();
		}
		
		if($("#card-error").val() != "") {
			event.preventDefault();
		}
		
		if($("#security-error").val() != "") {
			event.preventDefault();
		}
		
	});
	
	$("#card").keyup(function(){
		if($("#card").val().length > 16) {
			$("#card-error").text("*Your card number should have 16 digits only").show();
		} else {
			$("#card-error").text("").hide();
		}
	});
	
	$("#security").keyup(function(){
		if($("#security").val().length > 3) {
			$("#security-error").text("*3 digits only").show();
		} else {
			$("#security-error").text("").hide();
		}
	});
	
});