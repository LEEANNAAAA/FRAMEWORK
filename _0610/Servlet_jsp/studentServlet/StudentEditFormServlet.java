package kr.ac.kopo.student;

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

@WebServlet("/student/editform.do")
public class StudentEditFormServlet extends HttpServlet {
	
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("stuNo");
		StudentVo vo = studentDao.selectStudent(no);

		req.setAttribute("stuVo", vo);
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/editform.jsp").forward(req, resp);
		

	}

	
	}

