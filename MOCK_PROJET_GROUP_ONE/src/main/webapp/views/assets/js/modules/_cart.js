$(document).ready(function () {			
			var totalItem = 0;
			var totalPrice = 0;

			$(".btn-remove").click(function () {
				$(this).closest("tr").fadeOut('slow', function (c) {
					var subTotal = $(this).closest("tr").find("td:nth-child(4)").find("span:nth-child(2)").text();
					var quantityTotal = $(this).closest("tr").find("td:nth-child(3)").find("input").val();
					totalItem -= parseInt(quantityTotal);
					totalPrice -= parseInt(subTotal);
					$(this).closest("tr").remove();
					$("#total-order").text(totalPrice);
					$("#quantity").text(totalItem);
				});
				
			});
			
			$(".input-drop-down").change(function () {
				var sumQuantity = 0;
				var sumTotal = 0;
				$(this).parent().next().children().next().text($(this).parent().prev().children().next().text() * $(this).val());
				$(".input-drop-down").each(function(){
					sumQuantity += parseInt($(this).val());
				});
				totalItem = sumQuantity;
				$(".price").each(function () {
					sumTotal += parseInt($(this).text());
				});
				totalPrice = sumTotal;
				$("#total-order").text(totalPrice);
				$("#quantity").text(totalItem);
			});

			$("tbody tr").each(function() {
				var price = $(this).find("td:nth-child(4)").find("span:nth-child(2)").text();
				var item = $(this).find("td:nth-child(3)").find("input").val();
				totalPrice += parseInt(price);
				totalItem += parseInt(item);
			})
			
			$("#total-order").text(totalPrice);
			$("#quantity").text(totalItem);

		});
