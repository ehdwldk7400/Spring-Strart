package org.jin.domain;

public class PageDTO {
	// 첫 번째 페이지
	private int startPage;
	
	// 마지막 페이지
	private int endPage;
	
	// 이전 페이지 / 다음페이지 여부
	private boolean prev, next;
	
	// 게시물 총 갯수
	private int total;
	private Cirteria cri;
	
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Cirteria getCri() {
		return cri;
	}

	public void setCri(Cirteria cri) {
		this.cri = cri;
	}

	public PageDTO(Cirteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// endPage
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage-9;
		
		int realEnd = (int)(Math.ceil(total * 1.0)/cri.getAmount());
		
		if(realEnd < endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
