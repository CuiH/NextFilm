/**
 * Created by cuihao on 2016/5/27.
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
            city: {
                identifier  : 'city',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please select a city'
                    }
                ]
            },
            address: {
                identifier  : 'address',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a address'
                    }
                ]
            },
            phone: {
                identifier  : 'phone',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a phone num'
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
            description: {
                identifier  : 'description',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a description'
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
                url: "/add_cinema",
                data: $('#cinema_form').serialize(),
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
