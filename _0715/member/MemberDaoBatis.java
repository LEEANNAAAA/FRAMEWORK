package kr.ac.kopo.member;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

//이 객체를 DAO(Repository)역할을 하는 객체로서 "memberDao"라는 이름으로 스프링에 등록 
//@Repository("memberDao")
public class MemberDaoBatis implements MemberDao{
//	@Resource(name="sqlSessionFactory")
//	 private SqlSessionFactory sqlSessionFactory;

	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public List<MemberVo> selectMemberList() {
		//List<MemberVo> list = null;
		//		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//		실행할 SQL문 종류와 같은 이름의 메서들르 사용하여 SQL문 실행
			//		첫번재 인자로, 실행할 SQL문의 (namespace 포함) id를 지정
		//	list = session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");
		//		}

		return session.selectList("kr.ac.kopo.member.MemberDao.selectMemberList");
	}

	@Override
	public MemberVo selectMember(String memId) {

		return session.selectOne("kr.ac.kopo.member.MemberDao.selectMember",memId);
	}

	@Override
	public int insertMember(MemberVo vo) {

		return session.insert("kr.ac.kopo.member.MemberDao.insertMember", vo);
	}

	@Override
	public int updateMember(MemberVo vo) {

		return session.update("kr.ac.kopo.member.MemberDao.updateMember", vo);
	}

	@Override
	public int deleteMember(String memId) {
	
		return session.delete("kr.ac.kopo.member.MemberDao.deleteMember", memId);
	}

	@Override
	public MemberVo selectLoginMember(MemberVo memberVo) {

		return session.selectOne("kr.ac.kopo.member.MemberDao.selectLoginMember",memberVo);
	}

		
	
}
