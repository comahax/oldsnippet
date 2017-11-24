package com.gmcc.pboss.common.bankunite.model.realtimereceive.response;

import java.util.List;

import com.gmcc.pboss.common.bankunite.model.base.response.BaseResponse;

public class RealTimeReceiveResponse extends BaseResponse {

	private RealTimeReceiveInfoRes info;
	private List<RealTimeReceiveDetailsRes> ret_Details;

	public RealTimeReceiveResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RealTimeReceiveResponse(RealTimeReceiveInfoRes info,
			List<RealTimeReceiveDetailsRes> ret_Details) {
		super();
		this.info = info;
		this.ret_Details = ret_Details;
	}

	public RealTimeReceiveInfoRes getInfo() {
		return info;
	}

	public void setInfo(RealTimeReceiveInfoRes info) {
		this.info = info;
	}

	public List<RealTimeReceiveDetailsRes> getRet_Details() {
		return ret_Details;
	}

	public void setRet_Details(List<RealTimeReceiveDetailsRes> ret_Details) {
		this.ret_Details = ret_Details;
	}

	public Class getSubCls() {
		return RealTimeReceiveDetailsRes.class;
	}
}
