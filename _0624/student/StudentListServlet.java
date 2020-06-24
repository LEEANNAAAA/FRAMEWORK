package kr.ac.kopo.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.member.MemberVo;

//1.브라우저 주소창에
//http://localhost:8000/exweb/student/list.do
//를 입력하여 접속(요청전송)하면,
//브라우저 화면에 학생목록(학번, 이름)이 출력되도록 구현
//2.학생목록 화면에 '학생추가' 링크를 추가하고,
//그 링크를 클릭하면,
//http://localhost:8000/exweb/student/addform.do로 이동하여,
//학생의 학변, 이름, 성적을 입력할 수 있는 입력엘리먼트를 출력
//(학번,이름, 성적 파라미터 이름은 stuNo, stuName, stuScore로 설정)
//2-1.저장 버튼을 클릭하면
//http://localhost:8000/exweb/student/add.do로 이동하여,
//입력한 학생 정보를 데이터베이스에 저장하고 
//학생목록 화면으로 이동
//3.학생목록화면에서 각 학생들의 학번을 클릭하면,
//http://localhost:8000/exweb/student/editform.do로 이동하여,
//해당 학생의 학번, 이름, 성적을 입력할 수 있는 입력엘리먼트들을 출력
//(입력엘리먼트에는 해당 학생의 현재 학번, 이름, 성적을 출력)
//3-1.저장 버튼을 클릭하면
//http://localhost:8000/exweb/student/edit.do로 이동하여,
//데이터베이스에서 해당 학생의 이름과 성적을 변경하고
//학생목록 화면으로 이동
//3-2.삭제 버튼을 클릭하면
//http://localhost:8000/exweb/student/del.do로 이동하여,
//데이터베이스에서 해당 학생을 삭제하고,
//브라우저 화면에 학생목록이 출력

@WebServlet("/student/list.do")
public class StudentListServlet extends HttpServlet{
	StudentDaoJdbc studentDao = new StudentDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<StudentVo> list = studentDao.selectStudentList();

		req.setAttribute("stuList", list);	//요청객체에 "memList"라는 이름으로 list 데이터를 저장
		req.getRequestDispatcher("/WEB-INF/jsp/student/list.jsp").forward(req, resp); //위에 두 줄을 한줄로 묶음 가능

	
	}
	
}
