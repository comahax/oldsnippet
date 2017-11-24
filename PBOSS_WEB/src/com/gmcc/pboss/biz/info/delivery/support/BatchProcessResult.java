package com.gmcc.pboss.biz.info.delivery.support;

import java.io.Serializable;

public class BatchProcessResult implements Serializable, Comparable<BatchProcessResult> {
	private int mark;
	private String recid;
	private String message;
	
	
	public BatchProcessResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BatchProcessResult(int mark, String recid, String message) {
		super();
		this.mark = mark;
		this.recid = recid;
		this.message = message;
	}

	//比较方法
	public int compareTo(BatchProcessResult o){
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


	public String getRecid() {
		return recid;
	}


	public void setRecid(String recid) {
		this.recid = recid;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mark;
		result = prime * result + ((recid == null) ? 0 : recid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchProcessResult other = (BatchProcessResult) obj;
		if (mark != other.mark)
			return false;
		if (recid == null) {
			if (other.recid != null)
				return false;
		} else if (!recid.equals(other.recid))
			return false;
		return true;
	}
}
