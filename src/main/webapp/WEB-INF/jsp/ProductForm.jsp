<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2016/5/10
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product Form</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css"/> ");
    </style>
</head>
<body>
<div id="global">
    <form:form commandName="product" action="save" method="post"
               enctype="multipart/form-data">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name:</label>
                <form:input path="name" id="name" cssErrorClass="error"/>
                <form:errors path="name" cssClass="error"/>
            </p>

            <p>
                <label for="description">Description:</label>
                <form:input path="description" id="descriptioin"/>
            </p>

            <p>
                <label for="price">Price:</label>
                <form:input path="price" id="price" cssErrorClass="error"/>
            </p>

            <p>
                <label for="images">Product Image:</label>
                <input type="file" id="images" name="images"/>


            </p>

            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Product">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
