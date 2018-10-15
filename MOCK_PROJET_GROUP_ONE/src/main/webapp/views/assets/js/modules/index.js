$(document).ready(function(){
	$.ajax({
		url:"checkSession",
		type:"GET",
		success: function(data) {	
		

			if(data.user){
				$("#login").text("  Profile");

				if(data.user.userRole == "admin"){
					$("#login-link").attr("href", "admin");
				}
				if(data.user.userRole == "user") {
					
					$("#login-link").attr("href", "user");
				}
				//append logout hyperlink  
				var $logoutLink = "<span class='site-header__icon'>"
								+ "<a href='logout' class='site-header__icon--link'>"
								+ "<i class='fa fa-sign-out'></i><span>Logout</span></a>"
								+ "</span>";

				$(".site-header--top").append($logoutLink);
			} else {
				$("#login").text(" Login");
			};			
				
		}
	});
});