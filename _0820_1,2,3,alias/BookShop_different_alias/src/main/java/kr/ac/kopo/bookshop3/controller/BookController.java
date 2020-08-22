package kr.ac.kopo.bookshop3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookshop3.model.Book3;
import kr.ac.kopo.bookshop3.service.BookService;
import kr.ac.kopo.bookshop3.util.Ppager;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@RequestMapping("/dummy")
	String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	String init() {
		service.init();
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	String listc(Model model, Ppager fager) {
		List<Book3> list3 = service.list(fager);
		model.addAttribute("liist", list3);
		
		return "list";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	String addget() {
		return "add";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	String addpost(Book3 plus) {
		service.add(plus);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/{bookid}/update", method=RequestMethod.GET)
	String updateget(@PathVariable int bookid, Model model) {
		Book3 upd1 = service.item(bookid);
		
		model.addAttribute("upd3", upd1);
		
		return "update";
	}
	
	@RequestMapping(value="/{bookid}/update", method=RequestMethod.POST)
	String updatepost(@PathVariable int bookid, Book3 upd2) {
		upd2.setBookid(bookid);
		service.update(upd2);
		return "redirect:../list";
	}
	
	@RequestMapping("/{bookid}/delete")
	String delete(@PathVariable int bookid) {
		service.delete(bookid);

		return "redirect:../list";
	}
	
}
