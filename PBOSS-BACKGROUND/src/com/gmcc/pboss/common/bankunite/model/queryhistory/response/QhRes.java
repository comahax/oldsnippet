package com.gmcc.pboss.common.bankunite.model.queryhistory.response;

import java.util.List;

import com.gmcc.pboss.common.bankunite.model.base.response.BaseResponse;
import com.gmcc.pboss.common.bankunite.model.receivebatch.request.RecBatchDetailsReq;
import com.gmcc.pboss.common.bankunite.model.receivebatch.response.RecBatchDetailsRes;
import com.gmcc.pboss.common.bankunite.model.receivebatch.response.RecBatchResponse;

public class QhRes extends BaseResponse {

	private QhInfoRes info;
	private QhQuery_transRes query_trans;
	private List<QhRet_detailsRes> ret_details;

	public QhRes() {
		super();
		// TODO Auto-generated constructor stub
	}



	public QhRes(QhInfoRes info, QhQuery_transRes query_trans,
			List<QhRet_detailsRes> ret_details) {
		super();
		this.info = info;
		this.query_trans = query_trans;
		this.ret_details = ret_details;
	}



	public QhInfoRes getInfo() {
		return info;
	}

	public void setInfo(QhInfoRes info) {
		this.info = info;
	}

	public QhQuery_transRes getQuery_trans() {
		return query_trans;
	}

	public void setQuery_trans(QhQuery_transRes query_trans) {
		this.query_trans = query_trans;
	}



	public List<QhRet_detailsRes> getRet_details() {
		return ret_details;
	}



	public void setRet_details(List<QhRet_detailsRes> ret_details) {
		this.ret_details = ret_details;
	}


	public Class getSubCls() {
		return QhRet_detailsRes.class;
	}
	

	public static void main(String args[]) {
		String ss = "<?xml version=\"1.0\" encoding=\"GBK\"?>"
+"<GZELINK>"
+"<INFO>"
+"<TRX_CODE>200001</TRX_CODE>"
+"<VERSION>03</VERSION>"
+"<DATA_TYPE>2</DATA_TYPE>"
+"<RET_CODE>0000</RET_CODE>"
+"<ERR_MSG/>"
+"<SIGNED_MSG>签名信息</SIGNED_MSG>"
+"</INFO>"
+"<BODY>"
+"<QUERY_TRANS>"
+"<QUERY_SN>2009041611084101</QUERY_SN>"
+"<QUERY_REMARK>查询备注</QUERY_REMARK>"
+"<PAGE_SUM>40</PAGE_SUM>"
+"</QUERY_TRANS>"
+"<RET_DETAILS>"
+"<RET_DETAIL>"
+"<ORAFILE_ID>261</ORAFILE_ID>"
+"<SN>0003</SN>"
+"<ACCOUNT>60138270140042110022</ACCOUNT>"
+"<ACCOUNT_NAME>李四</ACCOUNT_NAME>"
+"<AMOUNT>1</AMOUNT>"
+"<CUST_USERID></CUST_USERID>"
+"<COMPLETE_TIME>20091016101010</COMPLETE_TIME>"   
+"<REMARK></REMARK>"
+"<RET_CODE>0000</RET_CODE>"
+"<ERR_MSG/>"
+"</RET_DETAIL>"
+"<RET_DETAIL>"
+"<ORAFILE_ID>260</ORAFILE_ID>"
+"<SN>0002</SN>"
+"<ACCOUNT>60138270140042110022</ACCOUNT>"
+"<ACCOUNT_NAME>李四</ACCOUNT_NAME>"
+"<AMOUNT>1</AMOUNT>"
+"<CUST_USERID></CUST_USERID>"
+"<COMPLETE_TIME>20091016101010</COMPLETE_TIME>"
+"<REMARK></REMARK>    "
+"<RET_CODE>0000</RET_CODE>"
+"<ERR_MSG/>"
+"</RET_DETAIL>"
+"</RET_DETAILS>"
+"</BODY>"
+"</GZELINK>";

		QhRes qhRes = new QhRes();


		try {
			Object obj = qhRes.readStringXml(ss, QhRes.class);
			System.out.println("成功！");
// Object objj = BaseResponse.class;
// Class lcs= objj.getClass();
// System.out.println(lcs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String xmlString = "<html>" + "<head>" + "<title>dom4j解析一个例子</title>"
		// + "<script>" + "<username>yangrong</username>"
		// + "<password>123456</password>" + "</script>" + "</head>"
		// + "<body>" + "<form>" + "<banlce>1000</banlce>"
		// + "<subID>36242519880716</subID>"
		// + "<password>987654</password>" + "</form>" + "<form>"
		// + "<banlce>2000</banlce>" + "<subID>22222</subID>"
		// + "<password>3333</password>" + "</form>" + "</body>"
		// + "</html>";
		// readStringXml(xmlString);
	}
}
