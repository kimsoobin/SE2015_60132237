
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.util.*"%>
<%@ page import="kr.ac.mju.Regist"%>
<%
	Vector<Regist> registList = (Vector<Regist>) request.getAttribute("registList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>���� �ο� ȭ��</h1>
	<table style="width: 70%">
		<tr>
			<td>�л�</td>
			<td>����</td>
			<td>�����ο�</td>
		</tr>
			<%
				for (int i = 0; i < registList.size(); i++) {
					Regist regist = registList.get(i);
			%>
			<tr>
			<td><%=regist.getStudentname()%></td>
			<td><%=regist.getClassGrade()%></td>
			<td><form action="${pageContext.request.contextPath}/ProController/grantgrade"
		method="GET">
				<input type = "hidden" name = "name" value = <%=regist.getStudentname() %>>
				<input type = "hidden" name = "classname" value = <%=regist.getClassname() %>>
				<input type = "text" name = "classgrade">
				<button>���� �ο�</button>
			</form>
			</td></tr>
			<%
				}
			%>
	</table>

	<br />
<a href="${pageContext.request.contextPath}/loginController/logout">�α׾ƿ�</a>
</body>
</html>