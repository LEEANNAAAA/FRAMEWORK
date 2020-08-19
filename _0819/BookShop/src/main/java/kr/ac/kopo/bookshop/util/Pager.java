package kr.ac.kopo.bookshop.util;

public class Pager {
	int page = 1;
	int perPage = 10;
	float total;
	
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
	
}
