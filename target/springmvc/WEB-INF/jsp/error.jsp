<%--
  Created by IntelliJ IDEA.
  User: pmj
  Date: 2019/11/7
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--开启为了表达式--%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<%--也就是说放这开麦你放熊自己的内部调转的页面,比较安全
不配值默认的是,  exception,配置就giant了名字,没有配置就是默认额小写.可以试试?
--%>
<h1>出现异常${exception}</h1>
</body>
</html>
