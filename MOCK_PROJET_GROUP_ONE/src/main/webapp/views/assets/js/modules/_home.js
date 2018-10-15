$(function(){

	//request send ajax to server for retreieving list products
	$.ajax({

		url: getAllProducts,
		dataType: "json",
		type:"GET"


	}).done(function(response){
		console.log(response);
	})


	

});