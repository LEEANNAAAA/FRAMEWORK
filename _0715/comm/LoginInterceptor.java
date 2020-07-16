package kr.ac.kopo.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.member.MemberVo;

//핸들러인터셉터(HandlerInterceptor)
//-컨트롤러(@Controller)가 실행되기 전과 후에 실행되는 객체
//-필터(Filter)는 스프링(DispatcherServlet) 실행 전과 후에 실행되는 객체이고,
//핸들러인터셉터는 스프링(DispatcherServlet) 실행 후에 스프링을 통해서 실행된다.
//-다수의 컨트롤러에서 공통적으로 수행해야하는 작업을 실행하기에 적합
//-HandlerInterceptor 인터페이스를 구현하거나,
//HandlerInterceptorAdapter 클래스를 상쇽하여 구현
//public class LoginInterceptor implements HandlerInterceptor {
public class LoginInterceptor extends HandlerInterceptorAdapter {

	//컨트롤러(@Controller)가 실행되기 전에 실행되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor : preHandle!");
		//로그인 검사 수행
		HttpSession session = request.getSession();	//현재요청이 속한 세션객체 가져오기
		MemberVo loginVo = (MemberVo)session.getAttribute("loginUser");	
		
		if(loginVo==null) {	//로그인하지 않은 경우
			//로그인화면으로 이동
			response.sendRedirect(request.getContextPath()+"/member/login.do");	//forward를 사용할 경우 주소는 바뀌지 않고 화면만 변함
			return false;	//컨트롤러 실행하지 않음
		}
		return true;	//컨트롤러 실행
		//반환값을 사용하여 이후에 실행될 인터셉터와 컨트롤러의 실행 여부를 결정
	}

	//컨트롤러(@Controller)가 실행된 후에, 화면 출력(JSP실행)전에 실행되는 메서드
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		System.out.println("LoginInterceptor : postHandle!");
//	}

	//화면 출력(JSP실행)까지 끝난 후에 실행되는 메서드
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		System.out.println("LoginInterceptor : afterCompletion!");
//	}
	
	
}
