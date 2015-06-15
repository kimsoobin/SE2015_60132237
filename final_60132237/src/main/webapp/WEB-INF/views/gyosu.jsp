<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>교수 페이지</h1>

<a href="${pageContext.request.contextPath}/ProfController/createClassPage">1. 강좌개설</a></br>
<a href="${pageContext.request.contextPath}/ProController/gradegrantpage">2. 성적부여</a></br>
</p>
<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
</body>
</html>