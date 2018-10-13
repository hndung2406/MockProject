$(document).ready(function(){
	$("#search").keyup(function(){
		$("#result").html("");
		var searchField = $("#search").val();
		var expression = new RegExp(searchField, "i");
		var output = "";
		$.ajax({
			url:"findAllProduct",
			type:"GET",
			success: function(data) {
				$.each(data.products, function(){
				    if (this.name.search(expression) != -1) {
				    	output += "<li class='list-group-item link-class'><a href='abc?id=" + this.id +"' style='display:block;text-decoration: none;color:black;'>" + this.name + "</a></li>";
					} 
				});
				$("#result").html(output);
				if(searchField == "") {
					$("li").remove();
				}	
			}
		});
	});
	
	$(document.body).click(function(){
		$("li").remove();
		$("#search").val("");
	});
	
});

