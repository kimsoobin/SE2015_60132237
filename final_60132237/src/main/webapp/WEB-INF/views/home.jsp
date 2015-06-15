<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	학사관리 시스템  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<form action="loginController/create" method="post">
		<input type="submit" value="데이터베이스 생성">
	</form>
	<form action="loginController/drop" method="post">
		<input type="submit" value="데이터베이스 삭제">
	</form> </br>
	
	1. 로그인 </br>
	<form action="loginController/login.do" method="post">
		<input type="text" name="userID">
		<input type="password" name="userPassword"> <br/>
		<input type="submit" value="로그인">
	</form> </br>
	2. <a href="${pageContext.request.contextPath}/UserController/createAccount">회원가입</a>

</body>
</html>
