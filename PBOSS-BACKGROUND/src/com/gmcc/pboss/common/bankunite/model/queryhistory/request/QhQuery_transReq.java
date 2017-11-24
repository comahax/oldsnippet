package com.gmcc.pboss.common.bankunite.model.queryhistory.request;

public class QhQuery_transReq {


	
	private String merchant_id;
	private String query_sn;
	private String begin_date;
	private String end_date;
	private Integer page_num;
	private Integer page_size;
	private Short result_type;
	private Short need_detail;
	private String query_remark;
	
	
	
	
	
	public QhQuery_transReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QhQuery_transReq(String merchant_id, String query_sn,
			String begin_date, String end_date, Integer page_num,
			Integer page_size, Short result_type, Short need_detail,
			String query_remark) {
		super();
		this.merchant_id = merchant_id;
		this.query_sn = query_sn;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.page_num = page_num;
		this.page_size = page_size;
		this.result_type = result_type;
		this.need_detail = need_detail;
		this.query_remark = query_remark;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getQuery_sn() {
		return query_sn;
	}
	public void setQuery_sn(String query_sn) {
		this.query_sn = query_sn;
	}
	public String getBegin_date() {
		return begin_date;
	}
	public void setBegin_date(String begin_date) {
		this.begin_date = begin_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer page_num) {
		this.page_num = page_num;
	}
	public Integer getPage_size() {
		return page_size;
	}
	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}
	public Short getResult_type() {
		return result_type;
	}
	public void setResult_type(Short result_type) {
		this.result_type = result_type;
	}
	public Short getNeed_detail() {
		return need_detail;
	}
	public void setNeed_detail(Short need_detail) {
		this.need_detail = need_detail;
	}
	public String getQuery_remark() {
		return query_remark;
	}
	public void setQuery_remark(String query_remark) {
		this.query_remark = query_remark;
	}
	
	
}
