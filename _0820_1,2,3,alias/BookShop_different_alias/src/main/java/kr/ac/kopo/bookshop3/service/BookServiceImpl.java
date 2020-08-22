package kr.ac.kopo.bookshop3.service;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop3.dao.BookDao;
import kr.ac.kopo.bookshop3.model.Book3;
import kr.ac.kopo.bookshop3.util.Ppager;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao dao;
	
	@Override
	public List<Book3> list(Ppager fager) {
		int total = dao.total(fager);
		fager.setTotal((float)total);
		return dao.list(fager);
	}

	@Override
	public void add(Book3 plus) {
		dao.add(plus);
	}

	@Override
	public void update(Book3 upd2) {
		dao.update(upd2);
	}

	@Override
	public void delete(int bookid) {
		dao.delete(bookid);
	}

	@Override
	public Book3 item(int bookid) {
		return dao.item(bookid);
	}

	@Override
	public void dummy() {
		for(int index=11; index<100; index++) {
			Book3 dum = new Book3();
			
			dum.setBookid(index);
			dum.setBookname("도서명"+index);
			dum.setPublisher("출판사"+index);
			dum.setPrice(index);
			
			dao.add(dum);
			
		}
	}

	@Override
	public void init() {
		for(int index=11; index<100; index++) {
			dao.delete(index);
		}
	}


}
