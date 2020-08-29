package kr.ac.kopo.bookshop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.bookshop.model.Customer;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Customer customer = (Customer) session.getAttribute("user");
		
		if(customer == null) {
			response.sendRedirect("/login");
		} else 	if(!"admin".equals(customer.getName())) {
			response.sendRedirect("/");
		} else {
			return true;
		}
		
		return false;
	}

}
