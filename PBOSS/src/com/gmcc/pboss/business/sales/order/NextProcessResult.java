package com.gmcc.pboss.business.sales.order;

import java.io.Serializable;

public class NextProcessResult implements Serializable,Comparable<NextProcessResult> {
	private int mark;
	private String orderid;
	private String message;

	public NextProcessResult(){}
	
	public NextProcessResult(int mark, String orderid, String message) {
		super();
		this.mark = mark;
		this.orderid = orderid;
		this.message = message;
	}
	
	//比较方法
	public int compareTo(NextProcessResult o){
		if(this.mark < o.mark){
			return -1;
		}
		else if(this.mark > o.mark){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
