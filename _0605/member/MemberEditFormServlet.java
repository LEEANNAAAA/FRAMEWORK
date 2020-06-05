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

	MemberDaoJdbc memberDao = new MemberDaoJdbc();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String no = req.getParameter("memId");
		MemberVo vo = memberDao.selectMember(no);
		
		req.setAttribute("memVo", vo); 	//요청객체(vo)에 저장
		
		req.getRequestDispatcher("/WEB-INF/jsp/member/memEditForm.jsp").forward(req, resp);;	//이동할 jsp파일
	}
}
