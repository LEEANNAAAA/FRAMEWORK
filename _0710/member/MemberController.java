package kr.ac.kopo.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@WebServlet("/member/list.do")
@Controller
public class MemberController { // 일반객체

//	@Autowired, @Inject, @Resource중 하나를 사용하여 스프링에 등록된 객체를 주입
	// controller가 memberService를 받을 수 있도록
	@Resource(name = "memberService")
	private MemberService memberService;

//	@RequestMapping(value="/member/list.do", method = RequestMethod.GET)
	@RequestMapping("/member/list.do")
	public String list(Map modelMap) {

		List<MemberVo> list = memberService.selectMemberList();

		modelMap.put("memList", list); // 모델에 "memList라는 이름으로 list를 저장

		return "member/memList";
	}

	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String addform() {
		return "member/memAddForm";
	}

	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String add(MemberVo vo) {

		int num1 = memberService.insertMember(vo);
		System.out.println(num1 + "명의 회원 추가");

		return "redirect:/member/list.do";

	}

	@RequestMapping(value = "/member/edit.do", method = RequestMethod.GET)
	public String editform(String memId, Map modelMap) {

		MemberVo vo = memberService.selectMember(memId);
		modelMap.put("memVo", vo);
		return "member/memEditForm";
	}

	@RequestMapping(value = "/member/edit.do", method = RequestMethod.POST)
	public String edit(MemberVo vo) {
//		req.setCharacterEncoding("UTF-8");

		int num1 = memberService.updateMember(vo);
		System.out.println(num1 + "명의 회원 수정");

		return "redirect:/member/list.do";
	}

	@RequestMapping("/member/del.do")
	public String del(String memId) {
		int num2 = memberService.deleteMember(memId);
		System.out.println(num2 + "명의 학생 삭제");
		return "redirect:/member/list.do";
	}

	@RequestMapping(value = "/member/login.do", method = RequestMethod.GET)
	public String loginform() {
		return "member/login";
	}

	@RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	public String login(MemberVo vo, HttpSession session) {
//		HttpServletRequest, HttpServletResponse, HttpSession 객체가 필요한 경우,
//		컨트롤러 메서드의 파라미터로 지정하면 스프링이 전달해준다
		MemberVo loginVo = memberService.selectLoginMember(vo);

		if (loginVo == null) {
			return "redirect:/member/login.do";
		} else {
			session.setAttribute("loginUser", loginVo);
			return "redirect:/member/list.do";
		}

	}
	
	@RequestMapping(value="/member/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session)  {
		session.invalidate();
		return "redirect:/member/login.do";
	}
}
