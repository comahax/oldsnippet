package net.gmcc.pboss.b2mservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

public class SumstatisticTest extends AbstractB2MTest {
	
	public SumstatisticTest(){
		super();
	}

	@Override
	protected Sumstatisticrequest buildRequest() {
		// TODO Auto-generated method stub
		Sumstatisticrequest req = new Sumstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("sunstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Sumstatisticrequest.Msgbody reqbody = new Sumstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		req.setMsgbody(reqbody);		
		
		return req;
	}

	@Override
	protected void parseResponse(Object rsp) {
		// TODO Auto-generated method stub
		Sumstatisticresponse rsp2 = (Sumstatisticresponse)rsp;
		if(rsp2.getMsgrspheader().getRetinfo().getRettype()==0){
			System.out.println("结果数据：...");
		}else{
			System.out.println("查询失败信息："+rsp2.getMsgrspheader().getRetinfo().getRetmsg());
		}
	}
	
	protected void testHead(){
		Sumstatisticrequest req = new Sumstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("");
		reqhead.setProcessCode(null);
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+"XX");
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("888");	
		req.setMsgreqheader(reqhead);
		
		Sumstatisticrequest.Msgbody reqbody = new Sumstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		req.setMsgbody(reqbody);		
		Sumstatisticresponse rsp = this.client.sumstatistic(req);
		this.parseResponse(rsp);
	}
	protected void testBody(){
		Sumstatisticrequest req = new Sumstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("sunstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Sumstatisticrequest.Msgbody reqbody = new Sumstatisticrequest.Msgbody();
		reqbody.setRecommender("");
		req.setMsgbody(reqbody);		
		Sumstatisticresponse rsp = this.client.sumstatistic(req);
		this.parseResponse(rsp);
	}
	protected void testLogicFail(){
		Sumstatisticrequest req = new Sumstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("sunstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Sumstatisticrequest.Msgbody reqbody = new Sumstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787705");
		req.setMsgbody(reqbody);		
		Sumstatisticresponse rsp = this.client.sumstatistic(req);
		this.parseResponse(rsp);
	}
	protected void testLogicSucc(){
		Sumstatisticrequest req = new Sumstatisticrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("sunstatistic");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Sumstatisticrequest.Msgbody reqbody = new Sumstatisticrequest.Msgbody();
		reqbody.setRecommender("13760787706");
		req.setMsgbody(reqbody);		
		Sumstatisticresponse rsp = this.client.sumstatistic(req);
		this.parseResponse(rsp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumstatisticTest test = new SumstatisticTest();
		test.service();
		System.exit(0);
	}

}
