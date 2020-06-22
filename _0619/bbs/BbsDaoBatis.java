package kr.ac.kopo.bbs;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.comm.MyBatisUtils;
import kr.ac.kopo.member.MemberVo;

public class BbsDaoBatis implements BbsDao{

	 private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

	
	@Override
	public List<BbsVo> selectBbsList() {
		List<BbsVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//		실행할 SQL문 종류와 같은 이름의 메서들르 사용하여 SQL문 실행
			//		첫번재 인자로, 실행할 SQL문의 (namespace 포함) id를 지정
			list = session.selectList("kr.ac.kopo.bbs.BbsDao.selectBbsList");
			}

		return list;
	}

	@Override
	public BbsVo selectBbs(int bbsNo) {
		BbsVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//SQL문 실행시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			vo = session.selectOne("kr.ac.kopo.bbs.BbsDao.selectBbs",bbsNo);
			}

		return vo;
	}

	@Override
	public int insertBbs(BbsVo vo) {
		int num = 0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.insert("kr.ac.kopo.bbs.BbsDao.insertBbs", vo);
			session.commit();
			}
		return 0;
	}

	@Override
	public int updateBbs(BbsVo vo) {
		int num=0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.update("kr.ac.kopo.bbs.BbsDao.updateBbs", vo);
			session.commit();
			}		
		return 0;
	}
	

	@Override
	public int deleteBbs(int bbsNo) {
		int num=0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.delete("kr.ac.kopo.bbs.BbsDao.deleteBbs", bbsNo);
			session.commit();
			}		
		return 0;
	}

}
