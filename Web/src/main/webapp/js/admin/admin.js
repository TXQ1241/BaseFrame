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
        id: 'test1',
        done: function (res) {
            console.log(res);
        },
        cols: [
            [ //表头
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
            layer.confirm('真的删除行么', function (index) {
                ServerUtil.api('delete', {ids: data.id}, function () {
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
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
});