/**
 * Created by cuihao on 2016/5/27.
 */
$(document).ready(function() {
    $('.ui.form').form({
        fields: {
            username: {
                identifier: 'username',
                rules: [
                    {
                        type: 'empty',
                        prompt: 'Please enter a username'
                    }
                ]
            },
            password: {
                identifier: 'password',
                rules: [
                    {
                        type: 'empty',
                        prompt: 'Please enter a passwordl'
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
                url: "/login",
                data: $("#login_form").serialize(),
                success: function(data) {
                    data = JSON.parse(data);
                    if (data["result"] == "success") {
                        $("#submit_form").text("Success");

                        window.location.replace("/home");
                    } else {
                        $("#submit_form").text("Submit");
                        $("#submit_form").removeClass("disabled");

                        $("#login_error").text(data["reason"]);
                        $("#login_error").removeClass("not-show");
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
