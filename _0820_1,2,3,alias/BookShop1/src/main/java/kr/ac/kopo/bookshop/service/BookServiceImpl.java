package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao dao;

	@Override
	public List<Book> list() {
		return dao.list();
	}

	@Override
	public void add(Book item) {
		dao.add(item);
	}

	@Override
	public void delete(int bookid) {
		dao.delete(bookid);
	}

	@Override
	public Book item(int bookid) {
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) {
		dao.update(item);
	}

}


