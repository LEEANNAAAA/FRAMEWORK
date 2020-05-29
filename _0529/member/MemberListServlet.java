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

//1.
// 회원목록 화면에 '회원추가' 링크를 추가하고, 
// 링크를 클릭하면 http://localhost:8000/exweb/member/addform.do 로 이동

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet{
	
	{	//개체 초기화 
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
		
		resp.setContentType("text/html");		//1. 응답내용이 text/html임을 브라우저에게 알리도록 설정
		resp.setCharacterEncoding("UTF-8"); 	//2. 형식을 맞춰준다 (아래), 응답 내용의 문자 인코딩 설정
	    PrintWriter out = resp.getWriter(); 	//3. 응답객체에 출력할 수 있는 스트림(파이프) 가져오기 >> 1-3까지는 필수(순서대로)
	 	out.print("<!DOCTYPE html>                 ");
		out.print("<html>                          ");
		out.print("<head>                          ");
		out.print("<meta charset='UTF-8'>          ");
		out.print("<title>회원관리</title>");
		out.print("</head>                         ");
		out.print("<body>                          ");
		out.print("	<h1>회원목록</h1>        ");	
		out.println("<a href='" + req.getContextPath() + "/member/addform.do'>회원추가</a><br><br>");
		
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
					out.println("<a href='" + req.getContextPath() + "/member/editform.do?memId="+ memId +"'>"+memId+"</a>");
					out.println(" : " + memPass + " : " + memName + " : " + memPoint);
					out.println("<a href='" + req.getContextPath() + "/member/del.do?memId=" + memId + "'><button>삭제</button></a><br>");
					
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		out.print("</body>                         ");
		out.print("</html>                         ");
		
	}
	
}
