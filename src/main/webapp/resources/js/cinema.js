/**
 * Created by CuiH on 2016/5/26.
 */
$(document).ready(function() {
    $('select.dropdown').dropdown();

    $('.special.cards .image').dimmer({on: 'hover'});

    $("div.delete_film").click(function() {
        $(this).parent().parent().parent().parent().parent().remove();
    })

    $("#add-film").click(function() {
        $('.ui.modal').modal('show');
    });

    function checkDuplication(id) {
        var list = $("#film-field").children("div");
        for (var i = 0; i < list.length; i++) {
            if (id == $(list[i]).attr("film-id")) return true;
        }

        return false;
    };

    $("#film_searcher").on("input",function(){
        if ($(this).val() == "" || $(this).val() == " ") return;

        $("#searcher-div").addClass("loading");

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "/find_film?name="+$(this).val(),
            success: function(data) {
                $("#searcher-div").removeClass("loading");

                data = JSON.parse(data);
                if (data["result"] == "success") {
                    $("#search_results").text("");

                    var tem = data["films"];
                    for (var i = 0; i < tem.length; i++) {
                        var str = '<div class="card">' +
                                    '<div id="search-film' + tem[i]["id"] + '" class="blurring dimmable image">' +
                                      '<div class="ui inverted dimmer">' +
                                        '<div class="content">' +
                                          '<div class="center">' +
                                            '<button class="ui primary button add-film" ' + 'film-id="' + tem[i]["id"] + '" film-name="' + tem[i]["name"] + '" film-image="' + tem[i]["imageUrl"] + '">add</button>' +
                                          '</div>' +
                                        '</div>' +
                                      '</div>' +
                                      '<img src="' + tem[i]["imageUrl"] + '">' +
                                    '</div>' +
                                    '<div class="content">' +
                                      '<a class="header">' + tem[i]["name"] + '</a>' +
                                    '</div>' +
                                  '</div>';

                        $("#search_results").append(str);

                        $('#search-film' + tem[i]["id"]).dimmer({on: 'hover'});
                    }

                    setTimeout("$('.ui.modal').modal('refresh');", 10);

                    $('button.add-film').click(function() {
                        $('.ui.modal').modal('hide');

                        var id = $(this).attr("film-id");

                        if (checkDuplication(id)) {
                            alert("请勿重复添加");
                            return;
                        }

                        var str = '<div film-id="' + id + '" class="card">' +
                                    '<div id="field-film' + id + '" class="blurring dimmable image">' +
                                      '<div class="ui inverted dimmer">' +
                                        '<div class="content">' +
                                          '<div class="center">' +
                                            '<div id="delete-film' + id + '" class="ui primary button delete_film">下架影片</div>' +
                                            '<a class="ui primary button" href="/show_all_showing?cinemaId=' + $("#id").attr("value") + '&filmId=' + id + '">查看排片</a>' +
                                          '</div>' +
                                        '</div>' +
                                      '</div>' +
                                      '<img id="search-film' + id + '" src="' +$(this).attr("film-image") + '">' +
                                    '</div>' +
                                    '<div class="content">' +
                                      '<a class="header">' + $(this).attr("film-name") + '</a>' +
                                    '</div>' +
                                  '</div>';

                        $('#film-field').append(str);

                        $('#field-film' + id).dimmer({on: 'hover'});

                        $("#delete-film" + id).click(function () {
                            $(this).parent().parent().parent().parent().parent().remove();
                        });
                    });

                } else {
                    $("#search_results").html("<span style='margin-left: 25px; margin-top: 15px; margin-bottom: 22px;'>未找到</span>");

                    setTimeout("$('.ui.modal').modal('refresh');", 10);
                }
            },
            error: function() {
                $("#searcher-div").removeClass("loading");

                alert("error");
            }
        });
    });

    $("#submit-film").click(function() {
        var str = "cinemaId=" + $("#id").attr("value");

        var list = $("#film-field").children("div");
        for (var i = 0; i < list.length; i++) {
            str += '&filmIds=' + $(list[i]).attr("film-id");
        }

        $.ajax({
            type: "POST",
            dataType: "html",
            url: "/edit_showing_film",
            data: str,
            success: function(result) {
                console.log(result);
            },
            error: function() {
                alert("error");
            }
        });
    })
});
