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
                identifier  : 'brief',
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
        on     : 'blur'
    });
});