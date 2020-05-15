	package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8");
			
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();	//브라우저에서 출력하는 건 out.print();
			
			
			out.print("<!DOCTYPE html>                 ");	
			out.print("<html>                          ");
			out.print("<head>                          ");
			out.print("<meta charset='UTF-8'>          ");
			out.print("<title>Insert title here</title>");
			out.print("</head>                         ");
			out.print("<body>                          ");	
			if(id.equals("a001")) {
				if(pw.equals("1234")) {
					out.println("로그인 성공");
				} else {
					out.println("로그인 실패");
				}
			} else {
				out.println("존재하지 않는 id입니다");
			}
			out.print("</body>                         ");
			out.print("</html>                         ");
			
			
		}
}