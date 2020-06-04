<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
{
	try {
		Class.forName("oracle.jdbc.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}

String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "com";
String password = "com01";
%>


<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생목록</title>
</head>
<body>
	<h1>학생목록</h1>
	
	<table>
	<caption> 학생목록 </caption>
	<thead>
	<tr>
	<th>학번</th>
	<th>이름</th>
	</tr>
	<tr>
	<td></td>
	</tr>
	</thead>
	</table>
	
	
	<a href='<%=request.getContextPath() %>/student/addform.jsp'>학생추가</a>
	<br>
	<br>
	<%
			String sql = "SELECT stu_no, stu_name, stu_score from student";

			try (Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					String stuNo = rs.getString("stu_no");
					String stuName = rs.getString("stu_name");
					int stuScore = rs.getInt("stu_score");
	%>

	<a href='<%= request.getContextPath()%>/student/editform.jsp?stuNo=<%= stuNo%>'><%= stuNo%></a>
	: <%= stuName%> : <%= stuScore %>
	<br>
	<%
					}

			} catch (SQLException e) {
				e.printStackTrace();
			}
					%>
</body>
</html>
