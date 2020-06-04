<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!

// 4. 학생목록을 다음과 같은 표 형태로 출력하고,
// '학번'을 클릭하면 학번 오름차순으로 정력하여 출력하고,
// '이름'을 클릭하면 이름순으로 정력하여 출력
// --------------------
// | 학번	| 이름	|
// --------------------
// | 1234	| 포로리	|
// --------------------
// | 5678	| 너부리	|
// --------------------

// '학번'기준으로 정렬된 상태에서 '학번'을 다시 클릭하면,
// 오름차순 또는 내림차순을 번갈아서 정렬
// '이름'기준으로 정렬된 상태에서 '이름'을 다시 클릭하면,
// 오름차순과 내림차순을 번갈아서 정렬

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
<title>회원관리</title>
</head>
<body>
	<h1>회원 정보 수정</h1>

	<%
		String no = request.getParameter("memId");

	String sql = "SELECT mem_id, mem_pass, mem_name, mem_point from member where mem_id = ?";

	try (Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
		pstmt.setString(1, no);
		try (ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
		String memId = rs.getString("mem_id");
		String memPass = rs.getString("mem_pass");
		String memName = rs.getString("mem_name");
		int memPoint = rs.getInt("mem_point");
	%>

	<form action='<%=request.getContextPath()%>/member/memEdit.jsp'
		method='post'>
		아이디 : <input type='text' name='memId' value='<%=memId%>' readOnly /><br> 
		이름 : <input type='text' name='memName' value='<%=memName%>' /><br> 
		포인트 : <input type='text' name='memPoint' value='<%=memPoint%>' /> <br> 
		<input type='submit' value='저장' />
		<a href='<%=request.getContextPath()%>/member/memDel.jsp?memId=<%= memId%>'><button type='button'>삭제</button></a><br>
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
