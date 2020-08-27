package kr.ac.kopo.bookshop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.bookshop.model.Customer;

public class UserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Customer customer = (Customer) session.getAttribute("user");
		
		if(customer != null) {
			return true;
		}
		
		response.sendRedirect("/login");
		return false;
				
	}

}
