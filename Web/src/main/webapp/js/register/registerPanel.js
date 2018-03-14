$.widget("panel.registerPanel", {
    options: {
        logo: {
            logoImgSrc: './images/login/logo.png',
            textImgSrc: './images/login/l-icon.png',
            rightText: '已有账号？请登录',
            rightTextSrc: ''
        },
        user: {
            isTab: true,
            leftText: '扫码登录',
            rightText: '账户登录'
        },
        userNamePlaceholder: '用户名/邮箱',
        passwordPlaceholder: '密码',
        forgetPwdText: '忘记密码',
        forgetPwdSrc: 'javascript:void(0)',
        submitFuc: function (username, password) {

        }
    },
    _create: function () {
        var self = this;
        var el = this.element;
        el.addClass('register-panel');
        this._createLogoContentBox();
    },
    _createLogoContentBox: function () {
        var el = this.element;
        this.logoContentBox = $('<div class="logo-content"></div>').appendTo(el);
        this._createLogo();
        this._createLine();
    },
    _createLogo: function () {
        this.logoBox = $('<div class="logo-box clearfix"></div>').appendTo(this.logoContentBox);
        var a = $('<a></a>').appendTo(this.logoBox);
        var img = $('<img>').appendTo(a);
        img[0].src = this.options.logo.logoImgSrc;
        var textImgSrc = this.options.logo.textImgSrc;
        if (textImgSrc) {
            var textImgBox = $('<span class="text-img"></span>').appendTo(this.logoBox);
            if (textImgSrc.indexOf('/') >= 0) {
                var textImg = $('<img>').appendTo(textImgBox);
                textImg[0].src = textImgSrc;
            } else {
                var text = $('<span></span>').appendTo(textImgBox);
                text.text(this.options.logo.textImgSrc);
            }
        }

        if (this.options.logo.rightText) {
            var rightText = $('<a class="pull-right right-text"></a>').appendTo(this.logoBox);
            rightText.text(this.options.logo.rightText);
            if (this.options.logo.rightTextSrc) {
                rightText[0].href = this.options.logo.rightTextSrc;
            }
        }
    },
    _createLine: function () {
        var el = this.element;
        var line = $('<div class="line"></div>').appendTo(el);
    },
    _createMainBox: function () {
        var el = this.element;
        this.mainBox = $('<div class="main-box"></div>').appendTo(el);
        this._createMainContent();
    },
    _createMainContent: function () { 
        this.mainContent = $('<div class="main-content clearfix"></div>').appendTo(this.mainBox);
        this.userBox = $('<div class="user pull-left"></div>').appendTo(this.mainContent);
        this.rightBox = $('<div class="right-box pull-left"></div>').appendTo(this.mainContent);
    },
    
});