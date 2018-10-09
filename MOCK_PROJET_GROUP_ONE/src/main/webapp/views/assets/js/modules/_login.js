$(function(){

	// $(".notification-error").hide();
		
	var $loginForm = $("#login-container__form");
	$(".loading-img").hide();

	$loginForm .validate({

		rules: {
			email : {
				required: true,
				email: true
			},
			password: {
				required: true				
			}
		},				
		messages: {
			email: {
				email: "Input email. Ex: johndoe@example.com",
				required: "Email is required"
			},
			password: {
				required: "Password is required"				
			}
		}, submitHandler: function(form,e){

			e.preventDefault();	
			$(".loading-img").show();
			$(".error-message").text("");	

			//send ajax
			var json = JSON.stringify($loginForm.serializeObject());
			var data = $loginForm.serialize();
			

			$.ajax({

				url:"login",
				type: "post",			
				data: {jsonData: json}

			}).done(function(data){				
				
				
				setTimeout(function(){
					if(data.errorMessage){
						$(".error-message")
							.css({
								"color":"red",
								"font-size": "0.9rem"
							})
							.text(data.errorMessage)
							.appendTo($(this).parent());
						$(".loading-img").hide()
					}
					if(data.redirectUrl){
						window.location = data.redirectUrl;
					}
				}, 3000);

			});
			
		}
	});
	// $(document).ajaxStart(function(){
 //        $(".loading-img").show();
 //    });
 //    $(document).ajaxComplete(function(){
 //        $(".loading-img").hide();
 //    });


	// serializeObjec function utility
	  	jQuery.fn.serializeObject = function(){
	       var arrayData, objectData;
	       arrayData = this.serializeArray();
	       objectData = {};

	       $.each(arrayData, function() {
	           var value;

	           if (this.value != null) {
	               value = this.value;
	           } else {
	               value = '';
	           }

	           if (objectData[this.name] != null) {
	               if (!objectData[this.name].push) {
	                   objectData[this.name] = [objectData[this.name]];
	               }

	               objectData[this.name].push(value);
	           } else {
	               objectData[this.name] = value;
	           }
	       });

	       return objectData;
	   };

	


});