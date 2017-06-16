<%--
  Created by IntelliJ IDEA.
  User: lmy
  Date: 2017/6/11
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //absolute path
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/login?admin=true">admin登陆</a>
<a href="/login?admin=false">用户登录</a>
<a href="/register">用户注册</a>
</body>
</html>
