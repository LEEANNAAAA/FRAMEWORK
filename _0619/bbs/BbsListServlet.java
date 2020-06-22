package kr.ac.kopo.bbs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//게시물 목록에서 등록일이 2020/06/12 09:58:37와 같은 형태로 출력되도록 변경
//게시물 상세보기 화면에서 등록일을 2020년 6월 12일 9시 58분 37초와 같은 형태로 출력

@WebServlet("/bbs/list.do")
public class BbsListServlet extends HttpServlet{
	BbsDao bbsDao = new BbsDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BbsVo> list = bbsDao.selectBbsList();
		
		req.setAttribute("bbsList", list);	//${bbsList} >  이런식으로 불러서 사용 가능
		
		req.getRequestDispatcher("/WEB-INF/jsp/bbs/bbsList.jsp").forward(req, resp);
		
		//	req.getRequestDispatcher(req.getContextPath()+"/bbsList.jsp");
		//	forward를 사용하기때문에 /exweb을 안써도 됨. 안에서 움직이는거기 때문에
	}
}
