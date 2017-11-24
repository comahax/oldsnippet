package net.gmcc.pboss.b2mservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

public class MonthdetailTest extends AbstractB2MTest {
	
	public MonthdetailTest(){
		super();
	}

	@Override
	protected Monthdetailrequest buildRequest() {
		// TODO Auto-generated method stub
		Monthdetailrequest req = new Monthdetailrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthdetail");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+"1");
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthdetailrequest.Msgbody reqbody = new Monthdetailrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201212");
		req.setMsgbody(reqbody);		
		
		return req;
	}

	@Override
	protected void parseResponse(Object rsp) {
		// TODO Auto-generated method stub
		Monthdetailresponse rsp2 = (Monthdetailresponse)rsp;
		if(rsp2.getMsgrspheader().getRetinfo().getRettype()==0){
			System.out.println("结果数据：...");
		}else{
			System.out.println("查询失败信息："+rsp2.getMsgrspheader().getRetinfo().getRetmsg());
		}
	}
	
	protected void testHead(){
		Monthdetailrequest req = new Monthdetailrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("");
		reqhead.setProcessCode(null);
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthdetailrequest.Msgbody reqbody = new Monthdetailrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201212");
		req.setMsgbody(reqbody);		
		Monthdetailresponse rsp = this.client.monthdetail(req);
		this.parseResponse(rsp);
	}
	protected void testBody(){
		Monthdetailrequest req = new Monthdetailrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthdetail");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthdetailrequest.Msgbody reqbody = new Monthdetailrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("2012111");
		req.setMsgbody(reqbody);		
		Monthdetailresponse rsp = this.client.monthdetail(req);
		this.parseResponse(rsp);
	}
	protected void testLogicFail(){
		Monthdetailrequest req = new Monthdetailrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthdetail");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthdetailrequest.Msgbody reqbody = new Monthdetailrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201211");
		req.setMsgbody(reqbody);		
		Monthdetailresponse rsp = this.client.monthdetail(req);
		this.parseResponse(rsp);
	}
	protected void testLogicSucc(){
		Monthdetailrequest req = new Monthdetailrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthdetail");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthdetailrequest.Msgbody reqbody = new Monthdetailrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201212");
		req.setMsgbody(reqbody);		
		Monthdetailresponse rsp = this.client.monthdetail(req);
		this.parseResponse(rsp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonthdetailTest test = new MonthdetailTest();
		test.service();
		System.exit(0);
	}

}
