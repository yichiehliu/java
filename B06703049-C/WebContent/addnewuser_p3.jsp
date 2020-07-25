<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, java.text.*, mvc.User"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register Finished</title>
</head>
<body>
    <h1>歡迎使用105人力公司網站來登入您的個人資料-Page3</h1>
    <p></p>
    <h1>新增資料完成</h1>
    <p> 帳戶名稱 :<%= session.getAttribute("useraccount") %> </p>
    <p> 帳戶密碼 :<%= session.getAttribute("password") %> </p>
    <p> 姓名 :<%= session.getAttribute("name") %> </p>
    <p> 地址 :<%= session.getAttribute("address") %> </p> 
    <p> 電話 :<%= session.getAttribute("phonenumber") %> </p>
    <p> 學歷 :<%= session.getAttribute("education") %> </p>
    
    

    <a href='Login.jsp' name="page" value="tologout">請回到首頁進行登入動作!</a><br>


</body>
</html>