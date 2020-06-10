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

@WebServlet("/student/del.do")
public class StudentDelServlet extends HttpServlet {
	
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String delId = req.getParameter("stuNo");

		int num2 = studentDao.deleteStudent(delId);

		System.out.println(num2 + "명의 학생 삭제");
		resp.sendRedirect(req.getContextPath() + "/student/list.do");
	}

	
	}

