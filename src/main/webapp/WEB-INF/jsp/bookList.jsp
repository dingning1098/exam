<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="styles/main.css" type="text/css" rel="stylesheet" />
<title>图书管理</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>图书管理</span></h2>
        <form action="${ctx}book/search" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>编号</th>
                <th>书名</th>
                <th>价格</th>
                <th>操作</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <th><input type="checkbox" name="ids" value="${book.id}"></th>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>
                    <a href="${ctx}book/delete?id=${book.id}" class="abtn">删除</a>
                    <a href="${ctx}book/update?id=${book.id}" class="abtn">编辑</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p style="color: red">${message}</p>
        <p>
            <a href="${ctx}book/add" class="abtn">添加</a>
            <input type="submit"  value="删除选择项" class="btn"/>
        </p>
    </form>
    </div>
</body>
</html>