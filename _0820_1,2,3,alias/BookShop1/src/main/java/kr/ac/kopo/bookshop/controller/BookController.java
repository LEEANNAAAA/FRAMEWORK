package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@RequestMapping("/list")
	String list(Model model) {
		List<Book> list = service.list();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	String add() {
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	String add(Book item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@RequestMapping("/{bookid}/delete")
	String delete(@PathVariable int bookid) {
		service.delete(bookid);
		
		return "redirect:../list";
	}
	
	@RequestMapping(value="/{bookid}/update", method=RequestMethod.GET)
	String update(@PathVariable int bookid, Model model) {
		Book item = service.item(bookid);
		
		model.addAttribute("item", item);
		
		return "update";
	}
	
	@RequestMapping(value="/{bookid}/update", method=RequestMethod.POST)
	String update(@PathVariable int bookid, Book item) {
		item.setBookid(bookid);
		
		service.update(item);
		
		return "redirect:../list";
	}

}




























