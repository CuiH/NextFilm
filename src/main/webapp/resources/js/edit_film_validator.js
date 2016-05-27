/**
 * Created by cuihao on 2016/5/26.
 */
$(document).ready(function() {
    $('.ui.form').form({
        fields: {
            name: {
                identifier  : 'name',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a name'
                    }
                ]
            },
            brief: {
                identifier  : 'brief',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a brief'
                    }
                ]
            },
            language: {
                identifier  : 'language',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a language'
                    }
                ]
            },
            length: {
                identifier  : 'length',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a length'
                    }
                ]
            },
            onDate: {
                identifier  : 'onDate',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a on date'
                    }
                ]
            },
            imageUrl: {
                identifier  : 'imageUrl',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a image url'
                    },
                    {
                        type   : 'url',
                        prompt : 'Please enter a valid url'
                    }
                ]
            },
            category: {
                identifier  : 'category',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please select a category'
                    }
                ]
            },
            type: {
                identifier  : 'type',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please select a type'
                    }
                ]
            }
        },
        inline : true,
        on     : 'blur',
        onSuccess: function (event, fields) {
            if (event != undefined) {
                event.preventDefault();
            }

            var str = "";

            var d_list = $("#director-field").children("a");
            for (var i = 0; i < d_list.length; i++) {
                str += '&directors=' + $(d_list[i]).attr("director-id");
            }

            var a_list = $("#actor-field").children("a");
            for (var i = 0; i < a_list.length; i++) {
                str += '&actors=' + $(a_list[i]).attr("actor-id");
            }

            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/edit_film",
                data: $('#film_form').serialize() + str,
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
        }
    });
});