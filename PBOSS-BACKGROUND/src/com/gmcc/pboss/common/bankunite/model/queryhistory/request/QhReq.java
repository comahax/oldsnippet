package com.gmcc.pboss.common.bankunite.model.queryhistory.request;


import com.gmcc.pboss.common.bankunite.model.base.request.BaseRequest;

public class QhReq extends BaseRequest {

	private QhInfoReq info;
	private QhQuery_transReq query_trans;

	public QhInfoReq getInfo() {
		return info;
	}

	public void setInfo(QhInfoReq info) {
		this.info = info;
	}

	public QhQuery_transReq getQuery_trans() {
		return query_trans;
	}

	public void setQuery_trans(QhQuery_transReq query_trans) {
		this.query_trans = query_trans;
	}

	public QhReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QhReq(QhInfoReq info, QhQuery_transReq query_trans) {
		super();
		this.info = info;
		this.query_trans = query_trans;
	}

	public static void main(String args[]) {

		QhReq qhReq = new QhReq();

		QhInfoReq info = new QhInfoReq();
		QhQuery_transReq qhQuery_transReq = new QhQuery_transReq();
		

		info.setData_type((short) 1);
		info.setReq_sn("limin");
		info.setSigned_msg("zlj");
		info.setTrx_code("xiaopang");
		info.setUser_name("user");
		info.setUser_pass("pwd");
		info.setVersion("V10.0");

		qhQuery_transReq.setBegin_date("20120112");
		qhQuery_transReq.setEnd_date("20120122");
		qhQuery_transReq.setMerchant_id("123456");
		qhQuery_transReq.setPage_size(20);
		
		
		qhReq.setInfo(info);
		qhReq.setQuery_trans(qhQuery_transReq);

		

		try {
			FIRSTELEMENT="info";
			SECONDELEMENT="query_trans";
			
			String s = qhReq.toXml(qhReq);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
