package org.jin.domain;

public class Cirteria {
	
	// ������ ��ȣ
	private int pageNum;
	
	// ������ �� ������ ��
	private int amount;
	
	public Cirteria() {
		this(1, 10);		// ������ ���۽� pageNum = 1, amount = 10���� �ʱ�ȭ
	}
	public Cirteria(int pageNum, int amonut) {
		this.pageNum = pageNum;
		this.amount = amonut;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		// ������ ���� �� �ʱ�ȭ ���
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
		// ������ ���� �� �ʱ�ȭ ���
		if(amount <= 0 || amount > 100) {
			this.amount = 10;
			return;
		}
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Cirteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}
}
