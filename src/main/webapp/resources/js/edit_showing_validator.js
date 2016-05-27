/**
 * Created by cuihao on 2016/5/27.
 */
$(document).ready(function() {
    $('.ui.form').form({
        fields: {
            startTime: {
                identifier  : 'startTime',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a start time'
                    }
                ]
            },
            endTime: {
                identifier  : 'endTime',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a end time'
                    }
                ]
            },
            priceManual: {
                identifier  : 'priceManual',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a price'
                    },
                    {
                        type   : 'number',
                        prompt : 'Please enter a number'
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
                url: "/edit_showing",
                data: $('#showing_form').serialize(),
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
