package kr.ac.kopo.exapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExStudent {

	public static void main(String[] args) {
// "1.학생목록 2.학생추가 3.학생삭제 4.종료" 라고 메뉴를 출력
// 번호를 입력받는다
// "1"을 입력한 경우, student 테이블에 존재하는 모든 학생 목록을 출력
// "2"을 입력한 경우, 학번,이름,성적을 입력받아서, student 테이블에 저장
// "3"을 입력한 경우, "삭제할 학생의 학번을 입력하세요"라고 출력하고,
// 입력한 학번의 학생을 student 테이블에서 삭제
// "4"을 입력한 경우, 프로그램을 종료
// 위 작업을 무한 반복
		
//"5성적변경" 메뉴를 추가
//"5"를 입력한 경우, "성적을 변경할 학생의 학번을 입력하세요"라고 출력하고, 학번을 입력받는다.
// 입력받은 학번의 학생의 학번, 이름, 성적을 출력한다.
//"변경할 성적을 입력하세요."라고 출력하고, 성적을 입력받는다.
// 해당 학생의 성적을 입력한 성적으로 테이블에서 변경


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
		
		while(run) {
			System.out.println("1.학생목록 |2.학생추가 |3.학생삭제 |4.종료|5.성적변경");
			System.out.print("선택 > ");
			int num = sc.nextInt();
			sc.nextLine();
			String sql = "SELECT stu_no, stu_name, stu_score from student";
			
			if (num == 1) {
				
				sql = "SELECT stu_no, stu_name, stu_score from student";
				
				try (Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);) {
					ResultSet rs = pstmt.executeQuery();

					while (rs.next()) {
						String stuNo = rs.getString("stu_no");
						String stuName = rs.getString("stu_name");
						String stuScore = rs.getString("stu_score");
						System.out.println(stuNo + " : " + stuName + " : " + stuScore);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (num == 2) {
				
				System.out.println("학번");
				String stuNo = sc.nextLine();
				System.out.println("이름");
				String stuName = sc.nextLine();
				System.out.println("성적");
				String stuScore = sc.nextLine();
				
				
				sql = "INSERT INTO student (stu_no, stu_name, stu_score) "
						+ "VALUES (?,?,?)";

				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						) {
						pstmt.setString(1, stuNo); 
						pstmt.setString(2, stuName); 
						pstmt.setString(3, stuScore);
						int num1 = pstmt.executeUpdate();
						System.out.println(num1 + "명의 레코드 추가");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			} else if(num==3) {
				System.out.println("삭제할 학생의 학번을 입력하세요");
				String del = sc.nextLine();
				
				sql = "DELETE from student where stu_no=?";
				
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
				
			} else if(num==5) {
				
				System.out.println("성적을 변경할 학생의 학번을 입력하세요");
				String stn = sc.nextLine();
				
				//출력
				sql = "SELECT stu_no, stu_name, stu_score from student where stu_no=" + "'"+stn+"'"; //아래 sql 문과 중복되므로
				
				try (Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
						) {

					while (rs.next()) {
						String stuNo = rs.getString("stu_no");
						String stuName = rs.getString("stu_name");
						String stuScore = rs.getString("stu_score");
						System.out.println(stuNo + " : " + stuName + " : " + stuScore);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				System.out.println("변경할 성적을 입력하세요");
				String chs = sc.nextLine();
				
				sql = "UPDATE student SET stu_score=? WHERE stu_no=?";
				
				
				try (
						Connection conn = DriverManager.getConnection(url, user, password);
						PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
					pstmt.setString(1, chs);
					pstmt.setString(2, stn);
					int num3 = pstmt.executeUpdate();
					System.out.println(num3 + "개의 레코드 변경");

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


