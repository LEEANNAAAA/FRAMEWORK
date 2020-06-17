package kr.ac.kopo.member;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//1.회원추가 기능도 로그인 없이 사용 가능하도록 LoginFilter를 변경
//2.로그인 안 한 경우에는, [로그인][회원가입]메뉴가 나오고,
//로그인 한 경우에는, [회원관리][게시판][학생관리][로그아웃] 메뉴가 나오도록
//menu.jsp를 변경
//3.게시판에 새 글을 쓸 경우에 로그인한 사람의 아이디가 자동으로 글작성자로 저장


//필터(Filter) : 지정된 주소로 요청이 왔을 때, 서블릿의 실행 전과 후에 실행되는 클래스
@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter의 doFilter 실행!");
		
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들
		
		HttpServletRequest req = (HttpServletRequest) request;	//ServletRequest가 조상 클래스, 우리한테 전달이 되는것은 HttpServletRequest이기 때문에 형태 변환을 시켜줘서 맞춘다.
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURI());

		if(!req.getRequestURI().equals(req.getContextPath()+"/member/login.do") && !req.getRequestURI().equals(req.getContextPath()+"/member/add.do")) {
		//로그인 검사 수행	
			
			HttpSession session = req.getSession();	//현재요청이 속한 세션객체 가져오기
			MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");	//로그인한 사람의 정보가 담긴 객체를 "loginUser"에 담기
			
			if(loginVo==null) {	//로그인하지 않은 경우
				//로그인화면으로 이동
				resp.sendRedirect(req.getContextPath()+"/member/login.do");	//forward를 사용할 경우 주소는 바뀌지 않고 화면만 변함
				return;
			}
			
		}
		
		
		//다음에 실행될 필터 또는 서블릿을 실행시키라는 명령, 이걸 하지 않으면 하얀화면만 뜸
		chain.doFilter(request, response);
		
		
		//다음 필터 또는 서블릿 실행 후에 수행할 작업들
		
		
		
	}
	
}
