$(function(){

	// 判断是否登录成功
	$.ajax({
		type: "GET",
	    dataType: "html",
	    url: "/is_login",
	    success: function(data) {
	        // 首先判断是否成功
	        data = JSON.parse(data);
	        if (data["result"] == "success") {
				// tem
	        } else {
				alert(data["reason"]);
	        }
	    },
	    error: function() {
	        alert("server error")
	    }		
	});

	// 获取订单信息
	$.ajax({
		type: "GET",
	    dataType: "html",
	    url: "/view_all_reservation",
	    success: function(data) {
	        // 首先判断是否成功
	        if (data["result"] == "success") {
				$("#show-main-container").loadTemplate($("#show-t1"), data["data"]);
	        } else {
				alert(data["reason"]);
	        }
	    },
	    error: function() {
	        alert("server error")
	    }
	});

});
