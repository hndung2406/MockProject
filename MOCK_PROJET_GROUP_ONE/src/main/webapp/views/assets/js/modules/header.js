$(document).ready(function(){
	$("#search").keyup(function(){
		search = $("#search").val();
		if(search == "") {
			$("#result").html("");
		}
		$.ajax({
			url:"findAll",
			type:"GET",
			success: function(data) {
				$.each(data.users, function(){
					if(this.userName == search) {
						$("#result").html('<li class="list-group-item link-class">' + this.userName + '</li>')
					}
				});
			}
		});
	});
});