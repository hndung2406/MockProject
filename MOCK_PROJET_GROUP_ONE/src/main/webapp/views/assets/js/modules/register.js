$(document).ready(function() {
	$(".error-form").hide();
	$("#button-sign-up").click(function() {
		
		if ($("#username").val() == "") {			
			$("#username-error").show();
			event.preventDefault();
		}
		if ($("#email").val() == "") {
			$("#email-error").show();
			event.preventDefault();
		}
		if ($("#firstname").val() == "") {
			$("#firstname-error").show();
			event.preventDefault();
		}
		if ($("#lastname").val() == "") {
			$("#lastname-error").show();
			event.preventDefault();
		}
		if ($("#password").val() == "") {
			$("#password-error").show();
			event.preventDefault();
		}
		if ($("#username-error-input").text() != ""){
			event.preventDefault();
		}
		if ($("#email-error-input").text() != ""){
			event.preventDefault();
		}
		if ($("#password-error-input").text() != ""){
			event.preventDefault();
		}
		if ($("#repassword-error").text() != ""){
			event.preventDefault();
		}
	});

	$("#username").keyup(function() {
		$("#username-error").hide();
		var username = $("#username").val();
		var valid = false;
		$.ajax({
			url:"findAllUser",
			type:"GET",
			success: function(data) {
				$.each(data.users, function(){
					if(this.userName == username) {
						valid = true;
					}
				});
				if (username == "") {
					$("#username-error-input").text("").hide();
				} else if (valid) {
					$("#username-error-input").text("*Username existed").show();
				} else if (username.length > 5){
					$("#username-error-input").text("").hide();
				} else {
					$("#username-error-input").text("*Username must have at least 6 characters").show();
				}
			}
		});
	});

	$("#email").keyup(function() {
		$("#email-error").hide();
		var email = $("#email").val();
		var valid = false;
		$.ajax({
			url:"findAllUser",
			type:"GET",
			success: function(data) {
				$.each(data.users, function(){
					if(this.userEmail == email) {
						valid = true;
					}
				});
				if(email == ""){
					$("#email-error-input").text("").hide();
				} else if (valid) {
					$("#email-error-input").text("*Email existed").show();
				} else if (validateEmail(email)){
					$("#email-error-input").text("").hide();
				} else {
					$("#email-error-input").text("*Wrong email format").show();
				}
			}
		});
	});

	$("#firstname").keyup(function() {
		$("#firstname-error").hide();
	});

	$("#lastname").keyup(function() {
		$("#lastname-error").hide();
	});

	$("#password").keyup(function() {
		$("#password-error").hide();
		if ($(this).val().length > 7) {
			$("#password-error-input").text("").hide();
		} else if ($(this).val() == "") {
			$("#password-error-input").text("").hide();
		} else {
			$("#password-error-input").text("*Password must have at least 8 characters or digits").show();
		}
	});
	
	$("#repassword").keyup(function(){
		if($(this).val() == $("#password").val()){
			$("#repassword-error").text("").hide();
		} else {
			$("#repassword-error").text("*Confirm password does not matched with password").show();
		}
	});
});

function validateEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}
