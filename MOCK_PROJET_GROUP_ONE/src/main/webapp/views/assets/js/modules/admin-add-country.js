$(document).ready(function(){
	$("#submit-button").click(function(){
		if($("#country").val() == ""){
			$("#error").text("*Enter the country").show();
			event.preventDefault();
		}
	});
});