//JavaScript代码区域
var $;
layui.use(['table'], function () {
    var table = layui.table;
    $ = layui.$;
    var laytpl = layui.laytpl;
    var element = layui.element;
    var tableTitle = {
        account: '账号',
        password: '密码',
        userName: '用户名',
        age: '年龄',
        email: '邮箱',
        profession: '职业',
        description: '描述',
        qqNum: 'qq号',
        birthday: '生日',
        phoneNum: '手机号'
    };
    //第一个实例
    table.render({
        elem: '#datalist',
        // height: 315,
        url: 'http://localhost:8080/user-manager/user/userList',
        method: 'post',
        response: {
            statusCode: 1,
            dataName: 'datalist'
        },
        request: {
            pageName: 'pageNum', //页码的参数名称，默认：page
            limitName: 'pageSize', //每页数据量的参数名，默认：limit
            page: 0,
            limit: 10
        },
        page: {
            limits: [5, 10, 20, 50, 100]
        },
        where: {
            userType: 2
        },
        id: 'poemUsers',
        done: function (res) {
            
        },
        cols: [
            [ //表头
                {
                    field: 'account',
                    title: '账号',
                    // width: 150
                }, {
                    field: 'password',
                    title: '密码',
                    width: 80
                }, {
                    field: 'userName',
                    title: '用户名',
                    // width: 150
                }, {
                    field: 'age',
                    title: '年龄',
                    // width: 177,
                    sort: true,
                }, {
                    field: 'email',
                    title: '邮箱',
                    // width: 200
                }, {
                    field: 'profession',
                    title: '职业',
                    // width: 200
                }, {
                    field: 'description',
                    title: '描述',
                    // width: 200
                }, {
                    field: 'qqNum',
                    title: 'qq号',
                    sort: true,
                    // width: 200
                }, {
                    field: 'birthday',
                    title: '生日',
                    sort: true,
                    // width: 200
                }, {
                    field: 'phoneNum',
                    title: '手机号',
                    sort: true,
                    // width: 200
                }, {
                    fixed: 'right',
                    title: '操作',
                    minWidth: 163,
                    // width: 178,
                    align: 'center',
                    toolbar: '#tableBtn'
                }
            ]
        ]
    });
    //表格重载函数
    function tableReload(conditions) {
        var obj = {
            page: {
                curr: 1 //重新从第 1 页开始
            }
        };
        if (conditions) {
            obj.where = conditions;
        }
        table.reload('poemUsers', obj);
    }
    //查看、编辑、删除按钮功能
    table.on('tool(tableBtn)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            var userList = [];
            for (var attr in data) {
                if (tableTitle[attr]) {
                    var dataObj = {};
                    dataObj.title = tableTitle[attr];
                    dataObj.val = data[attr] || '';
                    userList.push(dataObj);
                }
            }
            var getTpl = tableDetail.innerHTML,
                view = document.getElementById('tableBox');
            laytpl(getTpl).render(userList, function (html) {
                view.innerHTML = html;
            });
            layer.open({
                title: '用户详情',
                type: 1,
                skin: 'layui-layer-molv',
                shadeClose: true,
                resize: false,
                // area: ['500px', '300px'],
                content: $('#tableBox')
            });
        } else if (obj.event === 'edit') {
            var userList = [];
            for (var attr in data) {
                if (tableTitle[attr]) {
                    var dataObj = {};
                    dataObj.title = tableTitle[attr];
                    dataObj.val = data[attr] || '';
                    dataObj.field = attr;
                    dataObj.className = 'table-edit-input';
                    userList.push(dataObj);
                }
            }
            var getTpl = tableEdit.innerHTML,
                view = document.getElementById('tableBox');
            laytpl(getTpl).render(userList, function (html) {
                view.innerHTML = html;
            });
            layer.open({
                title: '编辑',
                type: 1,
                skin: 'layui-layer-molv layer-btn-class',
                resize: false,
                btn: ['确定', '取消'],
                yes: function (index, layero) {
                    //按钮【按钮一】的回调
                    $('.table-edit-input').each(function (index, val) {
                        data[val.dataset.type] = $(val).val();
                    });
                    ServerUtil.api('user-manager/user/', 'save', data, function () {
                        //同步更新缓存对应的值
                        obj.update(data);
                        // tableReload();
                        layer.close(index);
                    });
                },
                btn2: function (index, layero) {
                    //按钮【按钮二】的回调
                    layer.close(index);
                },
                content: $('#tableBox')
            });
        }
    });

    //按条件搜索
    $('#searchBtn').on('click', function () {
        // var type = $(this).data('type');
        var obj = {};
        var account = $('#accountReload').val();
        var userName = $('#userNameReload').val();
        var age = $('#ageReload').val();
        obj.account = account;
        obj.userName = userName;
        obj.age = age;
        obj.userType = 2;
        tableReload(obj);
    });

    //菜单跳转
    $('#systemUser').on('click', function () {
        window.location.href = window.location.origin + window.location.pathname + '?userType=1';
    });
});