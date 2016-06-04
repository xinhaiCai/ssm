<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/5/19
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页首</title>
    <link rel='stylesheet' href='/ssm/webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
    <script type='text/javascript' src='/ssm/webjars/jquery/1.11.1/jquery.min.js'></script>
    <script type='text/javascript' src='/ssm/webjars/bootstrap/3.3.6/js/bootstrap.min.js'></script>
</head>
<body>
<div id="header">
    <ul class="nav nav-tabs">
        <li><a href="/ssm/index.jsp">首页</a></li>
        <li><a href="/ssm/organization/query">查学校关系</a></li>
        <li><a href="/ssm/user/chart">用户统计</a></li>
        <li><a href="/ssm/product">文件上传</a></li>
        <form id="login_form" action="login" style="float: right;vertical-align:middle;">
            用户名：<input id="user_name" name="user_name" type="text"/>
            密码：<input id="user_pwd" name="user_pwd" type="password"/>
            <button id="login_button" type="button">登陆</button>
        </form>
    </ul>

</div>
<script>
    $(function () {
        $.ajax("http://localhost:8080/ssm/check", {
            type: "get",
            dataType: 'json',
            success: function (data) {
                $("#header form").html("欢迎您," + data);
                if (data != null && data != "") {
                    $("#header form").html("欢迎您," + data);
                }
//                alert(document.cookie.toString());
            }
        });

        $("#login_button").bind("click", function () {
            $.ajax("http://localhost:8080/ssm/login",
                    {
                        type: "post",
                        data: "user_name=" + $("#user_name").val() + "&user_pwd=" + $("#user_pwd").val(),
                        success: function (data) {
//                            alert(data);
                            //alert($("#user_name").val()+$("#user_pwd").val());
                            $("#header form").html("欢迎您," + data);
                        }
                    });
        })
    });
</script>
</body>
</html>
