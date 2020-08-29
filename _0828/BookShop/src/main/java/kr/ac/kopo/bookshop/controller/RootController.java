package kr.ac.kopo.bookshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.service.CustomerService;

@Controller
public class RootController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@PostMapping("/login")
	String login(Customer item, HttpSession session) {
		if(service.login(item)) {
			session.setAttribute("user", item);
			
			return "redirect:/";	//본페이지로,  /를 하는 이유는 어디서든 로그인 로그아웃을 하기위하여
		}
		
		return "login";
	}
	
	@RequestMapping("/logout")
	String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("/customer/list")
	String customer() {
		return "customer";
	}
	@RequestMapping("/order/list")
	String order() {
		return "order";
	}
}
