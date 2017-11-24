package net.gmcc.pboss.b2mservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

public class MonthstatisticTest extends AbstractB2MTest {
	
	public MonthstatisticTest(){
		super();
	}

	@Override
	protected Monthstatisticrequest buildRequest() {
		// TODO Auto-generated method stub
		Monthstatisticrequest req = new Monthstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthstatisticrequest.Msgbody reqbody = new Monthstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201212");
		req.setMsgbody(reqbody);		
		
		return req;
	}
	
	protected void testHead(){
		Monthstatisticrequest req = new Monthstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc(null);
		reqhead.setProcessCode("");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+"XX");
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthstatisticrequest.Msgbody reqbody = new Monthstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201212");
		req.setMsgbody(reqbody);
		
		Monthstatisticresponse rsp = this.client.monthstatistic(req);
		this.parseResponse(rsp);
	}
	
	protected void testBody(){
		Monthstatisticrequest req = new Monthstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthstatisticrequest.Msgbody reqbody = new Monthstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("20121212");
		req.setMsgbody(reqbody);	
		
		Monthstatisticresponse rsp = this.client.monthstatistic(req);
		this.parseResponse(rsp);
	}
	
	protected void testLogicFail(){
		Monthstatisticrequest req = new Monthstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthstatisticrequest.Msgbody reqbody = new Monthstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201211");
		req.setMsgbody(reqbody);	
		
		Monthstatisticresponse rsp = this.client.monthstatistic(req);
		this.parseResponse(rsp);
	}
	
	protected void testLogicSucc(){
		Monthstatisticrequest req = new Monthstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("monthstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Monthstatisticrequest.Msgbody reqbody = new Monthstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		reqbody.setMonth("201212");
		req.setMsgbody(reqbody);	
		
		Monthstatisticresponse rsp = this.client.monthstatistic(req);
		this.parseResponse(rsp);
	}
	
	@Override
	protected void parseResponse(Object rsp) {
		// TODO Auto-generated method stub
		Monthstatisticresponse rsp2 = (Monthstatisticresponse)rsp;
		if(rsp2.getMsgrspheader().getRetinfo().getRettype()==0){
			System.out.println("结果数据：...");
		}else{
			System.out.println("查询失败信息："+rsp2.getMsgrspheader().getRetinfo().getRetmsg());
		}
	}
	
	public static void main(String[] args){
		MonthstatisticTest test = new MonthstatisticTest();
		test.service();
		System.exit(0);
	}

}
