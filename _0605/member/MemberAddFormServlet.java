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
		
		req.getRequestDispatcher("/WEB-INF/jsp/member/memAddForm.jsp").forward(req, resp);
	}
}
