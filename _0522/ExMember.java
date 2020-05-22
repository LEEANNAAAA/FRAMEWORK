package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class ExMember {
	public static void main(String[] args) {
		// "1.회원목록 2.회원추가 3.회원삭제 4.종료" 라고 메뉴를 출력
		// 번호를 입력받는다

		// "1"을 입력한 경우, 데이터베이스에 존재하는 모든 회원 목록을 출력

		// "2"을 입력한 경우, 회원아이디,비밀번호,이름,포인트를 입력받아서,
		// 데이터베이스의 member 테이블에 저장
		// "3"을 입력한 경우, "삭제할 회원의 아이디를 입력하세요"라고 출력하고,
		// 입력한 아이디의 회원을 member 테이블에서 삭제
		// "4"을 입력한 경우, 프로그램을 종료
		// 위 작업을 무한 반복

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "com";
		String password = "com01";

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("1.회원목록 |2.회원추가 |3.회원삭제 |4.종료");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			sc.nextLine();

			if (num == 1) {
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

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (num == 2) {
				
				System.out.println("회원아이디");
				String memId = sc.nextLine();
				System.out.println("비밀번호");
				String memPass = sc.nextLine();
				System.out.println("이름");
				String memName = sc.nextLine();
				System.out.println("포인트");
				int memPoint = Integer.parseInt(sc.nextLine());
				
				
				String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
						+ "VALUES (?,?,?,?)";

				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {
						//주입할 값의 타입에 따라서 PreparedStatement 객체의 set타입명() 메서드를 사용
						pstmt.setString(1, memId); //파라미터 인덱스는 0이 아니라 1부터 시작 >> pstmt에 들어있는 SQL문의 1번째 ?에 id값을 주입
						pstmt.setString(2, memPass); 
						pstmt.setString(3, memName);
						pstmt.setInt(4, memPoint);
						int num1 = pstmt.executeUpdate(); //실행결과 변경된 레코드 수를 반환
						System.out.println(num1 + "명의 레코드 추가");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			} else if(num==3) {
				System.out.println("삭제할 아이디를 입력하세요");
				String del = sc.next();
				
				String sql = "DELETE from member where mem_id=?";
				
				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
					) {
					pstmt.setString(1,del);
					int num2 = pstmt.executeUpdate(); 
					System.out.println(num2 + "명의 레코드 삭제");

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else {
				run = false;
			}
		}
		System.out.println("종료");
	}
}
