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
//http://localhost:8000/exweb/member/del.do?memId=a001
//를 입력하고 엔터키를 입력하면,
//데이터베이스에서 아이디가 'a001'인 회원을 삭제하고,
//브라우저 화면에 회원목록이 출력되도록 구현

@WebServlet("/member/del.do")
public class MemberDelServlet extends HttpServlet {
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

		String delId = req.getParameter("memId");

		String sql = "DELETE from member where mem_id=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, delId);
			int num2 = pstmt.executeUpdate();
			System.out.println(num2 + "명의 학생 삭제");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath() + "/member/list.do");
	}
}
