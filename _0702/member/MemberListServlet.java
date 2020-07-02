package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

//1.
// 회원목록 화면에 '회원추가' 링크를 추가하고, 
// 링크를 클릭하면 http://localhost:8000/exweb/member/addform.do 로 이동

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet {
	private MemberService memberService = MemberServiceImpl.getInstance();
 // 이곳에 한번만 해놓으면 아래서 다시 해주지 않아도됨, 한번만 실행이 되도록 이곳에 위치, db에서 목록조회

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberVo> list = memberService.selectMemberList();

		req.setAttribute("memList", list);	//요청객체에 "memList"라는 이름으로 list 데이터를 저장
		
//		"/WEB-INF/jsp/member/memList.jsp"파일로 이동
		
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp"); //현재 요청을 위임하여 처리할 수 있도록 하는 디스패쳐 가져오기
//		rd.forward(req, resp); //현재 요청객체와 응답객체를 전달해주면서 이동 
	
		req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp").forward(req, resp); //위에 두 줄을 한줄로 묶음 가능
	}
	

}
