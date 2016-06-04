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
    <title>组织关系查询</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="body" style="clear: both;border: #74b1ff" title="查A校是否是B校的子校">
    <form title="查A校是否是B校的子校" align="center" action="querySchool" method="get">
        <tr>
            <td>请输入学校名称A:<input id="unitName1" name="unitName1" type="text"></td>
            <td> 请输入学校名称B:<input id="unitName2" name="unitName2" type="text"></td>
            <td>
                <button id="submit" type="submit">查询</button>
            </td>
        </tr>
    </form>
</div>
</body>
</html>
