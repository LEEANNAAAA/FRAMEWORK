package kr.ac.kopo.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	@Override
	public List<StudentVo> selectStudentList() {
		return studentDao.selectStudentList();
	}

	@Override
	public StudentVo selectStudent(String stuNo) {
		return studentDao.selectStudent(stuNo);
	}

	@Override
	public int insertStudent(StudentVo vo) {
		return studentDao.insertStudent(vo);
	}

	@Override
	public int updateStudent(StudentVo vo) {
		return studentDao.updateStudent(vo);
	}

	@Override
	public int deleteStudent(String stuNo) {
		return studentDao.deleteStudent(stuNo);
	}

}
