$(function(){
	$('#signin-btn').click(function(){
		$.ajax({
			type: "POST",
		    dataType: "jsonp",
		    jsonpCallback: "ch",
		    url: "http://172.18.43.152:8080/login",
		    data: $("#signForm").serialize(),
		    success: function(data) {
		        // 解析一下
		        data = JSON.parse(data);

		        // 首先判断是否成功
		        if (data["result"] == "success") {
		            // DOM 操作
		            alert("yes")
		            // 重定向
		            // window.location.replace("/xxx");
		        } else {
		            // DOM 操作
		            alert("No")
		        }
		    },
		    error: function() {
		        // DOM 操作
		    }
		})

		// $.jsonp({
		// 	"type": "POST",
		//     "dataType": "html",
		//     "url": "http://172.18.43.152:8080/login",
		//     "data": $("#signForm").serialize(),
	 //  		"success": function(data) {
	 //    		$("#current-group").text("当前工作组:"+data.result.name);
	 //  		},
	 //  		"error": function(d,msg) {
	 //    		alert("Could not find user "+msg);
	 //  		}
		// });
	})

});