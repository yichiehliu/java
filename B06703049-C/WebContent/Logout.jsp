<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
<%

%>
    <h1><%= session.getAttribute("useraccount") %>，歡迎登入105人力公司網站!</h1>
    <p> 姓名 :<%= session.getAttribute("name") %> </p>
    <p> 地址 :<%= session.getAttribute("address") %> </p> 
    <p> 電話 :<%= session.getAttribute("phonenumber") %> </p>
    <p> 學歷 :<%= session.getAttribute("education") %> </p>
    <a href='Login.jsp' name ="page" value="tologout">登出</a><br>
</body>
</html>