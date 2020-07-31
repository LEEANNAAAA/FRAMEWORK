package kr.ac.kopo.student;

import java.util.List;

public interface StudentService {

	List<StudentVo> selectStudentList();

	StudentVo selectStudent(String stuNo);

	int insertStudent(StudentVo vo);

	int updateStudent(StudentVo vo);

	int deleteStudent(String stuNo);

}