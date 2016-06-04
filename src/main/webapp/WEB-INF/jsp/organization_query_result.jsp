<%@ page import="com.jackie.model.Organization" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/4/5
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<table width="100%" border="1">
    <tr style="background-color:#EEEEEE;">
        <td>查询结果:&nbsp学校${unitName1}${result==null ?"不":""}是${unitName2}的子校</td>
    </tr>

    <tr style="background-color:#EEEEEE;">
        <td>${result==null ?"":"子校详细信息(json字串格式)如下："}</td>
    </tr>
    <tr style="background-color:#ADD8E6;">
        <td>${result}</td>
    </tr>

</table>
<script>
    <%--$(function(){--%>
    <%--alert(${result});--%>
    <%--})--%>
</script>
</body>
</html>
