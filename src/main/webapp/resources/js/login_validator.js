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

            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/login",
                data: $("#login_form").serialize(),
                success: function(data) {
                    data = JSON.parse(data);
                    if (data["result"] == "success") {
                        window.location.replace("/home");
                    } else {
                        $("#login_error").text(data["reason"]);
                        $("#login_error").removeClass("not-show");
                    }
                },
                error: function() {
                    alert("error");
                }
            });
        }
    });
});
