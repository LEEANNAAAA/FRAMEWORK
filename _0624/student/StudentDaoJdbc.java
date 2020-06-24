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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.member.MemberVo;

public class StudentDaoJdbc {
//	{
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";
//////////////////////////////////////////////////////////////
	public ArrayList<StudentVo> selectStudentList() {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		String sql = "SELECT stu_no, stu_name, stu_score from student";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
//				String stuNo = rs.getString("stu_no");
//				String stuName = rs.getString("stu_name");
//				int stuScore = rs.getInt("stu_score");
				
				StudentVo vo = new StudentVo();
				vo.setStuNo(rs.getString("stu_no"));
				vo.setStuName(rs.getString("stu_name"));
				vo.setStuScore(rs.getInt("stu_score"));
				list.add(vo);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		}
//////////////////////////////////////////////////////////////
	public StudentVo selectStudent(String no) {
		StudentVo vo = null;
		String sql = "SELECT stu_no, stu_name, stu_score from student where stu_no = ?"; 

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, no);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					vo = new StudentVo();
					vo.setStuNo(rs.getString("stu_no"));
					vo.setStuName(rs.getString("stu_name"));
					vo.setStuScore(rs.getInt("stu_score"));
					
//					String stuNo = rs.getString("stu_no");
//					String stuName = rs.getString("stu_name");
//					int stuScore = rs.getInt("stu_score");

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return vo;
	}
//////////////////////////////////////////////////////////////
	public int insertStudent(StudentVo vo) {
		int num1 = 0;
		String sql = "INSERT INTO student (stu_no, stu_name, stu_score) "
					+ "VALUES (?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getStuNo());
			pstmt.setString(2, vo.getStuName());
			pstmt.setInt(3, vo.getStuScore());
			
			num1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1;
	}
//////////////////////////////////////////////////////////////
	public int updateStudent(StudentVo vo) {
		int num1=0;
		String sql = "UPDATE student SET  stu_name=?, stu_score=? WHERE stu_no=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getStuName());
			pstmt.setInt(2, vo.getStuScore());
			pstmt.setString(3, vo.getStuNo());

			num1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1;
	}	
//////////////////////////////////////////////////////////////
	public int deleteStudent(String delId) {
		int num2=0;
		String sql = "DELETE from student where stu_no=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, delId);
			num2 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num2;
	}
//////////////////////////////////////////////////////////////
}
