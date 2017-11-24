package com.gmcc.pboss.common.bankunite.model.realtimereceive.request;

import java.util.List;

import com.gmcc.pboss.common.bankunite.model.base.request.BaseRequest;

public class RealTimeReceiveRequest extends BaseRequest {

	// 每一个属性的名称都代表了一个报文标签
	private RealTimeReceiveInfoReq info;
	private RealTimeReceiveSumReq trans_Sum;
	private List<RealTimeReceiveDetailsReq> trans_Details;

	public RealTimeReceiveRequest(RealTimeReceiveInfoReq info,
			RealTimeReceiveSumReq trans_Sum,
			List<RealTimeReceiveDetailsReq> trans_Details) {
		super();
		this.info = info;
		this.trans_Sum = trans_Sum;
		this.trans_Details = trans_Details;
	}

	public RealTimeReceiveRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RealTimeReceiveInfoReq getInfo() {
		return info;
	}

	public void setInfo(RealTimeReceiveInfoReq info) {
		this.info = info;
	}

	public RealTimeReceiveSumReq getTrans_Sum() {
		return trans_Sum;
	}

	public void setTrans_Sum(RealTimeReceiveSumReq trans_Sum) {
		this.trans_Sum = trans_Sum;
	}

	public List<RealTimeReceiveDetailsReq> getTrans_Details() {
		return trans_Details;
	}

	public void setTrans_Details(List<RealTimeReceiveDetailsReq> trans_Details) {
		this.trans_Details = trans_Details;
	}

}
