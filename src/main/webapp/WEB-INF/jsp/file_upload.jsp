<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/3/13
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div>
    <form action="" enctype="multipart/form-data" method="post">
        <input type="file" name="fieldName"/>
        <input type="submit" value="Upload">
    </form>
</div>
</body>
</html>
