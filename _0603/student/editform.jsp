<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
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
		<title>학생관리</title>    
		</head>                    
		<body>                     
			<h1>학생 정보 수정</h1>

    <%
    
		String no = request.getParameter("stuNo");

		String sql = "SELECT stu_no, stu_name, stu_score from student where stu_no = ?"; 

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, no);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					String stuNo = rs.getString("stu_no");
					String stuName = rs.getString("stu_name");
					int stuScore = rs.getInt("stu_score");
    %>

					
						<form action='<%= request.getContextPath()%>/student/edit.jsp' method='post'>
						학번: <input type='text' name='stuNo' value='<%=stuNo%>' readOnly/> <br>
						이름 : <input type='text' name='stuName' value='<%=stuName%>'/> <br>
						성적 : <input type='text' name='stuScore' value='<%=stuScore%>'/> <br>
					 <input type='submit' value='저장'/> 
					 <a href='<%= request.getContextPath()%>/student/del.jsp?stuNo=<%= stuNo%>'><button type='button'>삭제</button></a><br>                    
					</form>  
					<%
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
					%>


		</body>                     
		</html>  
