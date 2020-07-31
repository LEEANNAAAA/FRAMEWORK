package kr.ac.kopo.bbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.member.MemberVo;

//게시물 목록에서 등록일이 2020/06/12 09:58:37와 같은 형태로 출력되도록 변경
//게시물 상세보기 화면에서 등록일을 2020년 6월 12일 9시 58분 37초와 같은 형태로 출력

@Controller
public class BbsController {
	@Resource(name = "bbsService")
	private BbsService bbsService;

	@RequestMapping(value = "/bbs/list.do")
	public String list(Map modelMap) {
		List<BbsVo> list = bbsService.selectBbsList();
		modelMap.put("bbsList", list);
		return "bbs/bbsList";
	}

	@RequestMapping(value = "/bbs/add.do", method = RequestMethod.GET)
	public String addform() {
		return "bbs/bbsAdd";
	}

	@RequestMapping(value = "/bbs/add.do", method = RequestMethod.POST)
	public String add(BbsVo vo, HttpSession session) {

		MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");
		vo.setBbsWriter(loginVo.getMemId());

		int num = bbsService.insertBbs(vo);

		return "redirect:/bbs/list.do";
	}

	@RequestMapping(value = "/bbs/edit.do", method = RequestMethod.GET)
	public String editform(int bbsNo, Map modelMap) {
		BbsVo vo = bbsService.selectBbs(bbsNo); // 해당 글을 가져오고
		modelMap.put("bbsVo", vo);

		return "bbs/bbsEdit";
	}

	@RequestMapping(value = "/bbs/edit.do", method = RequestMethod.POST)
	public String edit(BbsVo vo) {
		int num = bbsService.updateBbs(vo);

		return "redirect:/bbs/list.do";
	}

	@RequestMapping(value = "/bbs/del.do")
	public String del(int bbsNo) {
		int num = bbsService.deleteBbs(bbsNo);

		return "redirect:/bbs/list.do";
	}

	// 바이너리파일을 응답으로 전송하고 싶은 경우,
	// 컨트롤러 메서드의 반환타입은 void로 설정하고,
	// 인자로 응답객체를 받아서 응답객체에 파일 내용을 출력
	@RequestMapping(value = "/bbs/down.do")
	public void down(int attNo, HttpServletResponse resp) {
		AttachVo vo = bbsService.selectAttach(attNo);

		File f = bbsService.getAttachFile(vo); // 현재첨부파일의 서버컴퓨터 상에 저장된 파일 정보

		// 응답데이터의 내용이 바이너리파일임을 알려주기
		resp.setContentType("application/octet-stream");
		String fname = vo.getAttOrgName();
		try {
			// 한글 파일명이 깨지지 않도록, URL에 사용가능한 문자로 인코딩하고,
			// "+"문자로 변환된 공백문자를 "%20"으로 변환
			fname = URLEncoder.encode(fname, "UTF-8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		resp.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fname);

		// 파일 f의 내용을 읽어서 응답객체에 쓰기(복사)
		try {
			FileCopyUtils.copy(new FileInputStream(f), resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
