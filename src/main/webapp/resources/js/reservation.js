/**
 * Created by cuihao on 2016/5/28.
 */
$(document).ready(function() {
    $("#refresh_page").click(function() {
        window.location.reload();
    });

    $("#user_searcher").on("input",function(){
        if ($(this).val() == "" || $(this).val() == " " ) return;

        $("#search_div").addClass("loading");

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "/find_reservation?userName="+$(this).val(),
            success: function(data) {
                $("#search_div").removeClass("loading");

                data = JSON.parse(data);
                if (data["result"] == "success") {
                    $("#reservation_table").html("");
                    $("#search_results").html("");

                    var tem = data["data"];
                    for (var i = 0; i < tem.length; i++) {
                        var str = '<tr>' +
                            '<td>' + tem[i]["id"] + '</td>' +
                            '<td>' + tem[i]["createTime"] + '</td>' +
                            '<td>' + tem[i]["filmName"] + '</td>' +
                            '<td>' + tem[i]["cinemaName"] + '</td>' +
                            '<td>' + tem[i]["startTime"] + '</td>' +
                            '<td>' + tem[i]["seatNum"] + '</td>' +
                            '<td>' + tem[i]["totalPrice"] + '</td>' +
                            '<td>' + tem[i]["status"] + '</td>' +
                            '<td><button class="ui blue button view_reservation" reservation-id="' + tem[i]["id"] + '">view</button></td>' +
                            '<td><button class="ui red button delete_reservation" reservation-id="' + tem[i]["id"] + '">delete</button></td>' +
                            '</tr>';

                        $("#reservation_table").append(str);
                    }

                    $(".delete_reservation").click(function() {
                        $.ajax({
                            type: "GET",
                            dataType: "html",
                            url: "/delete_reservation?id=" + $(this).attr("reservation-id"),
                            success: function(data) {
                                data = JSON.parse(data);
                                if (data["result"] == "success") {
                                    $("#model_success").modal('show');
                                } else {
                                    $("#model_fail .content").html("<p>" + data["reason"] + "</p>");
                                    $("#model_fail").modal('show');
                                }
                            },
                            error: function() {
                                alert("error");
                            }
                        });
                    });

                    $(".view_reservation").click(function() {
                        $("#model_detail").modal('show');

                        $.ajax({
                            type: "GET",
                            dataType: "html",
                            url: "/view_reservation?id=" + $(this).attr("reservation-id"),
                            success: function(data) {
                                data = JSON.parse(data);
                                if (data["result"] == "success") {
                                    var tem = data["data"];

                                    var seats = [];
                                    var items = tem["orderItems"];
                                    for (var i = 0; i < items.length; i++) {
                                        seats.push(items[i]["row"] + "排" + items[i]["column"] + "座 " + items[i]["price"] + "元");
                                    }

                                    var str =   '<p>电影：' + tem["filmName"] + '</p>' +
                                        '<p>影院：' + tem["cinemaName"] +'</p>' +
                                        '<p>影厅：' + tem["hallName"] + '</p>' +
                                        '<p>开始时间：' + tem["startTime"] + '</p>' +
                                        '<p>预定时间：' + tem["createTime"] + '</p>' +
                                        '<p>总价：' + tem["totalPrice"] + '</p>' +
                                        '<p>折扣：' + tem["discount"] + '</p>' +
                                        '<p>订单状态：' + tem["status"] +  '</p>' +
                                        '<br/>' +
                                        '<p>座位：' + seats.join("、") + '</p>';

                                    $("#detail_field").html(str);
                                } else {
                                    $("#detail_field").html(str);("<p>" + data["reason"] + "</p>");
                                }
                            },
                            error: function() {
                                alert("error");
                            }
                        });
                    });

                } else {
                    $("#search_results").html("<span style='margin-left: 25px; margin-top: 15px; margin-bottom: 22px;'>未找到</span>");
                }
            },
            error: function() {
                $("#search_div").removeClass("loading");

                alert("error");
            }
        });
    });
});
