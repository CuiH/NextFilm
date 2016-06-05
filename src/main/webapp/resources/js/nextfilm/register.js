$(function(){
	$('#signin-btn').click(function(){
		$('#signin-btn').attr("disabled", "disabled");
		$('#signin-btn').text("loading");

		$.ajax({
			type: "POST",
			dataType: "html",
			url: "/login",
			data: $("#signForm").serialize(),
			success: function(data) {
				data = JSON.parse(data);
				if (data["result"] == "success") {
					$('#signin-btn').text("Success");
					$("#mymodal").modal("show");
					$(".modal-body").text("success");

					window.location.replace("/main")
				} else {
					$('#signin-btn').text("Sign in");
					$('#signin-btn').removeAttr("disabled")

					$("#mymodal").modal("show");

					$(".modal-body").text(data["reason"]);
				}
			},
			error: function() {
				$('#signin-btn').removeAttr("disabled");
				$('#signin-btn').text("Sign in");

				$("#mymodal").modal("show");

				$(".modal-body").text("error");
			}
		});
	});
});