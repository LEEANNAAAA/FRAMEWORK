package kr.ac.kopo.student;

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


@WebServlet("/student/addform.do")
public class StudentAddformServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");		//1. 응답내용이 text/html임을 브라우저에게 알리도록 설정
		resp.setCharacterEncoding("UTF-8"); 	//2. 형식을 맞춰준다 (아래), 응답 내용의 문자 인코딩 설정
	    PrintWriter out = resp.getWriter(); 	//3. 응답객체에 출력할 수 있는 스트림(파이프) 가져오기 >> 1-3까지는 필수(순서대로)
	 	out.print("<!DOCTYPE html>                 ");
		out.print("<html>                          ");
		out.print("<head>                          ");
		out.print("<meta charset='UTF-8'>          ");
		out.print("<title>학생관리</title>            ");
		out.print("</head>                         ");
		out.print("<body>                          ");
		out.print("	<h1>학생추가</h1>                 ");	
		
		out.print("	<form action='" + req.getContextPath() + "/student/add.do' method='post'>	 ");
		out.print("	학번 : <input type='text' name='stuNo' /> <br>");
		out.print("	이름 : <input type='text' name='stuName' /> <br>");
		out.print("	성적 : <input type='text' name='stuScore' /> <br>");
		out.print(" <input type='submit' value='저장'/>                                  ");
		out.print("</form>   ");
		
		out.print("</body>                         ");
		out.print("</html>                         ");
	}
}

