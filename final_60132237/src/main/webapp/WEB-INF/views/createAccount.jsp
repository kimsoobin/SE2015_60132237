<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	회원가입 페이지
</h1>

	<form action="${pageContext.request.contextPath}/UserController/dataInsert"
		method="post">
		id<input type="text" name="id"> <br/>
		name<input type="text" name="name"> <br/>
		pw<input type="text" name="pw"> <br/>
		pos
		<input type="radio" name="pos" value="stu" checked> 학생 
		<input type="radio" name="pos" value="prof"> 교수 </br>
		<input type="submit" value="가입 신청하기">
	</form> </br>
	<a href="${pageContext.request.contextPath}"> 돌아가기 </a>

</body>
</html>
