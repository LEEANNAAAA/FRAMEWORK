package kr.ac.kopo.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.member.MemberVo;

@Controller
public class ReplyController {
	
	@Resource
	private ReplyService replyService;
	
	@RequestMapping("/reply/add.do")
	@ResponseBody
	public Map<String, Object> add(ReplyVo vo, HttpSession session) {
		//로그인한 유저가 댓글을 쓰는 작성자임
		MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");
		vo.setRepWriter(loginVo.getMemId());

		int num = replyService.insert(vo);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", num);
		
		return map; //{result:1} 맞으면 1 틀리면 0
	
	}
	
	@RequestMapping("/reply/list.do")
	@ResponseBody
	public List<ReplyVo> list(int repBbsNo) {
		List<ReplyVo> replyList = replyService.selectList(repBbsNo);
		return replyList;
	}
}
