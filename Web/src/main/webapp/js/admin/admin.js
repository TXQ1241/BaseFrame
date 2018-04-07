//JavaScript代码区域
layui.config({
    // debug: true //用于开启调试模式，默认false，如果设为true，则JS模块的节点会保留在页面
}).use(['table'], function () {
    var table = layui.table;
    var $ = layui.$;
    var laytpl = layui.laytpl;
    var tableTitle = {
        id: 'ID',
        account: '账号',
        password: '密码',
        userName: '用户名',
        age: '年龄',
        email: '邮箱'
    };
    //第一个实例
    table.render({
        elem: '#datalist',
        height: 315,
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
            limits: [10]
        },
        id: 'poemUsers',
        done: function (res) {
            console.log(res);
        },
        cols: [
            [ //表头
                {type:'checkbox'},
                {
                    field: 'id',
                    title: 'ID',
                    width: 150,
                    sort: true,
                }, {
                    field: 'account',
                    title: '账号',
                    width: 150
                }, {
                    field: 'password',
                    title: '密码',
                    width: 80
                }, {
                    field: 'userName',
                    title: '用户名',
                    width: 150
                }, {
                    field: 'age',
                    title: '年龄',
                    width: 177
                }, {
                    field: 'email',
                    title: '邮箱',
                    width: 200
                }, {
                    fixed: 'right',
                    width: 178,
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
                    var obj = {};
                    obj.title = tableTitle[attr];
                    obj.val = data[attr] || '';
                    userList.push(obj);
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
        } else if (obj.event === 'del') {
            layer.confirm('真的删除么', function (index) {
                ServerUtil.api('delete', {
                    ids: data.id
                }, function () {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    tableReload();
                });
            });
        } else if (obj.event === 'edit') {
            //同步更新缓存对应的值
            obj.update({
                username: '123',
                title: 'xxx'
            });
        }
    });

    //按条件搜索
    $('#accountReloadBtn').on('click', function () {
        // var type = $(this).data('type');
        var accountReload = $('#accountReload');
        tableReload({account: accountReload.val()});
    });
    $('#userNameReloadBtn').on('click', function () {
        // var type = $(this).data('type');
        var userNameReload = $('#userNameReload');
        tableReload({userName: userNameReload.val()});
    });
    $('#ageReloadBtn').on('click', function () {
        // var type = $(this).data('type');
        var ageReload = $('#ageReload');
        tableReload({age: ageReload.val()});
    });
    //批量删除
    $('#deleteUsers').on('click', function () {
        var checkStatus = table.checkStatus('poemUsers'); //获取复选框信息
        if (checkStatus.data.length == 0) {
            layer.confirm('请选择要删除的行');
            return;
        }
        var str = '确定删除这' + checkStatus.data.length + '条信息吗';
        layer.confirm(str, function (index) {
            var userIdsArr = [];
            checkStatus.data.forEach(function (val) {
                userIdsArr.push(val.id);
            });
            var userIdsStr = userIdsArr.join(',');
            ServerUtil.api('delete', {
                ids: userIdsStr
            }, function () {
                layer.close(index);
                tableReload();
            });
        });
    });
});