<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/5/20
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<jsp:include page="header.jsp"/>
error<br/>
<h6></h6>
<script>
    $(function () {
        //设定倒数秒数
        var t = 5;
        setInterval(function () {
            if (t == 0) {
                location.href = "http://localhost:8080/ssm";
            }
            $("h6").html(t + "秒后跳转至首页");
            t--;
        }, 1000);
    });
</script>
</body>
</html>
