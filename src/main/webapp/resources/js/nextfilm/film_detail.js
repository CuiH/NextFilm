$(function(){
	var Request = new Object();
	Request = GetRequest();
	function GetRequest() {
		var url = location.search;
		var theRequest = new Object();
		if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			for(var i = 0; i < strs.length; i++) {
				theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);
			}
		}
		return theRequest;
	}

	$.ajax({
		type: "GET",
	    dataType: "jsonp",
	    jsonpCallback: "ch",
	    url: "/view_film?id="  + Request["id"],
	    success: function(data) {
	        // 首先判断是否成功
	        if (data["result"] == "success") {
				$("#film-container").loadTemplate($("#template"), data["data"]);
	        } else {
	            alert(data["reason"]);
	        }
	    },
	    error: function() {
	        alert("server error")
	    }
	});

	$.ajax({
		type: "GET",
	    dataType: "jsonp",
	    jsonpCallback: "ljy",
	    url: "/get_showing2?filmId=" + Request["id"],
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

})
