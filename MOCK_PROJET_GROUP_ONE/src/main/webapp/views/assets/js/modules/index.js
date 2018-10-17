$(document).ready(function(){
	var count = 0;
	
	$.ajax({
		url:"checkSession",
		type:"GET",
		success: function(data) {	
			if(data.user){
				$("#login").text("  Profile");

				if(data.user.userRole == "admin"){
					$("#login-link").attr("href", "pages/admin-products");
				}
				if(data.user.userRole == "user") {
					$("#login-link").attr("href", "userProfile");
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
	var quantity = 0;
	$.ajax({
		url:"cartSession",
		type:"GET",
		success: function(data) {
			quantity = data.totalQuantity;
			$(".quantity").text(quantity);
		}
	});
	
	$(".btn-warning").click(function() {
		$.ajax({
			url:"addToCart",
			type:"POST",
			data: {
				"id": $(this).prev().prev().prev().prev().text()
			},
			success: function(data) {
				
			}
		});

		quantity += 1;
		$(".quantity").text(quantity);
	});
	
});