if (window.pageConfig == null) {
    window.pageConfig = {
        urlPrex: '',
    };
}
ServerUtil = {
    origin: function () {
        var u = window.location.origin;
        return u;
    },

    url: function () {
        var u = window.location.origin;
        u += pageConfig.urlPrex;
        if (!u.endsWith('/')) {
            u += '/';
        }
        return u;
    },

    api: function (method, data, success, error) {

        var url = ServerUtil.url() + 'user-manager/user/' + method;
        $.ajax({
            type: "post",
            contentType: 'application/json; charset=UTF-8',
            url: url,
            data: JSON.stringify(data),
            success: function (result) {
                if (result.error) {
                    if (error) {
                        error(result.error);
                    } else {
                        console.error(result.error);
                        ServerUtil.alert(result.error);
                    }
                } else {
                    success && success(result.value);
                }
            },
            error: function (a, b, c) {
                if (error) {
                    error(a, b, c);
                } else {
                    console.error(a.responseText);
                    ServerUtil.alert(result.error);
                }
            },
        })
    }
};