$(document).ready(function(){
	$.ajax({
		url:"checkSession",
		type:"GET",
		success: function(data) {
			if(data.user.userRole == "admin"){
				$("#login").text("  Profile");
				$("#login-link").attr("href", "admin");
			}
			if(data.user.userRole == "user") {
				$("#login").text("  Profile");
				$("#login-link").attr("href", "user");
			}
		}
	});
});