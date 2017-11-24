package com.gmcc.pboss.common.bankunite.model.queryhistory.response;

public class QhQuery_transRes {

	
	
	
	private String query_sn;
	private String query_remark;
	private Integer page_sum;
	public QhQuery_transRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QhQuery_transRes(String query_sn, String query_remark,
			Integer page_sum) {
		super();
		this.query_sn = query_sn;
		this.query_remark = query_remark;
		this.page_sum = page_sum;
	}
	public String getQuery_sn() {
		return query_sn;
	}
	public void setQuery_sn(String query_sn) {
		this.query_sn = query_sn;
	}
	public String getQuery_remark() {
		return query_remark;
	}
	public void setQuery_remark(String query_remark) {
		this.query_remark = query_remark;
	}
	public Integer getPage_sum() {
		return page_sum;
	}
	public void setPage_sum(Integer page_sum) {
		this.page_sum = page_sum;
	}
	
	

	
	
	
	
}
