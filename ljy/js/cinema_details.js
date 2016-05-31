$(function() {
	$('#myCarousel').carousel({
		interval: 2000
	})


	refreshDate();
	bindDateClick();
	bindFilmClick();

	var str = 24;
	$.ajax({
		type: "GET",
		dataType: "jsonp",
		url: "http://172.18.43.152:8080/view_cinema?id=" + str,
		jsonpCallback: "cjs",
		success: function(data) {
			// 解析一下
			// 首先判断是否成功
			if (data["result"] == "success") {
				//alert(data["result"]);	
				id = data.data.id + "";
				document.getElementsByClassName('left')[0].innerHTML = data.data.name;
				document.getElementsByClassName("cinema_image")[0].src = data.data.imageUrl;

				document.getElementsByClassName('cinema_address')[0].innerHTML = data.data.address;
				document.getElementsByClassName('cinema_phone')[0].innerHTML = data.data.phone;
				document.getElementsByClassName('cinama_brief')[0].innerHTML = data.data.brief;
				document.getElementsByClassName('ffst')[0].innerHTML = data.data.description;
				document.getElementsByClassName('show_ci')[0].hidden = false;
			} else {
				document.getElementsByClassName('failed')[0].hidden = false;
			}
		},
		error: function() {
			alert("error:view_cinema");
		}
	});

	function bindFilmClick() {
		document.getElementById('ul_par').addEventListener("click", function(e) {
			var that = e.target;
			var index = "none"
			var siblings = "none"
			if (that.nodeName.toLowerCase() == 'li') {
				index = that.value;

				siblings = that.parentNode.childNodes;

				for (var i = 0; i < siblings.length; i++) {
					if (siblings[i].classList) {
						siblings[i].classList.remove("panel-primary");
					};

				};

				that.classList.add("panel-primary");
			} else {
				index = that.parentNode.value;

				siblings = that.parentNode.parentNode.childNodes;
				for (var i = 0; i < siblings.length; i++) {
					if (siblings[i].classList) {
						siblings[i].classList.remove("panel-primary");
					};

				};
				that.parentNode.classList.add("panel-primary");
				//alert(that.parentNode.siblings());
			}
			//alert(index);
			showings = info[index].showings;
			//console.log(film);
			refreshListInfo();
		})
	}



	/*function hasClass(elem, cls) {
		cls = cls || '';
		if (cls.replace(/\s/g, '').length == 0) return false;
		return new RegExp(' ' + cls + ' ').test(' ' + elem.className + ' ');
	}

	function addClass(elem, cls) {
		if (!hasClass(elem, cls)) {
			elem.className += ' ' + cls;
		}
	}

	function removeClass(elem, cls) {
		if (hasClass(elem, cls)) {
			var newClass = ' ' + elem.className.replace(/[\t\r\n]/g, '') + ' ';
			while (newClass.indexOf(' ' + cls + ' ') >= 0) {
				newClass = newClass.replace(' ' + cls + ' ', ' ');
			}
			elem.className = newClass.replace(/^\s+|\s+$/g, '');
		}
	}*/

	function bindDateClick() {

		for (var i = 0; i <= 6; i++) {
			var btn = $("#btn_" + i);

			btn.on('click', fuck);
		};
	}

	function fuck(d) {
		//console.log(d.target.value);
		//alert(id);
		//alert(d.target.value)
		var s = d.target.parentNode.childNodes;
		for (var i = s.length - 1; i >= 0; i--) {
			if (s[i].classList) {
				s[i].classList.remove("btn-success");
			};
			
		};
		d.target.classList.add("btn-success");
		$.ajax({
			type: "GET",
			dataType: "jsonp",
			url: "http://172.18.43.152:8080/get_showing?cinemaId=" + id + "&date=" + time[d.target.value],
			jsonpCallback: "ljy",
			success: function(data) {
				// 解析一下
				// 首先判断是否成功
				//console.log(data);

				data = JSON.parse('{"result": "success", "data": [{"film":{"id":43,"name":"美国队长3","brief":"奥创纪元之后，全球政府联合颁布法令，管控超能力活动。对这条法令的不同态度，使复仇者阵营一分为二，最终引发前任盟友间的史诗大战。","language":"英语","imageUrl":"http://img5.gewara.com/cw270h360/images/movie/201604/s_747af3c5_153f030b855__79af.jpg"},"showings":[{"id":32,"startTime":"2016-06-21T11:00","endTime":"1111-11-11T11:11","priceManual":"45.0","hall":{"id":16,"name":"1号厅","type":"普通"}},{"id":33,"startTime":"2016-06-21T12:00","endTime":"1111-11-11T11:11","priceManual":"50.0","hall":{"id":16,"name":"1号厅","type":"普通"}},{"id":35,"startTime":"2016-06-21T15:00","endTime":"1111-11-11T11:11","priceManual":"52.0","hall":{"id":13,"name":"IMAX厅","type":"IMAX"}}]},{"film":{"id":43,"name":"美国队长3","brief":"奥创纪元之后，全球政府联合颁布法令，管控超能力活动。对这条法令的不同态度，使复仇者阵营一分为二，最终引发前任盟友间的史诗大战。","language":"英语","imageUrl":"http://img5.gewara.com/cw270h360/images/movie/201604/s_747af3c5_153f030b855__79af.jpg"},"showings":[{"id":32,"startTime":"2016-06-21T11:00","endTime":"1111-11-11T11:11","priceManual":"45.0","hall":{"id":16,"name":"1号厅","type":"普通"}},{"id":33,"startTime":"2016-06-21T12:00","endTime":"1111-11-11T11:11","priceManual":"50.0","hall":{"id":16,"name":"1号厅","type":"普通"}},{"id":35,"startTime":"2016-06-21T15:00","endTime":"1111-11-11T11:11","priceManual":"52.0","hall":{"id":13,"name":"IMAX厅","type":"IMAX"}}]}]}');



				if (data["result"] == "success") {
					//alert(data["result"]);
					info = data.data;
					refreshFilms();
				} else {
					alert(data["result"]);
				}
			},
			error: function() {
				alert("error:get_showing");
			}
		});
	}


	function refreshDate() {
		var btn_list = document.getElementsByClassName('date_btn');
		var myDate = new Date();
		for (var i = 0; i < btn_list.length; i++) {
			btn_list[i].value = i; //getValue(myDate);
			btn_list[i].innerHTML = getD(myDate);
			myDate = addOneDay(myDate);

		};
	}


	function refreshFilms() {
		//console.log('refreshFilms');
		//console.log(info);
		if (info.length != 0) {
			var li_list = document.getElementsByClassName('select');
			if (li_list.length != 1) {
				var x = document.getElementById('ul_par');
				//('number'+x.childNodes.length);
				console.log(x.childNodes);
				for (var i = x.childNodes.length - 1; i > 1; i--) {
					//alert('removeChild');
					x.removeChild(x.childNodes[i]);
				};
				//alert('fuck')
			};

			for (var i = 0; i < info.length; i++) {
				var node = document.getElementsByClassName('select')[0].cloneNode(true);
				var newNode = change(node, info[i]);
				newNode.hidden = false;
				newNode.value = i;
				//alert(i)
				document.getElementById('ul_par').appendChild(newNode);
			};

		};
	}

	function refreshListInfo() {
		var tr_list = document.getElementsByClassName('tr_row');
		if (tr_list.length != 1) {
			var x = document.getElementById('tbody_par');
			//('number'+x.childNodes.length);
			//console.log(x.childNodes);
			for (var i = x.childNodes.length - 1; i > 1; i--) {
				//alert('removeChild');
				x.removeChild(x.childNodes[i]);
			};
		};

		if (showings.length == 0) {
			alert('no showings');
			return;
		};
		for (var i = 0; i < showings.length; i++) {
			var node = document.getElementsByClassName('tr_row')[0].cloneNode(true);
			var newNode = change_tr(node, i);
			newNode.hidden = false;
			document.getElementById('tbody_par').appendChild(newNode);
		};



	}

	function change_tr(node, i) {
		//console.log(showings[i].startTime);
		node.getElementsByTagName('th')[0].innerHTML = showings[i].startTime.split('T')[1];
		//console.log(node.getElementsByClassName('endTime')[0].innerHTML);
		node.getElementsByClassName('endTime')[0].innerHTML = showings[i].endTime.split('T')[1];
		node.getElementsByClassName('price')[0].innerHTML = showings[i].priceManual;
		node.getElementsByClassName('hall')[0].innerHTML = showings[i].hall.name;
		return node;
	}

	function change(node, item) {
		film = item.film;
		showings = item.showings;
		var newNode = node
		newNode.getElementsByTagName('img')[0].src = film.imageUrl;
		newNode.getElementsByTagName('em')[0].innerHTML = film.name;

		//console.log(newNode);
		return newNode;
	}



	function getValue(date) {
		var s = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
		return s;
	}

	function getD(date) {
		var s = (date.getMonth() + 1) + "月" + date.getDate() + "日";
		return s;
	}

	function addOneDay(date) {
		return new Date(date.valueOf() + 1 * 24 * 60 * 60 * 1000)
	}



})


//panel-primary

id = 'none'
info = "none"
date_select = "none"
film = "none"
showings = "none"
time = ['2016-6-21', '2016-6-22', '2016-6-23']