$(function(){
	$('#myCarousel').carousel({
		interval: 2000
	});

	$.ajax({
		type: "GET",
	    dataType: "html",
	    url: "/is_login",
	    success: function(data) {
	        // 首先判断是否成功
	        data = JSON.parse(data);
	        if (data["result"] == "success") {
				$('#user-name').text(data["data"])
	        } else {
				alert(data["reason"]);
	        }
	    },
	    error: function() {
	        alert("server error")
	    }		
	});

	// $("#user-name")
	// fetch film information
	$.ajax({
		type: "GET",
	    dataType: "jsonp",
	    jsonpCallback: "ch",
	    url: "/get_some_film?num=4",
	    success: function(data) {
	        // 首先判断是否成功
	        if (data["result"] == "success") {
				for(var x in data["data"]) {
					data["data"][x]["id"] = "/film?id=" + data["data"][x]["id"]
				}
				$("#film-new-list").loadTemplate($("#template"), data["data"]);
	        } else {
				alert(data["reason"]);
	        }
	    },
	    error: function() {
	        alert("server error")
	    }
	});

	// fetch cinema info
	$.ajax({
		type: "GET",
	    dataType: "jsonp",
	    jsonpCallback: "cjs",
	    url: "/get_some_cinema?num=2",
	    success: function(data) {
	        // 首先判断是否成功
	        if (data["result"] == "success") {
	            // DOM 操作
	            var i = 0;
	            var count = data["data"].length;
	            list = $("#cinema-new-container img");
	            spList = $("#cinema-new-container span");
	            pList = $("#cinema-new-list p");
	            for (i = 0; i < count; i++) {
					list[i]["src"] = data["data"][i]["imageUrl"]
					$(spList[i]).html(data["data"][i]["name"])
					$(pList[i]).html(data["data"][i]["address"])
	            }
	        } else {
				alert(data["reason"]);
	        }
	    },
	    error: function() {
	        alert("server error")
	    }
	})
})