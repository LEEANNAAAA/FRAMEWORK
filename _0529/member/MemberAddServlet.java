package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/add.do")
public class MemberAddServlet extends HttpServlet {
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 하나의 프로그램에 하나만 있으면 되므로 서블릿마다 넣어주지 않아도된다.
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
					+ "VALUES (?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setInt(4, memPoint);
			
			int num1 = pstmt.executeUpdate();
			System.out.println(num1 + "명의 회원 추가");

		} catch (SQLException e) {
			e.printStackTrace();
		}

//		resp.sendRedirect("URL주소 또는 경로") 
//		: 지정된 주소 또는 경로로 이동하라는 명령을 담은 응답을 브라우저에게 전송
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
		
//		resp.setContentType("text/html");		//1. 응답내용이 text/html임을 브라우저에게 알리도록 설정
//		resp.setCharacterEncoding("UTF-8"); 	//2. 형식을 맞춰준다 (아래), 응답 내용의 문자 인코딩 설정
//		PrintWriter out = resp.getWriter(); 	//3. 응답객체에 출력할 수 있는 스트림(파이프) 가져오기 >> 1-3까지는 필수(순서대로)
//		
//		out.print("<!DOCTYPE html>                 ");
//		out.print("<html>                          ");
//		out.print("<head>                          ");
//		out.print("<meta charset='UTF-8'>          ");
//		out.print("<title>회원관리</title>");
//		out.print("</head>                         ");
//		out.print("<body>                          ");
//		out.print("	<a href='" + req.getContextPath() + "/member/addform.do'>추가 목록으로 이동</a> <br>  ");	
//		out.print("	<a href='" + req.getContextPath() + "/member/list.do'>회원 목록으로 이동</a>   ");	
//		out.print("</body>                         ");
//		out.print("</html>                         ");
		
		
	}
}
