package com.gmcc.pboss.common.bankunite.model.receivebatch.response;

import java.util.List;


import com.gmcc.pboss.common.bankunite.model.base.response.BaseResponse;

public class RecBatchResponse extends BaseResponse{
	
	
	private RecBatchInfoRes info;
	private List<RecBatchDetailsRes> ret_Details;
	
	
	
	
	public RecBatchResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RecBatchResponse(RecBatchInfoRes info,
			List<RecBatchDetailsRes> ret_Details) {
		super();
		this.info = info;
		this.ret_Details = ret_Details;
	}
	public RecBatchInfoRes getInfo() {
		return info;
	}
	public void setInfo(RecBatchInfoRes info) {
		this.info = info;
	}
	public List<RecBatchDetailsRes> getRet_Details() {
		return ret_Details;
	}
	public void setRet_Details(List<RecBatchDetailsRes> ret_Details) {
		this.ret_Details = ret_Details;
	}

	public Class getSubCls() {
		return RecBatchDetailsRes.class;
	}
	
	
}
