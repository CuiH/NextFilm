$(function(){

	// 判断是否登录成功
	// $.ajax({
	// 	type: "GET",
	//     dataType: "html",
	//     url: "http://172.18.43.152:8080/is_login",
	//     success: function(data) {
	        
	//         // 首先判断是否成功
	//         data = JSON.parse(data)
	//         if (data["result"] == "success") {
	        
	// 			alert("ok")
	            
	//         } else {
	//             // DOM 操作
	//             alert("登录失败")
	//         }
	//     },
	//     error: function() {
	//         alert("server error1")
	//     }		
	// });

	// // 获取订单信息
	// $.ajax({
	// 	type: "GET",
	//     dataType: "html",
	//     url: "http://172.18.43.152:8080/view_all_reservation",
	//     success: function(data) {
	        
	//         // 首先判断是否成功
	//         if (data["result"] == "success") {
	        
	// 			$("#show-main-container").loadTemplate($("#show-t1"), data["data"]);
	            
	//         } else {
	//             // DOM 操作
	//             alert("Network error")
	//         }
	//     },
	//     error: function() {
	//         alert("server error1")
	//     }
	// });

})
