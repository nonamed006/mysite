package com.douzone.mysite.vo;

public class PageVo {
	private int page;
	private int startPage;
	private int endPage;
	private int pagelen = 5;
	private int total;
	private int cntPage;
	public int Total;
	
	public PageVo() {
		super();
	}

	public PageVo(int page, int total) {
		super();
		System.out.println("상성자");
		this.page = page;
		this.total = total;
		
		this.endPage = (int) Math.ceil(page / pagelen) * pagelen;
		this.startPage = this.endPage - 4;
	}
	
	public int getCntPage() {
		return page == 1 ? 1 : (page*10) - 9;
	}

	public void setCntPage(int cntPage) {
		this.cntPage = cntPage;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	
}
