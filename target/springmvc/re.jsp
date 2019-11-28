<%--
  Created by IntelliJ IDEA.
  User: pmj
<%--
  Created by IntelliJ IDEA.
  User: pmj
  Date: 2019/11/6
  Time: 17:36
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
            $("#btn").click(function () {
                $.ajax({
                    url:"regist",
                    type:"get",
                    data:{
                        "name":$("#name").val(),
                        "psw": $("#psw").val()
                    },
                    success:function (data) {
                      //  alert(data.toString())
                        if(data=="fail regist"){
                            alert("成功");
                        }else if(data=="success regist"){
                           alert("失败");
                        }else{
                            alert("其他")
                        }
                       // alert(data)
                    }
                })
            })
        })


    </script>
</head>
<body>
<%--<a href="springmvc/login">登录</a><br>--%>
<input  type="text" id="name"><br>
<input type="text" id="psw"><br>
<button id="btn">显示</button>
</body>
</html>
