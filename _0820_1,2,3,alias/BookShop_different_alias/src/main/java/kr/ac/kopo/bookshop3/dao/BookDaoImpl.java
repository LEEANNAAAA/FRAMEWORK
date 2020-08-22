package kr.ac.kopo.bookshop3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop3.model.Book3;
import kr.ac.kopo.bookshop3.util.Ppager;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Book3> list(Ppager fager) {
		return sql.selectList("book3.list", fager);
	}

	@Override
	public void add(Book3 plus) {
		sql.insert("book3.add3", plus);
	}

	@Override
	public void update(Book3 upd2) {
		sql.update("book3.update3", upd2);
	}

	@Override
	public void delete(int bookid) {
		sql.delete("book3.delete3",bookid);
	}

	@Override
	public Book3 item(int bookid) {
		return sql.selectOne("book3.item3", bookid);
	}

	@Override
	public int total(Ppager fager) {
		return sql.selectOne("book3.total3",fager);
	}

}
