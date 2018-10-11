$(document).ready(function(){
	$("#submit-button").click(function(){
		if($("#manufacture").val() == ""){
			$("#error").text("*Enter the manufacture").show();
			event.preventDefault();
		}
	});
});