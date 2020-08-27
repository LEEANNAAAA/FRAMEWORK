package kr.ac.kopo.bookshop.util;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	int page = 1;
	int perPage = 10;
	float total;
	int perGroup = 5;

	int search = 0;
	String keyword;
	
	int header = 1;
	int order = 0;
	

	public int getHeader() {
		return header;
	}

	public void setHeader(int header) {
		this.header = header;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getSearch() {
		return search;
	}

	public void setSearch(int search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTotal() {
		return total;
	}

	public int getPrev() {
		return page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
	}

	public int getNext() {
		int next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		return next < last ? next : last;
	}

	public int getLast() {
		return (int) Math.ceil(total / perPage);
	}

	public List<Integer> getList() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		int startPage = ((page - 1) / perGroup) * perGroup + 1;

		for (int index = startPage; index < startPage + perGroup && index <= getLast(); index++) {
			list.add(index);
		}

		return list;
	}

	//검색
	public String getQuery() {
		if (search >= 1 && search <= 4) {
			return "search=" + search + "&keyword=" + keyword;
		} else {
			return "";
		}
	}

}
