$(function(){

	$.ajax({
		type: "GET",
	    dataType: "jsonp",
	    jsonpCallback: "ch",
	    url: "http://172.18.43.152:8080/view_film?id=43",
	    success: function(data) {
	        
	        // 首先判断是否成功
	        if (data["result"] == "success") {
	        
				$("#film-container").loadTemplate($("#template"), data["data"]);
	            
	        } else {
	            // DOM 操作
	            alert("Network error")
	        }
	    },
	    error: function() {
	        alert("server error1")
	    }
	});

	$.ajax({
		type: "GET",
	    dataType: "jsonp",
	    jsonpCallback: "ljy",
	    url: "http://172.18.43.152:8080/get_showing2?filmId=40",
	    success: function(data) {
	        
	        // 首先判断是否成功
	        if (data["result"] == "success") {
	        
				$("#show-main-container").loadTemplate($("#show-t1"), data["data"]);
	            
	        } else {
	            // DOM 操作
	            alert("Network error")
	        }
	    },
	    error: function() {
	        alert("server error1")
	    }
	});

})
