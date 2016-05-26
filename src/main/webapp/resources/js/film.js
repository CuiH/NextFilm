/**
 * Created by CuiH on 2016/5/26.
 */
$(document).ready(function() {
    $('select.dropdown').dropdown();

    $("#add_director").click(function() {
        $('.ui.modal').addClass("is-director");
        $('.ui.modal').removeClass("is-actor");
        $('.ui.modal').modal('show');
    });

    $("#add_actor").click(function() {
        $('.ui.modal').addClass("is-actor");
        $('.ui.modal').removeClass("is-director");
        $('.ui.modal').modal('show');
    });

    function checkDuplication(type, id) {
        var list = $("#"+ type + "-field").children("a");
        for (var i = 0; i < list.length; i++) {
            if (id == $(list[i]).attr(type + "-id")) return true;
        }

        return false;
    };

    $("#actor_searcher").on("input",function(){
        if ($(this).val() == "" || $(this).val() == " " ) return;

        $("#searcher-div").addClass("loading");

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "/find_actor?name="+$(this).val(),
            success: function(data) {
                $("#searcher-div").removeClass("loading");

                console.log(data);
                data = JSON.parse(data);
                if (data["result"] == "success") {
                    $("#search_results").text("");

                    var tem = data["actors"];
                    for (var i = 0; i < tem.length; i++) {
                        var str =     '<div class="card">' +
                                        '<div class="blurring dimmable image">' +
                                          '<div class="ui inverted dimmer">' +
                                            '<div class="content">' +
                                              '<div class="center">' +
                                                '<button class="ui primary button add-actor" ' + 'actor-id="' + tem[i]["id"] + '" actor-name="' + tem[i]["name"] + '">add</button>' +
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
                    }

                    setTimeout("$('.ui.modal').modal('refresh');", 10);

                    $('.special.cards .image').dimmer({on: 'hover'});

                    $('button.add-actor').click(function() {
                        $('.ui.modal').modal('hide');

                        if ($('.ui.modal').hasClass("is-actor")) {
                            if (checkDuplication("actor", $(this).attr("actor-id"))) {
                                alert("请勿重复添加");
                                return;
                            }

                            var str = '<a class="ui label" ' + 'actor-id="' + $(this).attr("actor-id") + '">' +
                                         $(this).attr("actor-name") +
                                         '<i id="actor' + $(this).attr("actor-id") +  '" class="delete icon"></i>' +
                                      '</a>';

                            $('#actor-field').append(str);

                            $('i#actor' + $(this).attr("actor-id")).click(function () {
                                $(this).parent().remove();
                            });
                        } else if ($('.ui.modal').hasClass("is-director")) {
                            if (checkDuplication("director", $(this).attr("actor-id"))) {
                                alert("请勿重复添加");
                                return;
                            }

                            var str = '<a class="ui label" ' + 'director-id="' + $(this).attr("actor-id") + '">' +
                                        $(this).attr("actor-name") +
                                        '<i id="director' + $(this).attr("actor-id") +  '" class="delete icon"></i>' +
                                      '</a>';

                            $('#director-field').append(str);

                            $('i#director' + $(this).attr("actor-id")).click(function () {
                                $(this).parent().remove();
                            });
                        }
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
});
