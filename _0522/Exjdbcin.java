package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exjdbcin {
	// 클래스를 실행하면,
	// 회원아이디,비밀번호,이름,포인트를 입력받아서,
	// 데이터베이스의 member 테이블에 저장하고,
	// 전체목록을 조회하여 출력하는 프로그램을 작성하세요.

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="com";
		String password = "com01";
		
		Scanner sc = new Scanner(System.in);
		
		{
			System.out.println("회원아이디");
			String memId = sc.nextLine();
			System.out.println("비밀번호");
			String memPass = sc.nextLine();
			System.out.println("이름");
			String memName = sc.nextLine();
			System.out.println("포인트");
			int memPoint = Integer.parseInt(sc.nextLine());
			
			//sql문에서 변화하는 값은 ?로 표시 
			String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
					+ "VALUES (?,?,?,?)"; //이런 식으로 입력하면 보안이 취약
			
			//드래고하고 pick out
			try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
				//주입할 값의 타입에 따라서 PreparedStatement 객체의 set타입명() 메서드를 사용
				pstmt.setString(1, memId); //파라미터 인덱스는 0이 아니라 1부터 시작 >> pstmt에 들어있는 SQL문의 1번째 ?에 id값을 주입
				pstmt.setString(2, memPass); 
				pstmt.setString(3, memName);
				pstmt.setInt(4, memPoint);
				int num = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
				System.out.println(num + "개의 레코드 추가");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	{
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point from member";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				int memPoint = rs.getInt("mem_point");
				System.out.println(memId + " : " + memPass + " : " + memName + " : " + memPoint);

		}

	}catch(
	SQLException e)
	{
		e.printStackTrace();
	}
}}}
