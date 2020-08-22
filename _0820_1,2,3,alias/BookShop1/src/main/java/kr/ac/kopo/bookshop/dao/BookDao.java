package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Book;

public interface BookDao {

	List<Book> list();

	void add(Book item);

	void delete(int bookid);

	Book item(int bookid);

	void update(Book item);

}
