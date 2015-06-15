<%@page import="kr.ac.mju.Regist"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="kr.ac.mju.Gangjwa"%>
<%@ page import="kr.ac.mju.User"%>
<%
	Vector<Regist> registList = (Vector<Regist>) request.getAttribute("regist");
	User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>성적 열람 화면</h1>
	<table style="width: 70%">
		<tr>
			<td>강좌번호</td>
			<td>과목명</td>
			<td>담당교수</td>
			<td>개설년도</td>
			<td>학년</td>
			<td>학점</td>
			<td>정원</td>
			<td>성적</td>
		</tr>
			<%
				for (int i = 0; i < registList.size(); i++) {
					Regist regist = registList.get(i);
					if (user.getName().equals(regist.getStudentname())) {
			%>
			
			<tr><td><%=regist.getNo()%></td>
			<td><%=regist.getClassname()%></td>
			<td><%=regist.getProname()%></td>
			<td><%=regist.getYear()%></td>
			<td><%=regist.getGrade()%></td>
			<td><%=regist.getCredit()%></td>
			<td><%=regist.getMax()%></td>
			<td><%=regist.getClassGrade()%></td></tr>
			<%
				}
				}
			%>
	</table>

	<a href="${pageContext.request.contextPath}/loginController/logout">로그아웃</a>
</body>
</html>