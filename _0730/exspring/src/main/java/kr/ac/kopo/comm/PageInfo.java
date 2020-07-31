package kr.ac.kopo.comm;

public class PageInfo {
	private int page = 1; // 현재 페이지 번호 yes
	private int size = 5; // 한 페이지당 게시되는 게시물 건 수 yes
	private int pageSize = 3; // 페이지 리스트에 게시되는 페이지 건수 yes 게시판 맨 아래 페이지
	private int totalRecordCount; // 전체 게시물 건 수 yes

	private int totalPageCount; // 전체 페이지 개수 no
	private int firstPageNoOnPageList; // 페이지 리스트의 첫 페이지 번호 no
	private int lastPageNoOnPageList; // 페이지 리스트의 마지막 페이지 번호 no
	private int firstRecordIndex; // 페이징 SQL의 조건절에 사용되는 시작 rownum no
	private int lastRecordIndex; // 페이징 SQL의 조건절에 사용되는 마지막 rownum no

	private String pageHtml = "";

	public void renderHTML() {
		totalPageCount = ((totalRecordCount - 1) / size) + 1;
		firstPageNoOnPageList = ((page - 1) / pageSize) * pageSize + 1;
		lastPageNoOnPageList = firstPageNoOnPageList + pageSize - 1;
		if (lastPageNoOnPageList > totalPageCount) {

			lastPageNoOnPageList = totalPageCount;
		}

		firstRecordIndex = (page - 1) * size + 1;
		lastRecordIndex = page * size;

		// 이전페이지와 다음페이지가 없을 경우,
		// [이전]과 [다음]에 링크가 걸지 않도록 설정
		pageHtml += "<div>";
		pageHtml += "<a href='#' onclick='goPage(1); return false;'>[처음]</a>";
		if (page != 1) {
			pageHtml += "<a href='#' onclick='goPage(" + (page - 1) + "); return false;'>[이전]</a>";
		}

		for (int i = firstPageNoOnPageList; i <= lastPageNoOnPageList; i++) {
			if (i == page) {
				pageHtml += "<strong>{" + i + "}</strong>";
			} else {
				pageHtml += "<a href='#' onclick='goPage(" + i + "); return false;'>{" + i + "}</a>";
			}
		}

		if (page != totalPageCount) {
			pageHtml += "<a href='#' onclick='goPage(" + (page + 1) + "); return false;'>[다음]</a>";
		}
		pageHtml += "<a href='#' onclick='goPage(" + totalPageCount + "); return false;'>[마지막]</a>";
		pageHtml += "</div>";

		pageHtml += "<script>function goPage(p) {location.href = location.pathname + '?page='+p;}</script>\r\n";

	}

	public String getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPageNoOnPageList() {
		return firstPageNoOnPageList;
	}

	public void setFirstPageNoOnPageList(int firstPageNoOnPageList) {
		this.firstPageNoOnPageList = firstPageNoOnPageList;
	}

	public int getLastPageNoOnPageList() {
		return lastPageNoOnPageList;
	}

	public void setLastPageNoOnPageList(int lastPageNoOnPageList) {
		this.lastPageNoOnPageList = lastPageNoOnPageList;
	}

	public int getFirstRecordIndex() {
		return firstRecordIndex;
	}

	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	public void setLastRecordIndex(int lastRecordIndex) {
		this.lastRecordIndex = lastRecordIndex;
	}

}
