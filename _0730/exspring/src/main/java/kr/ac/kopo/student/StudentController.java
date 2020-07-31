package kr.ac.kopo.student;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	//컨테이너 설정 정보를 담는 파일들을 가져올 때 사용
	@Resource(name = "studentService")
	private StudentService studentService;

	@RequestMapping("/student/list.do")
	protected String list(Map modelMap) {
		
		List<StudentVo> list = studentService.selectStudentList();

		modelMap.put("stuList", list); 
		
		return "student/list";
	}
/////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/student/add.do", method = RequestMethod.GET)
	public String addform() {
		return "student/addform";
	}
	
	@RequestMapping(value="/student/add.do", method = RequestMethod.POST)
	public String add(StudentVo vo) {	
//		req.setCharacterEncoding("UTF-8");
		
		int num1 = studentService.insertStudent(vo);
		System.out.println(num1 + "명의 학생 추가");
		
		return "redirect:/student/list.do";
	}
/////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/student/edit.do", method = RequestMethod.GET)
	public String editform(String stuNo, Map modelMap) {

		StudentVo vo = studentService.selectStudent(stuNo);
		modelMap.put("stuVo", vo);

		return "student/editform";
	}
	
	@RequestMapping(value="/student/edit.do", method = RequestMethod.POST)
	public String edit(StudentVo vo) {
//		req.setCharacterEncoding("UTF-8");

		int num1 = studentService.updateStudent(vo);
		System.out.println(num1 + "명의 학생 수정");
		
		return "redirect:/student/list.do";
	}
/////////////////////////////////////////////////////////////////////////////
	@RequestMapping("/student/del.do")
	public String del(String stuNo) {

		int num2 = studentService.deleteStudent(stuNo);
		System.out.println(num2 + "명의 학생 삭제");
		return "redirect:/student/list.do";
	}
}
