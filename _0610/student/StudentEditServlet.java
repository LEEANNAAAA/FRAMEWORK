package kr.ac.kopo.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student/edit.do")
public class StudentEditServlet extends HttpServlet {

	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("stuNo");
		StudentVo vo = studentDao.selectStudent(no);

		req.setAttribute("stuVo", vo);
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/editform.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
//		String stuNo = req.getParameter("stuNo");
//		String stuName = req.getParameter("stuName");
//		int stuScore = Integer.parseInt(req.getParameter("stuScore"));

		StudentVo vo = new StudentVo();
		vo.setStuNo(req.getParameter("stuNo"));
		vo.setStuName(req.getParameter("stuName"));
		vo.setStuScore(Integer.parseInt(req.getParameter("stuScore")));
		
		int num1 = studentDao.updateStudent(vo);
		
		System.out.println(num1 + "명의 학생 수정");
		resp.sendRedirect(req.getContextPath() + "/student/list.do");

	}

	
}
