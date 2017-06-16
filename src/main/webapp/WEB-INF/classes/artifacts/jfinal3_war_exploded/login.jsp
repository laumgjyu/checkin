<%@ page import="javax.print.attribute.standard.RequestingUserName" %><%--
  Created by IntelliJ IDEA.
  User: lmy
  Date: 2017/6/11
  Time: 9:11
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
<br>
<%
    String username = (String)request.getAttribute("username");
    if (username==null)
        username = "";

    String message = (String) request.getAttribute("message");
    String  usernameMsg = (String) request.getAttribute("usernameMsg");
    String passwordMsg = (String) request.getAttribute("passwordMsg");

    if (usernameMsg != null && !usernameMsg.trim().equals(""))
        out.print(usernameMsg);

    if ((usernameMsg==null||usernameMsg.trim().equals(""))&&(passwordMsg != null && !passwordMsg.trim().equals("")))
        out.print(passwordMsg);

    if (message!=null)
        out.print(message);

%>
<br>
<form action="/loginSubmmit" method="post">
用户名：<input type="text" name="username" value="<%=username%>">
<br>
密 码：<input type="password" name="password">
<br>
<input type="submit" >
</form>
</body>
</html>
