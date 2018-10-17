function removeProductFromCart(id) {
	alert(id)
	$.ajax({
		url : "deleteProductFromCart",
		type : "POST",
		data : {
			"id" : id
		},
		success : function(data) {

		}
	});
};
