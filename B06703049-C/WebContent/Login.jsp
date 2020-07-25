<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, java.text.*, mvc.User"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Login in Page</title>
</head>

<body>
<h1>歡迎來到105人力公司，請輸入您的資料來登入:</h1>
  <div style='color: rgb(255, 0, 0);'>
<%
if(request.getAttribute("error") != null){
	%>
	<p><%= request.getAttribute("error") %> </p>
<%
}
%>

</div>
  <form action="Login" method="post">
    名稱：<input type="text" name="useraccount"><br>
    密碼：<input type="password" name="password"><br>
    <br>
    自動登入:<input type="checkbox" name="auto" value = "is">
    <a href='addnewuser.jsp'> 新使用者?</a><br>
    <input type="submit" value="登入">
  </form>
</body>

</html>