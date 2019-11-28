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
                url:"sh",
                type:"post",
                data:{
                    "name":$("#name").val(),
                    "age": $("#age").val()
                },
                success:function (data) {
                 if(data==0){
                     alert("成功");
                 }else if(data==1){
                     alert("失败");

                 }else{
                     alert("其他");
                 }
                }


            })
        })


    })


    </script>
</head>
<body>
<input  type="text" id="name"><br>
<input type="text" id="age"><br>
<button id="btn">显示</button>
</body>
</html>
