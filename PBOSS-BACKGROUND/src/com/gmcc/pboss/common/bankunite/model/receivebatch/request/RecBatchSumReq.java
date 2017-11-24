package com.gmcc.pboss.common.bankunite.model.receivebatch.request;


public class RecBatchSumReq{

	
	private String business_code;
	private String merchant_id;
	private String submit_time;
	private Long total_item;
	private Long total_sum;
	
	
	
	
	
	
	public RecBatchSumReq(String business_code, String merchant_id,
			String submit_time, Long total_item, Long total_sum) {
		super();
		this.business_code = business_code;
		this.merchant_id = merchant_id;
		this.submit_time = submit_time;
		this.total_item = total_item;
		this.total_sum = total_sum;
	}
	public RecBatchSumReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getSubmit_time() {
		return submit_time;
	}
	public void setSubmit_time(String submit_time) {
		this.submit_time = submit_time;
	}
	public Long getTotal_item() {
		return total_item;
	}
	public void setTotal_item(Long total_item) {
		this.total_item = total_item;
	}
	public Long getTotal_sum() {
		return total_sum;
	}
	public void setTotal_sum(Long total_sum) {
		this.total_sum = total_sum;
	}
	
	
	

}
