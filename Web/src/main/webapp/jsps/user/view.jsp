<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="/common/common.jsp" %>
<html>
<body>
<h2>用户列表</h2>
<table>
    <thead>
    <tr>
        <th><input type="checkbox" name="ids"/></th>
        <th>帐号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>邮箱</th>
        <th>描述</th>
        <th>qq号</th>
        <th>电话号码</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="rowdata" items="${userList }" varStatus="status">
        <tr>
            <th><input type="checkbox" name="ids" value="${rowdata.id }"/></th>
            <th>${rowdata.account }</th>
            <th>${rowdata.name }</th>
            <th>${rowdata.age }</th>
            <th>${rowdata.email }</th>
            <th>${rowdata.description }</th>
            <th>${rowdata.qqNum }</th>
            <th>${rowdata.phoneNum }</th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>