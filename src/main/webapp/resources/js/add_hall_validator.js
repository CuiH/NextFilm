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
            type: {
                identifier  : 'type',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please select a type'
                    }
                ]
            },
            rowNum: {
                identifier  : 'rowNum',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a row num'
                    },
                    {
                        type   : 'integer',
                        prompt : 'Please enter a integer'
                    }
                ]
            },
            columnNum: {
                identifier  : 'columnNum',
                rules: [
                    {
                        type   : 'empty',
                        prompt : 'Please enter a column num'
                    },
                    {
                        type   : 'integer',
                        prompt : 'Please enter a integer'
                    }
                ]
            }
        },
        inline : true,
        on     : 'blur',
        onSuccess: function (event, fields) {
            $.ajax({
                type: "POST",
                dataType: "html",
                url: "/add_hall",
                data: $('#hall_form').serialize(),
                success: function(data) {
                    data = JSON.parse(data);
                    if (data["result"] == "success") {
                        $("#model_success").modal('show');
                    } else {
                        $("#model_fail .content").html("<p>" + data["reason"] + "</p>");
                        $("#model_fail").model('show');
                    }
                },
                error: function() {
                    alert("error");
                }
            });
        }
    });
});
