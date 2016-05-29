$(function() {
	$('#myCarousel').carousel({
		interval: 2000
	})

	$.ajax({
		type: "GET",
		dataType: "jsonp",
		url: "http://172.18.43.152:8080/get_film?name=2",
		jsonpCallback: "ch",
		success: function(data) {
			// 解析一下
			alert(data.data[0].id)

			// 首先判断是否成功
			if (data["result"] == "success") {
				for (var i = 5; i >= 0; i--) {
					var nenode = document.getElementsByTagName('dl')[0].cloneNode(true);
					document.getElementById('fuck').appendChild(nenode);
				};

			} else {
				// DOM 操作
			}
		},
		error: function() {
			// DOM 操作
		}
	});

	function load(json_data) {
		alert(json_data)
	}
})