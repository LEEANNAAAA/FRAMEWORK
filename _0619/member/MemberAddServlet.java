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
// > service() 실행 > HttpServlet 안에 service() 존재
public class MemberAddServlet extends HttpServlet {
	MemberDao memberDao = new MemberDaoBatis();
	
	//요청을 받으면, 요청방식에 상관없이 실행되는 메서드 : service()
	//특정 요청방식으로 요청이 온 경우에만 실행되는 메서드 : do요청방식() / doGet, doPost
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/member/memAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		
//		String memId = req.getParameter("memId");
//		String memPass = req.getParameter("memPass");
//		String memName = req.getParameter("memName");
//		int memPoint = Integer.parseInt(req.getParameter("memPoint"));
		
//		MemberVo vo = new MemberVo();
//		vo.setMemId(memId);
//		vo.setMemPass(memPass);
//		vo.setMemName(memName);
//		vo.setMemPoint(memPoint);
		
		MemberVo vo = new MemberVo();
		vo.setMemId(req.getParameter("memId"));
		vo.setMemPass(req.getParameter("memPass"));
		vo.setMemName(req.getParameter("memName"));
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint")));
		
		
		int num1 = memberDao.insertMember(vo);
		System.out.println(num1 + "명의 회원 추가");
		
//		resp.sendRedirect("URL주소 또는 경로") 
//		: 지정된 주소 또는 경로로 이동하라는 명령을 담은 응답을 브라우저에게 전송
		resp.sendRedirect(req.getContextPath() + "/member/list.do");
		
	}
	
}
		
		
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
		
		

	

