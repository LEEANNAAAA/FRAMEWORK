<%@page import="java.sql.SQLException"%>
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
		}// 한번만!
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01"; // 변수 쓰는 곳에 필요함
    %>
    <%
    	request.setCharacterEncoding("UTF-8");
		String stuNo = request.getParameter("stuNo");
		String stuName = request.getParameter("stuName");
		int stuScore = Integer.parseInt(request.getParameter("stuScore"));

		String sql = "UPDATE student SET  stu_name=?, stu_score=? WHERE stu_no=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, stuName);
			pstmt.setInt(2, stuScore);
			pstmt.setString(3, stuNo);

			int num1 = pstmt.executeUpdate();
			System.out.println(num1 + "명의 학생 수정");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/student/list.jsp");
    %>
    