<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%!{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
<style type="text/css">
h1{
font-size:30px;
}
body{
text-align:center;
font-family:"돋움";
line-height:30px;
}
</style>
</head>
<body>
	<h1>회원목록</h1>
	<a href='<%= request.getContextPath() %>/member/memAddForm.jsp'>회원추가</a>
	<br>
	<br>

	<%
		{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point from member";

		try (Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
		String memId = rs.getString("mem_id");
		String memPass = rs.getString("mem_pass");
		String memName = rs.getString("mem_name");
		int memPoint = rs.getInt("mem_point");
	%>

<!-- req.가 아니라 request로 꼭 적어줘야 한다. -->
	<a href='<%=request.getContextPath()%>/member/memEditForm.jsp?memId=<%=memId%>'> <%=memId %> </a> 
	: <%= memPass %>: <%=memName %> : <%=memPoint %>
	<br>
	<%
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	%>
</body>
</html>



