$('#register').registerPanel({
    logo: {
        // logoImgSrc: './images/login/logo.png',
        textImgSrc: '欢迎注册',
        rightText: '已有账号？请登录',
        rightTextSrc: './login.html'
    },
    user: [
        {
            label: '用户名',
            placeholder: '您的账号和登录名',
            tip: '支持中文、字母、数字、"-"、"_"的组合，4-20个字符',
            isShow: true,
            inputId: 'account',
            type: 'text'
        },
        {
            label: '设置密码',
            placeholder: '请输入密码',
            tip: '建议使用字母、数字和符号两种及以上的组合，6-20个字符',
            isShow: true,
            inputId: 'password',
            type: 'password'
        },
        {
            label: '确认密码',
            placeholder: '请再次输入密码',
            tip: '请再次输入密码',
            isShow: true,
            inputId: 'ackPassword',
            type: 'password'              
        },
        {
            label: '手机号',
            placeholder: '请输入手机号',
            isShow: true,
            inputId: 'phoneNum',
            type: 'text'                 
        },
        {
            label: '邮箱',
            placeholder: '建议使用常用邮箱',
            tip: '您可以用该邮箱登录和找回密码',
            isShow: true,
            inputId: 'email',
            type: 'text'                 
        },
    ],
    submitBtnText: '立即注册',
    submitFuc: function (data) {
        if (data.password == data.ackPassword) {
            delete data.ackPassword;
            ServerUtil.api('net-change-web/', 'user-save', data, function (data) {
                
            });
        }
    }
});