package kr.ac.kopo.bbs;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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

		String uploadDir = "C:/web/upload";	//업로드한 파일을 저장할 폴더
		
		List<MultipartFile> fileList = vo.getUpfileList();
		for(MultipartFile f : fileList) {
			System.out.println(f.getOriginalFilename()+":"+f.getSize());
			try {
				f.transferTo(new File(uploadDir, f.getOriginalFilename()));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

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
		System.out.println(num + "개의 게시글 수정");

		return "redirect:/bbs/list.do";
	}
	
	@RequestMapping(value = "/bbs/del.do")
	public String del(int bbsNo) {
		int num = bbsService.deleteBbs(bbsNo);
		System.out.println(num + "개의 게시글 삭제");

		return "redirect:/bbs/list.do";
	}
}
