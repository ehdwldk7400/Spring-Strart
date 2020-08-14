package org.jin.domain;

public class Cirteria {
	
	// 페이지 번호
	private int pageNum;
	
	// 페이지 당 데이터 수
	private int amount;
	
	// 검색 종류(제목만, 내용만, 작성자만, 제목 + 내용)
	private String keyword;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Cirteria() {
		this(1, 10);		// 페이지 시작시 pageNum = 1, amount = 10으로 초기화
	}
	public Cirteria(int pageNum, int amonut) {
		this.pageNum = pageNum;
		this.amount = amonut;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		// 생성자 없을 시 초기화 방법
		if(pageNum <= 0) {
			this.pageNum = 1;
			return;
		}
		this.pageNum = pageNum;
	}
	
	// method  for MyBatis SQL Mapper
	public int getPageStart() {
		return (this.pageNum-1) * amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		// 생성자 없을 시 초기화 방법
		if(amount <= 0 || amount > 100) {
			this.amount = 10;
			return;
		}
		this.amount = amount;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "Cirteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + ", type=" + type + "]";
	}
	
}
