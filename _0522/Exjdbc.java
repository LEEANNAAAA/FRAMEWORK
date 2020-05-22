package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exjdbc {

	public static void main(String[] args) {
		// 오라클 JDBC 드라이버(라이브러리) 클래스인
		// oracle.jdbc.OracleDriver 클래스를 메모리에 로드 , 요건 딱 한번만
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 주소;
		String user = "com"; // 데이터 베이스 계정 아이디
		String password = "com01"; // 데이터 베이스 계정 비밀번호"

		{
			String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
					+ "values ('a003','1234','도우너', 300)";

			// try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다(close)
			try (
					// 데이터 베이스에 접속(연결, 로그인)
					Connection conn = DriverManager.getConnection(url, user, password);
					// 실행할 SQL문을 명령문 객체로 생성(실행 준비)
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
				// SQL문을 담은 명령문(객체)을 실행
				// 실행 결과로 데이터를 돌려받는 SQL문 (SLELECT)은 executeQuery()로 실행
				// 실행 결과로 데이터를 돌려받지 않는 SQL문 (INSERT, UPDATE, DELETE) 은 executeUpdate()로 실행
				int num = pstmt.executeUpdate(); // 실행결과 변경된 레코드 수를 반환
				System.out.println(num + "개의 레코드 추가");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// *보다는 컬럼이름을 다 써주는게 속도가 더 빠르다
		{
			String sql = "select mem_id, mem_pass, mem_name, mem_point from member";

			// try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다(close)
			try (
					// 데이터 베이스에 접속(연결, 로그인)
					Connection conn = DriverManager.getConnection(url, user, password);
					// 실행할 SQL문을 명령문 객체로 생성(실행 준비)
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
				// SQL문을 담은 명령문(객체)을 실행
				// 실행 결과로 데이터를 돌려받는 SQL문 (SLELECT)은 executeQuery()로 실행
				// 실행 결과로 데이터를 돌려받지 않는 SQL문 (INSERT, UPDATE, DELETE) 은 executeUpdate()로 실행
				ResultSet rs = pstmt.executeQuery(); // 실행결과 레코드들을 가리키고 있는 ResultSet 반환
				//처음 ResultSet은 첫 레코드(행) 이전을 가리키고 있는 상태(속성이름..?)
				while (rs.next()) { //next()가 boolean으로 받으므로 참이면 반복, 거짓이면 스탑 >> 다음 레코드로 이동하고, 다음 레코드가 없으면 false가 반환
					//다음과 같이 출력되도록 프로그램을 변경하세요.
					//a001 : 1234 : 고길동 : 100
					//a002 : 1234 : 마이콜 : 200
					//a003 : 1234 : 도우너 : 300
					String memId = rs.getString("mem_id"); //현재 rs가  가리키는 레코드에서 "mem_id"컬럼값 가져오기, commit 필수 확인!
					String psw = rs.getString("mem_pass");
					String memName = rs.getString("mem_name");
					int pot = rs.getInt("mem_point");
					System.out.println(memId +" : "+psw+" : "+memName+" : "+pot);
					
				}
				
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//a001 회원의 포인트를 777로 변경하는 프로그램을 작성하세요.
		{
			String sql = "UPDATE member SET mem_point= 555 WHERE mem_id='a001'";
					
			
			try (
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				int num = pstmt.executeUpdate();
				System.out.println(num + "개의 레코드 변경");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//003 회원을 삭제하는 프로그램을 작성하세요.
		{
			String sql = "DELETE from member where mem_id='a003'";
					

			// try()안에 선언된 변수는 try-catch 블럭 실행이 끝난 후 자동으로 닫아준다(close)
			try (
					Connection conn = DriverManager.getConnection(url, user, password);
					PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
				int num = pstmt.executeUpdate(); // 실행결과 변경된 레코드 수를 반환
				System.out.println(num + "개의 레코드 삭제");

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//전체 회원 정보를 다시 한 번 조회하여 출력하세요.
		{
			String sql = "select mem_id, mem_pass, mem_name, mem_point from member";

			try (
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) { 

					String memId = rs.getString("mem_id"); 
					String psw = rs.getString("mem_pass");
					String memName = rs.getString("mem_name");
					int pot = rs.getInt("mem_point");
					System.out.println(memId +" : "+psw+" : "+memName+" : "+pot);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
