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

import org.eclipse.jdt.internal.compiler.parser.Scanner;

// 브라우저 주소창에
// http://localhost:8000/exweb/member/addform.do
// 를 입력하고 엔터키를 입력하면,
// 브라우저 화면에 회원 정보를 입력할 수 있는 입력 엘리먼트들이 출력되도록 

@WebServlet("/member/addform.do")
public class MemberAddFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");		//1. 응답내용이 text/html임을 브라우저에게 알리도록 설정
		resp.setCharacterEncoding("UTF-8"); 	//2. 형식을 맞춰준다 (아래), 응답 내용의 문자 인코딩 설정
	    PrintWriter out = resp.getWriter(); 	//3. 응답객체에 출력할 수 있는 스트림(파이프) 가져오기 >> 1-3까지는 필수(순서대로)
	 	out.print("<!DOCTYPE html>                 ");
		out.print("<html>                          ");
		out.print("<head>                          ");
		out.print("<meta charset='UTF-8'>          ");
		out.print("<title>회원관리</title>            ");
		out.print("</head>                         ");
		out.print("<body>                          ");
		out.print("	<h1>회원추가</h1>                 ");	
		
		//역슬래시\를 "앞에 해서 시작과 끝을 나타내는 "가 아니라는 것을 나타제 주거나 ''로 바꿔준다
		//ContextPath() : 현재 웹애플리케이션(프로젝트)의 고유 경로 > 나중에 경로를 바꾸더라도 폴더를 바꿔 줄 필요 없음
		out.print("	<form action='" + req.getContextPath() + "/member/add.do' method='post'>	 ");
		out.print("	아이디 : <input type='text' name='memId' placeholder='아이디를 입력하세요'/> <br>");
		out.print("	비밀번호 : <input type='text' name='memPass' placeholder='비밀번호를 입력하세요'/> <br>");
		out.print("	이름 : <input type='text' name='memName' placeholder='이름을 입력하세요'/> <br>");
		out.print("	포인트 : <input type='text' name='memPoint' placeholder='포인트를 입력하세요'/> <br>");
		out.print(" <input type='submit' value='저장'/>                                  ");
		out.print("</form>   ");
		
		out.print("</body>                         ");
		out.print("</html>                         ");
	}
}
