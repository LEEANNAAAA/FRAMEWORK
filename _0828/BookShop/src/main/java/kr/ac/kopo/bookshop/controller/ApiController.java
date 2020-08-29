package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.service.BookService;
import kr.ac.kopo.bookshop.util.Pager;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	BookService service;
	
	// @ResponseBody > restController가 없을 경우 계속 responsebody를 붙여줘야 함 
	// 바로 list로 받을 수 있음(model x) > jsp로 못보냄
	//이미 만들어져있는 코드이기때문에 별도로 코드설계 할 필요 없다
	//(주세요)post에는 정보가 들어가지 못함 /get?>단순한 정보를 얻는 경우 / post를 사용하는 이유는 pager를 살리기 위해서
	// list는 상대적으로 복잡한 기능이기 떄문에 post로 / get말고 post로
	@PostMapping 
 	List<Book> list(@RequestBody Pager pager) {
		return service.list(pager);
	}
	
	//postman으로 실행 안됨
	//	@DeleteMapping("/{bookid}") //정보를 담을 수 없음, url로
	//	void delete(@PathVariable int bookid) {
	//		service.delete(bookid);
	//	}
	
	//@RequestBody : HTTP 요청의 body 내용을 자바 객체로 매핑하는 역할
	@DeleteMapping
	void delete(@RequestBody Book item) {
		service.delete(item.getBookid());
	}
	
	@PutMapping //쑤셔넣는거
	void add(@RequestBody Book item) {
		service.add(item);
	}
	
	@PatchMapping //떔질하는거
	void update(@RequestBody Book item) {
		service.update(item);
	}
	
}	
