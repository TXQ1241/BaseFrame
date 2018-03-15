$.widget("panel.registerPanel", {
    options: {
        logo: {
            logoImgSrc: './images/login/logo.png',
            textImgSrc: './images/login/l-icon.png',
            rightText: '已有账号？请登录',
            rightTextSrc: ''
        },
        user: [
            {
                label: '用户名',
                placeholder: '您的账号和登录名',
                tip: '支持中文、字母、数字、"-"、"_"的组合，4-20个字符',
                isShow: true,
                inputId: 'username',
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
                label: '邮箱验证',
                placeholder: '建议使用常用邮箱',
                tip: '完成验证后，您可以用该邮箱登录和找回密码',
                isShow: true,
                inputId: 'email',
                type: 'text'                 
            },
        ],
        submitBtnText: '立即注册',
        submitFuc: function (data) {

        },
        rightContent: [
            {
                imgSrc: '',
                text: '企业用户注册',
                src: 'javascript:void(0)'
            }
        ]
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
        this._createMainBox();
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
        this._createUserBox();
        this._createRightBox();
    },
    _createUserBox: function () {
        this.userBox = $('<div class="user pull-left"></div>').appendTo(this.mainContent);
        this.options.user.forEach(function (value) {
            this.createInput(value).appendTo(this.userBox);
        }, this);
        this.createSubmit();
    },
    createInput: function (data) {
        var div = $('<div class="input-box"></div>');
        var label = $('<span class="label"></span>').appendTo(div);
        label.text(data.label);
        var input = $('<input>').appendTo(div);
        input[0].placeholder = data.placeholder;
        input[0].id = data.inputId;
        input[0].type = data.type;
        if (data.tip) {
            var tip = $('<div class="tip"></div>').appendTo(div);
            var iconfont = $('<span class="iconfont icon-username"></span>').appendTo(tip);
            var text = $('<p></p>').appendTo(tip);
            text.text(data.tip);
            tip.hide();
            input.on('focus', function () {
                tip.show();
            });
            input.on('blur', function () {
                tip.hide();
            });
        }
        if (!data.isShow) {
            div.hide();
        }
        return div;
    },
    createSubmit: function () {
        var self = this;
        this.submitBtn = $('<button class="submit-btn"></button>').appendTo(this.userBox);
        this.submitBtn.text(this.options.submitBtnText);
        this.submitBtn.on('click', function () {
            var data = {};
            self.options.user.forEach(function (value) {
                var val = $('#' + value.inputId).val();
                data[value.inputId] = val;
            });
            self.options.submitFuc(data);
        });
    },
    _createRightBox: function () {
        this.rightBox = $('<div class="right-box pull-left"></div>').appendTo(this.mainContent);
        if (this.options.rightContent) {
            this.options.rightContent.forEach(function (value) {
                this.createRightContent(value);
            }, this);
        }
    },
    createRightContent: function (data) {
        var div = $('<div class="other"></div>').appendTo(this.rightBox);
        var a = $('<a></a>').appendTo(div);
        a[0].href = data.src;
        var img = $('<img>').appendTo(a);
        img[0].src = data.imgSrc;
        var span = $('<span></span>').appendTo(a);
        span.text(data.text);
    },
});