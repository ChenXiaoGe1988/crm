<%--
  Created by IntelliJ IDEA.
  User: ychen
  Date: 20-11-16
  Time: 下午12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>

$.ajax({
    url: "",
    data: {

    },
    type: "post",
    dataType: "json",
    success: function (data) {

    }
    })

//创建时间
String createTime = DateTimeUtil.getSysTime();
//创建人
String createBy = ((User)request.getSession().getAttribute("user")).getName();
</body>
</html>
