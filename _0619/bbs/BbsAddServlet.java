package kr.ac.kopo.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

@WebServlet("/bbs/add.do")
public class BbsAddServlet extends HttpServlet{
	
	BbsDao bbsDao = new BbsDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsAdd.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		
		BbsVo vo = new BbsVo();
		vo.setBbsTitle(req.getParameter("bbsTitle"));
		vo.setBbsContent(req.getParameter("bbsContent"));
		
		//로그인한 사용자와 아이디를 게시글 작성자로 강제 설정
		HttpSession session = req.getSession();
		MemberVo loginVo = (MemberVo) session.getAttribute("loginUser");
		vo.setBbsWriter(loginVo.getMemId());
		
//		vo.setBbsWriter(req.getParameter("bbsWriter")); >> 보안안됨
		
		int num = bbsDao.insertBbs(vo);
		System.out.println(num + "개의 게시글 추가");

		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
	}
}
