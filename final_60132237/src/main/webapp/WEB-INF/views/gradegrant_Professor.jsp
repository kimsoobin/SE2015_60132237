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
	<h1>���� �ο� ȭ�� ����</h1>
	<table style="width: 70%">
		<tr>
			<td>���¹�ȣ</td>
			<td>�����</td>
			<td>�����⵵</td>
			<td>�г�</td>
			<td>����</td>
			<td>����</td>
		</tr>
			<%
				for (int i = 0; i < gangjwaList.size(); i++) {
					Gangjwa gangjwa = gangjwaList.get(i);
					if (gangjwa.getProf_name().equals(user.getName())) {
			%>
			<tr>
			<td><%=gangjwa.getId()%></td>
			<td><%=gangjwa.getName()%></td>
			<td><%=gangjwa.getYear()%></td>
			<td><%=gangjwa.getGrade()%></td>
			<td><%=gangjwa.getMax()%></td>
			<td><%=gangjwa.getCredit()%></td></tr>
			<%
				}
				}
			%>
	</table>
	</p>
	<form
		action="${pageContext.request.contextPath}/ProController/gradegrant"
		method="get">
		������ �ο��� ������ ���¹�ȣ�� ������ �ּ���.
		</p>
		<input type="text" name="no">
		<button>���� �ο��ϱ�</button>
	</form>
	</p>

<a href="${pageContext.request.contextPath}/loginController/logout">�α׾ƿ�</a>
</body>
</html>