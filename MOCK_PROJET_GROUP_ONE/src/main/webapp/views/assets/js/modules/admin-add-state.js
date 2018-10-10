$(document).ready(function(){
	$("#submit-button").click(function(){
		if($("#state").val() == ""){
			$("#error").text("*Enter the state").show();
			event.preventDefault();
		}
	});
});