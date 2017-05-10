package org.zerock.domain;

public class Criteria {

	private int page,pageNum;

	
	public Criteria() {
		this.page = 1;
		this.pageNum =10;
	}

	public int getskip(){
		return (page-1)*pageNum;
	}
	
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
}
