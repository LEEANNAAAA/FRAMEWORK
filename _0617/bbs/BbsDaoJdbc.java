package kr.ac.kopo.bbs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DAO(Data Access Object)
//자바 데이터(객체) <-> 데이터베이스 데이터(테이블) 상호변환을 담당
public class BbsDaoJdbc {

	{ // 개체 초기화
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// DB접속 정보
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "com";
	String password = "com01";

	public ArrayList<BbsVo> selectBbsList() {
		ArrayList<BbsVo> list = new ArrayList<BbsVo>();
		String sql = "SELECT bbs_no, bbs_title, bbs_writer, bbs_reg_date, bbs_count from bbs";
		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BbsVo vo = new BbsVo();
				vo.setBbsNo(rs.getInt("bbs_no"));
				vo.setBbsTitle(rs.getString("bbs_title"));
				vo.setBbsWriter(rs.getString("bbs_writer"));
				vo.setBbsRegDate(rs.getTimestamp("bbs_reg_date")); // 상속관계라 timestamp여도 date(util)에 저장 가능 // getDate라고 할 경우 시간을 버림 > timestamp로 해줘야 한다
				vo.setBbsCount(rs.getInt("bbs_count"));
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

	public BbsVo selectBbs(int bbsNo) {
		BbsVo vo = null;
		String sql = "SELECT bbs_no, bbs_title, bbs_content, bbs_writer, bbs_reg_date, bbs_count from bbs where bbs_no = ?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, bbsNo);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					vo = new BbsVo();
					vo.setBbsNo(rs.getInt("bbs_no"));
					vo.setBbsTitle(rs.getString("bbs_title"));
					vo.setBbsContent(rs.getString("bbs_content"));
					vo.setBbsWriter(rs.getString("bbs_writer"));
					vo.setBbsRegDate(rs.getTimestamp("bbs_reg_date"));
					vo.setBbsCount(rs.getInt("bbs_count"));

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

	public int insertBbs(BbsVo vo) {
		int num1 = 0;
		String sql = "INSERT INTO bbs (bbs_no, bbs_title, bbs_content, bbs_writer) "
				+ "VALUES (seq_bbs_no.NEXTVAL,?,?,?)";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getBbsTitle());
			pstmt.setString(2, vo.getBbsContent());
			pstmt.setString(3, vo.getBbsWriter());

			num1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1;
	}

	public int updateBbs(BbsVo vo) {
		int num1 = 0;
		String sql = "UPDATE bbs SET  bbs_title=?, bbs_content=? WHERE bbs_no=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, vo.getBbsTitle());
			pstmt.setString(2, vo.getBbsContent());
			pstmt.setInt(3, vo.getBbsNo());

			num1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num1;
	}

	public int deleteBbs(int bbsNo) {
		int num2 = 0;
		String sql = "DELETE from bbs where bbs_no=?";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, bbsNo);
			num2 = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num2;
	}

}
