$(document).ready(function () {			
			var totalItem = 0;
			var totalPrice = 0;

			$(".btn-remove").click(function () {
				var id = $(this).closest("td").find("span").text();
				$.ajax({
					url : "deleteProduct",
					type : "POST",
					data : {
						"id" : id
					},
					success : function(data) {
						location.reload();
					}
				});
				$(this).closest("tr").fadeOut('slow', function (c) {
					var subTotal = $(this).closest("tr").find("td:nth-child(4)").find("span:nth-child(2)").text();
					var quantityTotal = $(this).closest("tr").find("td:nth-child(3)").find("input").val();
					totalItem -= parseInt(quantityTotal);
					totalPrice -= parseInt(subTotal);
					$("#total-order").text(totalPrice);
					$("#quantity").text(totalItem);
					$("#totalQuantity").text(totalItem);
					$(this).closest("tr").remove();
				});
				
			});
			
			$(".input-drop-down").change(function () {
				var sumQuantity = 0;
				var sumTotal = 0;
				$(this).parent().next().children().next().text($(this).parent().prev().children().next().text() * $(this).val());
				var id = $(this).closest("td").find("span").text();
				var quantity = $(this).closest("td").find("input").val();
				$.ajax({
					url : "changeQuantity",
					type : "POST",
					data : {
						"id" : id,
						"quantity" : quantity
					},
					success : function(data) {
						location.reload();
					}
				});
				
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
				$("#totalQuantity").text(totalItem);

			});

			$("tbody tr").each(function() {
				var price = $(this).find("td:nth-child(4)").find("span:nth-child(2)").text();
				var item = $(this).find("td:nth-child(3)").find("input").val();
				totalPrice += parseInt(price);
				totalItem += parseInt(item);
			})
			
			$("#total-order").text(totalPrice);
			$("#quantity").text(totalItem);
			$("#totalQuantity").text(totalItem);

});
