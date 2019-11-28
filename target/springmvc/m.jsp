<%--
  Created by IntelliJ IDEA.
  User: pmj
  Date: 2019/11/6
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url:"list",
                type:"post",
                success:function (data) {
                    for (var i=0;i<data.length;i++) {
                        //拼在boday里面
                        $("body").append("<h1>"+data[i].name+","+data[i].age +"</h1>")
                    }
                }

            })
        })

    </script>
</head>
<body>

<%-- 这个是用form发送数据,,,最候函数问题需要点提交..
<form action="show" >
    <input name="name" value="jj">
    <input name="age" value="23">
    <input type="submit" value="提交">

</form>

--%>

</body>
</html>
