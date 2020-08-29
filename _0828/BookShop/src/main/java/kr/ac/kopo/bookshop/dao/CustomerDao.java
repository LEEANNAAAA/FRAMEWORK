package kr.ac.kopo.bookshop.dao;

import kr.ac.kopo.bookshop.model.Customer;

public interface CustomerDao {

	int login(Customer item);
	//int로 처리하고 로그인이 1이면 true처리
}
