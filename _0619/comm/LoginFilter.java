package kr.ac.kopo.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.member.MemberVo;

//1.회원추가 기능도 로그인 없이 사용 가능하도록 LoginFilter를 변경
//2.로그인 안 한 경우에는, [로그인][회원가입]메뉴가 나오고,
//로그인 한 경우에는, [회원관리][게시판][학생관리][로그아웃] 메뉴가 나오도록
//menu.jsp를 변경
//3.게시판에 새 글을 쓸 경우에 로그인한 사람의 아이디가 자동으로 글작성자로 저장


//필터(Filter) : 지정된 주소로 요청이 왔을 때, 서블릿의 실행 전과 후에 실행되는 클래스
// 	- 여러 서블릿들에서 공통적으로 실행해야 하는 전처리/후처리 작업 구현시 사용
//	- 등록방법
//		(1) @WebFiltr("요청주소")를 필터 클래스에 적용하여 등록
//		(2) web.xml 설정파일에 등록

@WebFilter("/*")
public class LoginFilter implements Filter {

	private ArrayList<String> whiteList = new ArrayList<String>();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 객체가 처음 생성된 후, 1번만 실행
		System.out.println("LoginFilter의 init 실행!");
		
		whiteList.add("/member/login.do");
		whiteList.add("/member/add.do");
	}
	
	@Override	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//이 필터에 지정된 주소로 요청이 올때마다 1번씩 실행 (doFilter)
		System.out.println("LoginFilter의 doFilter 실행!");	
		
		//다음 필터 또는 서블릿 실행 전에 수행할 작업들	
		HttpServletRequest req = (HttpServletRequest) request;	//ServletRequest가 조상 클래스, 우리한테 전달이 되는것은 HttpServletRequest이기 때문에 형태 변환을 시켜줘서 맞춘다.
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURI());
		
		//RequestURI에서 Context Path를 제외한 뒷부분의 경로만 추출, substring : 뒤에 문자 자르기
		String reqPath = req.getRequestURI().substring(req.getContextPath().length());

//		whiteList.contains(req.getRequestURI()); 	//여기에는 contextPath가 포함되어있음
		
		if(whiteList.contains(reqPath)==false) {	//요청주소가 whiteList에 없는 경우
			//로그인 검사 수행	
			HttpSession session = req.getSession();	//현재요청이 속한 세션객체 가져오기
			MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");	
			
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
	
	@Override
	public void destroy() {
		// 필터 객체가 소멸되기 전에 1번만 실행 (init이 앞에 destroy가 뒤에), 자원같은 것들을 반납하는
	}
	
	
}
