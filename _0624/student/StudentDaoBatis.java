package kr.ac.kopo.student;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.comm.MyBatisUtils;
import kr.ac.kopo.member.MemberVo;

public class StudentDaoBatis implements StudentDao{

	 private SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

	
	@Override
	public List<StudentVo> selectStudentList() {
		List<StudentVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//		실행할 SQL문 종류와 같은 이름의 메서들르 사용하여 SQL문 실행
			//		첫번재 인자로, 실행할 SQL문의 (namespace 포함) id를 지정
			list = session.selectList("kr.ac.kopo.student.StudentDao.selectStudentList");
			}

		return list;
	}

	@Override
	public StudentVo selectStudent(String stuNo) {
		StudentVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			//SQL문 실행시 필요한 값(파라미터)이 있는 경우, 두번째 인자로 전달
			vo = session.selectOne("kr.ac.kopo.student.StudentDao.selectStudent",stuNo);
			}

		return vo;
	}

	@Override
	public int insertStudent(StudentVo vo) {
		int num = 0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.insert("kr.ac.kopo.student.StudentDao.insertStudent", vo);
			session.commit();
			}
		return 0;
	}

	@Override
	public int updateStudent(StudentVo vo) {
		int num=0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.update("kr.ac.kopo.student.StudentDao.updateStudent", vo);
			session.commit();
			}		
		return 0;
	}
	

	@Override
	public int deleteStudent(String stuNo) {
		int num=0;	
		try (SqlSession session = sqlSessionFactory.openSession()) {	//SQL문 실행을 위한 세션열기
			num = session.delete("kr.ac.kopo.student.StudentDao.deleteStudent", stuNo);
			session.commit();
			}		
		return 0;
	}

}
