<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "kr.ac.mju.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1> 강좌 개설 화면</h1>
	<table style = "width:100%">
		<tr>
			<td>강좌번호</td>
			<td>과목명</td>
			<td>연도</td>
			<td>학년</td>
			<td>정원</td>
			<td>학점</td>
		</tr>
		<tr>
		<%User user = (User) session.getAttribute("user");%>
		<form action = "${pageContext.request.contextPath}/ProfController/createClass" method="post">
			<td><input type="text" name = "id"></td>
			<input type="hidden" name = "prof_name" value = <%=user.getName()%>>
			<td><input type="text" name = "name"></td>
			<td><input type="text" name = "year"></td>
			<td><input type="text" name = "grade"></td>
			<td><input type="text" name = "max"></td>
			<td><input type="text" name = "credit"></td>
			<td><button>과목개설</button></td>
		</form>
		</tr>
	</table>
	</p>
	<a href="${pageContext.request.contextPath}"> 돌아가기 </a>
</body>
</html>