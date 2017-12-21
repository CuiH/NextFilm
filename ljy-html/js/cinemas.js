$(function() {
	$('#myCarousel').carousel({
		interval: 2000
	})

	var ser_btn = $('#search_btn');
	ser_btn.on("click", function() {
		search_submit();
	})

	function search_submit() {
		//('fuck');
		str = document.getElementById("search_fuck").value;
		//('str'+ str);
		if (document.getElementById('fuck').childNodes.length != 5) {
			var x = document.getElementById('fuck');
			//('number'+x.childNodes.length);
			////(x.childNodes);
			for (var i = x.childNodes.length - 1; i >= 5; i--) {
				////(i);
				x.removeChild(x.childNodes[i]);
			};
			////(i);
		};
		//('str'+ str)
		$.ajax({
		type: "GET",
		dataType: "jsonp",
		url: "http://172.18.43.152:8080/get_cinema?name="+str,
		jsonpCallback: "cjs",
		success: function(data) {
			// 解析一下
			// 首先判断是否成功
			if (data["result"] == "success") {
				//(data["result"]);
				//('length'+data.data.length)

				document.getElementsByClassName('film_name')[0].innerHTML = str;
				document.getElementsByClassName('film_number')[0].innerHTML = data.data.length;
				for (var i = 0; i < data.data.length; i++) {
					//('i'+ i)
					var node = document.getElementsByTagName('dl')[0].cloneNode(true);
					newNode = change(node, data.data[i]);
					newNode.hidden = false;
					
					////(newNode.innerHTML)
					document.getElementById('fuck').appendChild(newNode);
				};

			} else {
				document.getElementsByClassName('film_name')[0].innerHTML = str;
				document.getElementsByClassName('film_number')[0].innerHTML = '0';
			}
		},
		error: function() {
			// DOM 操作
		}
	});
	}

	function change (node, item) {
		var newNode = node;
		////(item.name);
		node.getElementsByTagName('img')[0].src = item.imageUrl;
		node.getElementsByClassName('dd_cinema')[0].innerHTML = item.name;
		node.getElementsByClassName('dd_address')[0].innerHTML = item.address;
		node.getElementsByClassName('dd_brief')[0].innerHTML = item.brief;
		node.getElementsByClassName('dd_films')[0].innerHTML = function(films){
			var str = "";
			if (films.length != 0) {str += getName(films);};
			return str;
		}(item.films);
		node.getElementsByClassName('dd_brief')[0].innerHTML = item.brief;
		return newNode;
	}

	function getName (list) {
		var str = "";
		for (var i = 0; i < list.length; i++) {
			str += "【"+list[i].name+"】"+"  ";
		};
		return str;
	}


	function load(json_data) {
		alert(json_data)
	}
})