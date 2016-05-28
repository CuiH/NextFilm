/**
 * Created by CuiH on 2016/5/26.
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
            imageUrl: {
                identifier  : 'imageUrl',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a image url'
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
            birthday: {
                identifier  : 'birthday',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a birthday'
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

            $("#submit_form").text("Loading");
            $("#submit_form").addClass("disabled");

            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/add_actor",
                data: $('#actor_form').serialize(),
                success: function(data) {
                    data = JSON.parse(data);
                    if (data["result"] == "success") {
                        $("#submit_form").text("Success");

                        $("#model_success").modal('show');
                    } else {
                        $("#submit_form").text("Submit");
                        $("#submit_form").removeClass("disabled");

                        $("#model_fail .content").html("<p>" + data["reason"] + "</p>");
                        $("#model_fail").modal('show');
                    }
                },
                error: function() {
                    $("#submit_form").text("Submit");
                    $("#submit_form").removeClass("disabled");

                    alert("error");
                }
            });
        }
    });
});
