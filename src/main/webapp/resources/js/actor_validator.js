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
        on     : 'blur'
    });
});