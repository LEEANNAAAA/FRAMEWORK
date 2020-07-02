package kr.ac.kopo.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.ac.kopo.comm.MyBatisUtils;

public class MemberDaoBatis implements MemberDao{
	
	 private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

	 private MemberDaoBatis() { }
	 private static MemberDao memberDao = new MemberDaoBatis();	//하나 만들고
		public static MemberDao getInstance() {	//누가 요청하면 return값으로 줌
			return memberDao;
		}
	
	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//		실행할 SQL문 종류와 같은 이름의 메서들르 사용하여 SQL문 실행
			//		첫번재 인자로, 실행할 SQL문의 (namespace 포함) id를 지정
			list = session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");
			}

		return list;
	}

	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//SQL문 실행시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectMember",memId);
			}

		return vo;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.insert("kr.ac.kopo.member.MemberDao.insertMember", vo);
			session.commit();
			}
		return 0;
	}

	@Override
	public int updateMember(MemberVo vo) {
		int num=0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.update("kr.ac.kopo.member.MemberDao.updateMember", vo);
			session.commit();
			}		
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		int num=0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.delete("kr.ac.kopo.member.MemberDao.deleteMember", memId);
			session.commit();
			}		
		return 0;
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			vo = session.selectOne("kr.ac.kopo.member.MemberDao.selectLoginMember",memberVo);
			}

		return vo;
	}

		
	
}
