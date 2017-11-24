package com.gmcc.pboss.common.bankunite.model.receivebatch.request;

import java.util.List;

import com.gmcc.pboss.common.bankunite.model.base.request.BaseRequest;

public class RecBatchRequest extends BaseRequest {

	
	// 每一个属性的名称都代表了一个报文标签
	private RecBatchInfoReq info;
	private RecBatchSumReq trans_Sum;
	private List<RecBatchDetailsReq> trans_Details;
	
	
	
	public RecBatchRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecBatchRequest(RecBatchInfoReq info, RecBatchSumReq trans_Sum,
			List<RecBatchDetailsReq> trans_Details) {
		super();
		this.info = info;
		this.trans_Sum = trans_Sum;
		this.trans_Details = trans_Details;
	}
	public RecBatchInfoReq getInfo() {
		return info;
	}
	public void setInfo(RecBatchInfoReq info) {
		this.info = info;
	}
	public RecBatchSumReq getTrans_Sum() {
		return trans_Sum;
	}
	public void setTrans_Sum(RecBatchSumReq trans_Sum) {
		this.trans_Sum = trans_Sum;
	}
	public List<RecBatchDetailsReq> getTrans_Details() {
		return trans_Details;
	}
	public void setTrans_Details(List<RecBatchDetailsReq> trans_Details) {
		this.trans_Details = trans_Details;
	}
	
	
		
		
	
}
