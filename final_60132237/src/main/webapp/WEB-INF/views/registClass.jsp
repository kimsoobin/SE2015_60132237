<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="kr.ac.mju.Gangjwa"%>
<%@ page import="kr.ac.mju.User"%>
<%
	Vector<Gangjwa> gangjwaList = (Vector<Gangjwa>) request
			.getAttribute("gangjwaList");
	User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>������ûȭ��</h1>
	<table style="width: 70%">
		<tr>
			<td>���¹�ȣ</td>
			<td>�����</td>
			<td>��米��</td>
			<td>�����⵵</td>
			<td>�г�</td>
			<td>����</td>
			<td>����</td>
			<td>��û�ϱ�</td>
		</tr>
		<tr>
			<%
				for (int i = 0; i < gangjwaList.size(); i++) {
					Gangjwa gangjwa = gangjwaList.get(i);
			%>
			<form
				action="${pageContext.request.contextPath}/StudentController/regist"
				method="POST">
			<td><%=gangjwa.getId()%></td>
			<td><%=gangjwa.getName()%></td>
			<td><%=gangjwa.getProf_name()%></td>
			<td><%=gangjwa.getYear()%></td>
			<td><%=gangjwa.getGrade()%></td>
			<td><%=gangjwa.getCredit()%></td>
			<td><%=gangjwa.getMax()%></td>
			
			<input type = "hidden" name = "stuname" value = <%=user.getName() %>>
			<input type = "hidden" name = "classnum" value  =<%=gangjwa.getId() %>>
			<input type = "hidden" name = "classname" value = <%=gangjwa.getName() %>>
			<input type = "hidden" name = "proname" value = <%=gangjwa.getProf_name() %>>
			<input type = "hidden" name = "year" value = <%=gangjwa.getYear() %>>
			<input type = "hidden" name = "grade" value = <%=gangjwa.getGrade() %>>
			<input type = "hidden" name = "credit" value = <%=gangjwa.getCredit() %>>
			<input type = "hidden" name = "max" value = <%=gangjwa.getMax() %>>
			<td><button>��û</button></td>
			</form>
			</tr>
			<%
				}
			%>
	</table><br/>
	<a href="${pageContext.request.contextPath}/loginController/logout">�α׾ƿ�</a>

</body>
</html>