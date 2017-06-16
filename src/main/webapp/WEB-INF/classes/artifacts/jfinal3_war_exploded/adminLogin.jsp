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
    String adminname = (String)request.getAttribute("adminname");
    if (adminname==null)
        adminname = "";

    String message = (String) request.getAttribute("message");
    String adminnameMsg = (String) request.getAttribute("adminnameMsg");
    String adminpasswordMsg = (String) request.getAttribute("adminpasswordMsg");

    if (adminnameMsg != null && !adminnameMsg.trim().equals(""))
        out.print(adminnameMsg);

    if ((adminnameMsg==null||adminnameMsg.trim().equals(""))&&(adminpasswordMsg != null && !adminpasswordMsg.trim().equals("")))
        out.print(adminpasswordMsg);

    if (message!=null)
        out.print(message);

%>
<br>
<form action="/loginSubmmit" method="post">
    <input type="hidden" name="adminLogin" value="true">
    用户名：<input type="text" name="adminname" value="<%=adminname%>">
    <br>
    密 码：<input type="password" name="adminpassword">
    <br>
    <input type="submit" >
</form>
</body>
</html>
