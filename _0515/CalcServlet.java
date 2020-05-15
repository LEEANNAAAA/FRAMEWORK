package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cal.do")
public class CalcServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String n1 = req.getParameter("x");
		String n2 = req.getParameter("y");
		String op = req.getParameter("op");
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		out.print("<!DOCTYPE html>                 ");	
		out.print("<html>                          ");
		out.print("<head>                          ");
		out.print("<meta charset='UTF-8'>          ");
		out.print("<title>Insert title here</title>");
		out.print("</head>                         ");
		out.print("<body>                          ");
		
		
		double num1 = Double.parseDouble(n1);	//실제 숫자로 변환
		double num2 = Double.parseDouble(n2);
		
		double result = 0; // 변수의 초기값을 지정해 주고 변수를 사용해야함
		String opOut = ""; //출력문 연산자 결정
		
		switch (op) {
		case "plu":
			result = num1 + num2;
			opOut = "+";
		break;
		
		case "min":
			result = num1 - num2;
			opOut = "-";
		break;
			
		case "mul":
			result = num1 * num2;
			opOut = "*";
		break;
			
		case "div":
			result = num1 / num2;
			opOut = "/";
		break;
			
		default:
			out.println("알 수 없는 연산자");
			return;
		}
		
	
		
		out.println(n1 + opOut + n2 + "=" + result);
			out.print("</body>                         ");
			out.print("</html>                         ");
		
	
	}

	}
	

