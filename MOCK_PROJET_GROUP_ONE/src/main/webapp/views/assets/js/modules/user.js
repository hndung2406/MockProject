$(document).ready(function(){
	$("#old-password-error").hide();
	$("#password-error").hide();
	$("#confirm-password-error").hide();
	
	$("#old-password").keyup(function(){
		var oldPassword = $("#old-password").val();
		$.ajax({
			url:"checkSession",
			type:"GET",
			success: function(data) {
				if(oldPassword == "") {
					$("#old-password-error").text("").hide();
				} else if (data.user.userPassword == oldPassword) {
					$("#old-password-error").text("").hide();
				} else {
					$("#old-password-error").text("*Wrong password").show();
				}
			}
		});
	});
	
	$("#password").keyup(function(){
		var password = $("#password").val();
		if(password == "") {
			$("#password-error").text("").hide();
		} else if (password.length < 8) {
			$("#password-error").text("*Your password must have at least 8 digits").show();
		} else {
			$("#password-error").text("").hide();
		}
 	});
	
	$("#confirm-password").keyup(function() {
		var confirmPassword = $("#confirm-password").val();
		var password = $("#password").val();
		if(confirmPassword == "") {
			$("#confirm-password-error").text("").hide();
		} else if (confirmPassword == password) {
			$("#confirm-password-error").text("").hide();
		} else {
			$("#confirm-password-error").text("*Password does not match").show();
		}
	});
	
	$("#update-button").click(function(){
		if($("#old-password-error").text() != "") {
			event.preventDefault();
		}
		if($("#password-error").text() != "") {
			event.preventDefault();
		}
		if($("#confirm-password-error").text() != "") {
			event.preventDefault();
		}
	});
	
});