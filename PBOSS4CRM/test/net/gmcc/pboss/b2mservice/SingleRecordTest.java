package net.gmcc.pboss.b2mservice;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.math.RandomUtils;

public class SingleRecordTest extends AbstractB2MTest {
	
	public SingleRecordTest(){
		super();
	}
	
	public Singlerecordrequest buildRequest(){
		Singlerecordrequest req = new Singlerecordrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("singlerecord");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Singlerecordrequest.Msgbody reqbody = new Singlerecordrequest.Msgbody();
		reqbody.setBusinessid("010500051");
		reqbody.setRecommender("13760787706");
		reqbody.setTransactor("120703873");
		reqbody.setRecommondtime("20120425161526");
		req.setMsgbody(reqbody);		
		
		return req;
	}
	
	protected void testHead(){
		Singlerecordrequest req = new Singlerecordrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc(null);
		reqhead.setProcessCode("");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+"XX");
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Singlerecordrequest.Msgbody reqbody = new Singlerecordrequest.Msgbody();
		reqbody.setBusinessid("010500051");
		reqbody.setRecommender("13760787706");
		reqbody.setTransactor("120703873");
		reqbody.setRecommondtime("20120425161526");
		req.setMsgbody(reqbody);
		
		Singlerecordresponse rsp = this.client.singlerecord(req);
		this.parseResponse(rsp);
	}
	
	protected void testBody(){
		Singlerecordrequest req = new Singlerecordrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("singlerecord");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Singlerecordrequest.Msgbody reqbody = new Singlerecordrequest.Msgbody();
		reqbody.setBusinessid(null);
		reqbody.setRecommender("");
		reqbody.setTransactor("");
		reqbody.setRecommondtime("20120425161526XX");
		req.setMsgbody(reqbody);
		
		Singlerecordresponse rsp = this.client.singlerecord(req);
		this.parseResponse(rsp);
	}
	
	protected void testLogicFail(){
		Singlerecordrequest req = new Singlerecordrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("singlerecord");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Singlerecordrequest.Msgbody reqbody = new Singlerecordrequest.Msgbody();
		reqbody.setBusinessid("010500051");
		reqbody.setRecommender("13760787706");
		reqbody.setTransactor("1207038731");
		reqbody.setRecommondtime("20120425161526");
		req.setMsgbody(reqbody);
		
		Singlerecordresponse rsp = this.client.singlerecord(req);
		this.parseResponse(rsp);
	}
	
	protected void testLogicSucc(){
		Singlerecordrequest req = new Singlerecordrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("singlerecord");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Singlerecordrequest.Msgbody reqbody = new Singlerecordrequest.Msgbody();
		reqbody.setBusinessid("010500051");
		reqbody.setRecommender("13760787706");
		reqbody.setTransactor("120703873");
		reqbody.setRecommondtime("20120425161526");
		req.setMsgbody(reqbody);
		
		Singlerecordresponse rsp = this.client.singlerecord(req);
		this.parseResponse(rsp);
	}
		
	public void parseResponse(Object rsp){
		Singlerecordresponse rsp2 = (Singlerecordresponse)rsp;
		if(rsp2.getMsgrspheader().getRetinfo().getRettype()==0){
			System.out.println("结果数据：...");
		}else{
			System.out.println("查询失败信息："+rsp2.getMsgrspheader().getRetinfo().getRetmsg());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleRecordTest test = new SingleRecordTest();
		test.service();
		System.exit(0);
	}

}
