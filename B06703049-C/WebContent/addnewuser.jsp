<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Register Page 1</title>
</head>

<body>
    <h1>歡迎使用105人力公司網站來登入您的個人資料-Page1</h1>
    <p></p>
    <form name="RegisterForm" method="post" action="AddNewUser">
        <label for="username">姓名：</label>
        <!-- default size is 20 -->
        <input type="text" id="username" name="username"></p>

        <label for="address">住址：</label>
        <input type="text" id="address" name="address" size="20"></p>


        <label for="phonenumber">電話：09xx-xxx-xxx</label><br>
        <input type="tel" id="phonenumber" name="phonenumber" maxlength="12"></p>

        <!-- label bind with input 顯示選項 ， 如果要用一個選項組，語意上會用field set + legend -->
        <label for="education">學歷：</label>
        <input type="radio" id="education" name="education" value="高中職">高中職
        <input type="radio" id="education" name="education" value="五專">五專
        <input type="radio" id="education" name="education" value="四技二專">四技二專
        <input type="radio" id="education" name="education" value="大學">大學
        <input type="radio" id="education" name="education" value="研究所">研究所</p>

        <input type="reset" value="重設">
        <input type="submit" name="page" value="下一頁">
    </form>

</body>

</html>