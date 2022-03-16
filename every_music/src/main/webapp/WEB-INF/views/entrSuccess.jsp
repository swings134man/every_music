<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getAttribute("value") %></title>
</head>
<body>
<h1><%= request.getAttribute("value") %></h1> <br>
<a href="http://localhost:8889/everymusic/index.jsp"> <button>홈으로</button> </a>
</body>
</html>