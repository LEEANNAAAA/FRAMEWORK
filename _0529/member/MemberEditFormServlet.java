package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//브라우저 주소창에
//http://localhost:8000/exweb/member/editform.do?memId=a001
//를 입력하고 엔터키를 입력하면,
//브라우저 화면에 회원정보를 입력할 수 있는 폼과 입력엘리먼트를 출력하고,
//데이터베이스에서 아이디가 'a001'인 회원의 정보를 조회하여
//그 정보를 입력엘리먼트에 현재 값으로 출력

//입력엘리먼트에서 아이디 값은 변경할 수 없도록 설정

@WebServlet("/member/editform.do")
public class MemberEditFormServlet extends HttpServlet {

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

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html"); // 1. 응답내용이 text/html임을 브라우저에게 알리도록 설정
		resp.setCharacterEncoding("UTF-8"); // 2. 형식을 맞춰준다 (아래), 응답 내용의 문자 인코딩 설정
		PrintWriter out = resp.getWriter(); // 3. 응답객체에 출력할 수 있는 스트림(파이프) 가져오기 >> 1-3까지는 필수(순서대로)
		out.print("<!DOCTYPE html>                 ");
		out.print("<html>                          ");
		out.print("<head>                          ");
		out.print("<meta charset='UTF-8'>          ");
		out.print("<title>회원관리</title>            ");
		out.print("</head>                         ");
		out.print("<body>                          ");
		out.print("	<h1>회원 정보 수정</h1>              ");

		String no = req.getParameter("memId");

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
					
					out.print("	<form action='" + req.getContextPath() + "/member/edit.do' method='post'>	 ");
					out.print("	아이디 : <input type='text' name='memId' value='" + memId + "' readOnly/> <br>  ");
//					out.print("	비밀번호 : <input type='text' name='memPass' value='" + memPass + "' /> <br>");
					out.print("	이름 : <input type='text' name='memName' value='" + memName + "'/> <br>");
					out.print("	포인트 : <input type='text' name='memPoint' value='" + memPoint + "'/> <br>");
					out.print(" <input type='submit' value='저장'/> <br>                    ");
					out.print("</form>   ");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		out.print("</body>                         ");
		out.print("</html>                         ");
	}
}
