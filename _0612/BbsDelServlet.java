package kr.ac.kopo.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bbs/del.do")
public class BbsDelServlet extends HttpServlet{
	
	BbsDaoJdbc bbsDao = new BbsDaoJdbc();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int delNo = Integer.parseInt(req.getParameter("bbsNo"));
	
		int num = bbsDao.deleteBbs(delNo);
		System.out.println(num + "개의 게시글 삭제");

		resp.sendRedirect(req.getContextPath() + "/bbs/list.do");
	}
}
