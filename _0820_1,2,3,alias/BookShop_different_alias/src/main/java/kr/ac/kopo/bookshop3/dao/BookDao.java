package kr.ac.kopo.bookshop3.dao;

import java.util.List;

import kr.ac.kopo.bookshop3.model.Book3;
import kr.ac.kopo.bookshop3.util.Ppager;

public interface BookDao {

	List<Book3> list(Ppager fager);

	void add(Book3 plus);

	void update(Book3 upd2);

	void delete(int bookid);

	Book3 item(int bookid);

	int total(Ppager fager);



}
