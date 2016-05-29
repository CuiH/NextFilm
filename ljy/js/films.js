$(function() {
	$('#myCarousel').carousel({
		interval: 2000
	})

	var ser_btn = $('#search_btn');
	ser_btn.on("click", function() {
		search_submit()
	})

	function search_submit(e) {
		str = document.getElementById("search_fuck").value;
		if (document.getElementById('fuck').childNodes.length != 5) {
			var x = document.getElementById('fuck');
			//alert('number'+x.childNodes.length);
			//alert(x.childNodes);
			for (var i = x.childNodes.length - 1; i >= 5; i--) {
				//alert(i);
				x.removeChild(x.childNodes[i]);
			};
			//alert(i);
		};
		//alert(str)
		$.ajax({
		type: "GET",
		dataType: "jsonp",
		url: "http://172.18.43.152:8080/get_film?name="+str,
		jsonpCallback: "ch",
		success: function(data) {
			// 解析一下
			// 首先判断是否成功
			if (data["result"] == "success") {
				//alert(data["result"]);
				//alert('length'+data.data.length)
				document.getElementsByClassName('film_name')[0].innerHTML = str;
				document.getElementsByClassName('film_number')[0].innerHTML = data.data.length;
				for (var i = 0; i < data.data.length; i++) {
					var node = document.getElementsByTagName('dl')[0].cloneNode(true);
					newNode = change(node, data.data[i]);
					newNode.hidden = false;
					//alert(i)
					//alert(newNode.innerHTML)
					document.getElementById('fuck').appendChild(newNode);
				};

			} else {
				alert(data["result"]);
			}
		},
		error: function() {
			// DOM 操作
		}
	});
	}

	function change (node, item) {
		var newNode = node;
		//alert(item.name);
		node.getElementsByTagName('img')[0].src = item.imageUrl;
		node.getElementsByClassName('dd_film')[0].innerHTML = item.name;
		node.getElementsByClassName('dd_time')[0].innerHTML = item.onDate;
		node.getElementsByClassName('dd_type')[0].innerHTML = item.category;
		node.getElementsByClassName('dd_actors')[0].innerHTML = function(ac, di){
			var str = "";
			if (di.length != 0) {str += getName(di);};
			if (ac.length != 0) {str += getName(ac);};
			return str;
		}(item.actors, item.directors);
		node.getElementsByClassName('dd_brief')[0].innerHTML = item.brief;
		return newNode;
	}

	function getName (list) {
		var str = "";
		for (var i = 0; i < list.length; i++) {
			str += list[i].name+"  ";
		};
		return str;
	}


	function load(json_data) {
		alert(json_data)
	}
})