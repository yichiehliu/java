<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register Page 2</title>
</head>
<body>
 	<h1>歡迎使用105人力公司網站來登入您的個人資料-Page2</h1>
    <p></p>
	<div style='color: rgb(255, 0, 0);'>
	<%
	if(request.getAttribute("error_add") != null){
		%>
		<p><%= request.getAttribute("error_add") %> </p>
	<%
	}
	%>
	
	</div>
    <form name="RegisterForm_2" method="post" action="AddNewUser">
        <label for="accountname">新增帳號名稱：</label>
        <!-- default size is 20 -->
        <input type="text" id="useraccount" name="useraccount" required=""></p>

        <label for="password">新增帳號密碼：</label>
        <input type="password" id="password" name="password" required=""></p>

        <input type="reset" value="重設">
        <input type="submit" name="page" value="送出">
    </form>
</body>
</html>