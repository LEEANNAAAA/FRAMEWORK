package kr.ac.kopo.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO(Data Access Object)
//자바 데이터(객체) <-> 데이터베이스 데이터(테이블) 상호변환을 담당
public class MemberDaoJdbc {

	{ // 개체 초기화
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";

	
	public ArrayList<MemberVo> selectMemberList() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point from member";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setMemId(rs.getString("mem_id"));
				vo.setMemName(rs.getString("mem_name"));
				vo.setMemPass(rs.getString("mem_pass"));
				vo.setMemPoint(rs.getInt("mem_point"));
				list.add(vo);
				
//					String memId = rs.getString("mem_id");
//					String memPass = rs.getString("mem_pass");
//					String memName = rs.getString("mem_name");
//					int memPoint = rs.getInt("mem_point");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberVo selectMember(String memId) {	//조회
		MemberVo vo = null;
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point from member where mem_id = ?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, memId);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					vo = new MemberVo();
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemPoint(rs.getInt("mem_point"));

//					String memId = rs.getString("mem_id");
//					String memPass = rs.getString("mem_pass");
//					String memName = rs.getString("mem_name");
//					int memPoint = rs.getInt("mem_point");

				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public int insertMember( MemberVo vo) {
		int num1 = 0;
		String sql = "INSERT INTO member (mem_id, mem_pass, mem_name, mem_point) "
					+ "VALUES (?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPass());
			pstmt.setString(3, vo.getMemName());
			pstmt.setInt(4, vo.getMemPoint());
			
			num1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1;
	}
	
	public int updateMember(MemberVo vo) {
		int num1=0;
		String sql = "UPDATE member SET  mem_name=?, mem_point=? WHERE mem_id=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getMemName() );
			pstmt.setInt(2, vo.getMemPoint());
			pstmt.setString(3, vo.getMemId());

			num1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1;
	}

	public int deleteMember(String memId) {
		int num2=0;
		String sql = "DELETE from member where mem_id=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, memId);
			num2 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num2;
	}


	
	/////////////////////////////////////////////////////////////////////

	public MemberVo selectLoginMember(MemberVo memberVo) {	//타입 : MemberVo, 변수이름 : memberVo
		MemberVo vo = null;
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point from member "
				+ "where mem_id = ? and mem_pass=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, memberVo.getMemId());
			pstmt.setString(2, memberVo.getMemPass());
			
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {	//일치하지않으면 애초에 false가 되어서 if문이 실행되지 않음
					vo = new MemberVo();
					vo.setMemId(rs.getString("mem_id"));
					vo.setMemName(rs.getString("mem_name"));
					vo.setMemPass(rs.getString("mem_pass"));
					vo.setMemPoint(rs.getInt("mem_point"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;

	}
	
	
}
