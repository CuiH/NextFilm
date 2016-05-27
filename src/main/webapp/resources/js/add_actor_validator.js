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

            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/add_actor",
                data: $('#actor_form').serialize(),
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
