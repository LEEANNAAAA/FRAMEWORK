package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹애플리케이션 서버를 통해서 실행되는 클래스는 servlet 규칙을 따라서 만들어야 한다.
//일반적으로 HttpServlet클래스를 상속하여 작성
//HelloServet h = new HelloServet();
//h.service();



@WebServlet("/hello.do")//"/hello.do"주소로 요청이 오면 이 서블릿을 실행
public class HelloServlet extends HttpServlet {
	
//이 서블릿이 클래스를 실행시키는 요청이 올떄마다 한번씩 싱행돠는 메서드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//service만 입력하고 ctrl+space
		System.out.println("Hello servlet");
		
		//POST 방식으로 전송된 파라미터 값의 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		
		//"name"이라는 이름의 파라미터 값을 가져와서 변수 n에 저장(단일 값)
		//String n = req.getParameter("name");
		
		String n = req.getParameter("a");
		String n2 = req.getParameter("b");
		
		
		 //요청으로 보낸 웹브라우저에게 출력하기 위해서는 
	     //인자로 받은 응답객체에 출력해야한다.
		resp.setContentType("text/html");		//1. 응답내용이 text/html임을 브라우저에게 알리도록 설정
		resp.setCharacterEncoding("UTF-8"); 	//2. 형식을 맞춰준다 (아래), 응답 내용의 문자 인코딩 설정
	    PrintWriter out = resp.getWriter(); 	//3. 응답객체에 출력할 수 있는 스트림(파이프) 가져오기 >> 1-3까지는 필수(순서대로)
	      //out.print("Hello Servlet!!!");

	             
		out.print("<!DOCTYPE html>                 ");
		out.print("<html>                          ");
		out.print("<head>                          ");
		out.print("<meta charset='UTF-8'>          ");
		out.print("<title>Insert title here</title>");
		out.print("</head>                         ");
		out.print("<body>                          ");
		out.print("	<h1>hello, " + n + "</h1>        ");	//영어는 출력이 잘 되지만 다른 언어는 깨져서 나온다 > resp.setCharacterEncoding("UTF-8"); > 문자출력 가능
		out.print("	<h1>안녕, " + n2 + "</h1>        ");		//n 드래그 후에 ctrl+1 
		out.print("</body>                         ");
		out.print("</html>                         ");
				
		
	}
	
	
}
