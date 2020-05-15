package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange.do")
public class ExchangeServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
			
		String money = req.getParameter("dollar");	//파라미터는 전부 문자열
		double num = Double.parseDouble(money);	//실수로 바꾸어 주어야한다
		double result = num*1216.90;
	
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
		
		out.println(money+"달러 : "+result + "원<br />");
		out.println("현찰 사실때 : " +(num * 1238.19) +"원<br />");	
		out.println("현찰 파실때 : "+(num * 11965.61)+"원<br />"); 	
		out.println("송금 보내실때 : "+(num * 1228.80) +"원<br />"); 	
		out.println("송금 보내 받으실때 : "+(num * 1205.00)+"원<br />"); 		
	

		out.print("</body>                         ");
		out.print("</html>                         ");
		
		
		
		
	}
}
