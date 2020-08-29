package kr.ac.kopo.bookshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	@Override
	public boolean login(Customer item) {
		if(dao.login(item)==1) {
			return true;
		}
		
		return false;
	}

}
