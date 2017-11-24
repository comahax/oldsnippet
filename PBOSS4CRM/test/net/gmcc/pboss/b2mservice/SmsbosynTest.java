package net.gmcc.pboss.b2mservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.math.RandomUtils;

public class SmsbosynTest extends AbstractB2MTest {

	@Override
	protected Object buildRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void parseResponse(Object rsp) {
		// TODO Auto-generated method stub
		Smsbosynresponse rsp2 = (Smsbosynresponse)rsp;
		if(rsp2.getMsgrspheader().getRetinfo().getRettype()==0){
			System.out.println("结果数据：...");
		}else{
			System.out.println("查询失败信息："+rsp2.getMsgrspheader().getRetinfo().getRetmsg());
		}
	}

	@Override
	protected void testBody() {
		// TODO Auto-generated method stub
		Smsbosynrequest req = new Smsbosynrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("smsbosyn");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Smsbosynrequest.Msgbody rb = new Smsbosynrequest.Msgbody();
		rb.setSrcseq("");
		rb.setRuleid("");
		rb.setOpnid("");
		rb.setCalcopnid("");
		rb.setCalcmonth("2013009");
		rb.setWayid("");
		rb.setOprtime("201308081212122");
		rb.setOprcode("");
		rb.setMobile("");
		rb.setBusivalue("2");
		rb.setRewardtype("8");
		rb.setOssrc("1");
		req.setMsgbody(rb);
		
		Smsbosynresponse rsp = this.client.smsbosyn(req);
		this.parseResponse(rsp);
	}

	@Override
	protected void testHead() {
		// TODO Auto-generated method stub
		Smsbosynrequest req = new Smsbosynrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("");
		reqhead.setProcessCode("");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("700");	
		req.setMsgreqheader(reqhead);
		
		Smsbosynrequest.Msgbody rb = new Smsbosynrequest.Msgbody();
		rb.setSrcseq("srcseq001");
		rb.setRuleid("ZINC");
		rb.setOpnid("x");
		rb.setCalcopnid("x");
		rb.setCalcmonth("201309");
		rb.setWayid("TDZS04A181740");
		rb.setOprtime("20130808121212");
		rb.setOprcode("x");
		rb.setMobile("15914396649");
		rb.setBusivalue("1");
		rb.setRewardtype("9");
		rb.setOssrc("3");
		req.setMsgbody(rb);
		
		Smsbosynresponse rsp = this.client.smsbosyn(req);
		this.parseResponse(rsp);
	}

	@Override
	protected void testLogicFail() {
		// TODO Auto-generated method stub
		System.out.println("--------------------------输入的代理商编码无效");
		this.testLogicFail_way();
		System.out.println("--------------------------用户在网时长不足2年");
		this.testLogicFail_year();
		System.out.println("--------------------------该用户过去三个月已办理过该业务");
		this.testLogicFail_month();
	}

	@Override
	protected void testLogicSucc() {
		// TODO Auto-generated method stub
		Smsbosynrequest req = new Smsbosynrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("smsbosyn");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Smsbosynrequest.Msgbody rb = new Smsbosynrequest.Msgbody();
		rb.setSrcseq("srcseq001");
		rb.setRuleid("ZINC");
		rb.setOpnid("x");
		rb.setCalcopnid("x");
		rb.setCalcmonth("201309");
		rb.setWayid("TDZS04A181740");
		rb.setOprtime("20130808121212");
		rb.setOprcode("x");
		rb.setMobile("15914396649");
		rb.setBusivalue("1");
		rb.setRewardtype("9");
		rb.setOssrc("3");
		req.setMsgbody(rb);
		
		Smsbosynresponse rsp = this.client.smsbosyn(req);
		this.parseResponse(rsp);
	}
	
	private void testLogicFail_way(){
		Smsbosynrequest req = new Smsbosynrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("smsbosyn");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Smsbosynrequest.Msgbody rb = new Smsbosynrequest.Msgbody();
		rb.setSrcseq("srcseq001");
		rb.setRuleid("ZINC");
		rb.setOpnid("x");
		rb.setCalcopnid("x");
		rb.setCalcmonth("201309");
		rb.setWayid("TDZS04A181740X");
		rb.setOprtime("20130808121212");
		rb.setOprcode("x");
		rb.setMobile("15914396640");
		rb.setBusivalue("1");
		rb.setRewardtype("9");
		rb.setOssrc("3");
		req.setMsgbody(rb);
		
		Smsbosynresponse rsp = this.client.smsbosyn(req);
		this.parseResponse(rsp);
	}
	
	private void testLogicFail_year(){
		// TODO Auto-generated method stub
		Smsbosynrequest req = new Smsbosynrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("smsbosyn");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Smsbosynrequest.Msgbody rb = new Smsbosynrequest.Msgbody();
		rb.setSrcseq("srcseq001");
		rb.setRuleid("ZINC");
		rb.setOpnid("x");
		rb.setCalcopnid("x");
		rb.setCalcmonth("201309");
		rb.setWayid("TDZS04A181740");
		rb.setOprtime("20130808121212");
		rb.setOprcode("x");
		rb.setMobile("15914396640");
		rb.setBusivalue("1");
		rb.setRewardtype("9");
		rb.setOssrc("3");
		req.setMsgbody(rb);
		
		Smsbosynresponse rsp = this.client.smsbosyn(req);
		this.parseResponse(rsp);
	}
	
	private void testLogicFail_month(){
		// TODO Auto-generated method stub
		Smsbosynrequest req = new Smsbosynrequest();
		Msgreqheader reqhead = new Msgreqheader();
		reqhead.setPlatformSrc("CRM");
		reqhead.setProcessCode("smsbosyn");
		reqhead.setReqTime(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()));
		reqhead.setReqSeq(""+(RandomUtils.nextInt()));
		reqhead.setRoute("760");	
		req.setMsgreqheader(reqhead);
		
		Smsbosynrequest.Msgbody rb = new Smsbosynrequest.Msgbody();
		rb.setSrcseq("srcseq001");
		rb.setRuleid("ZINC");
		rb.setOpnid("010500051");
		rb.setCalcopnid("x");
		rb.setCalcmonth("200912");
		rb.setWayid("TDZS04A181740");
		rb.setOprtime("20130808121212");
		rb.setOprcode("x");
		rb.setMobile("15914396641");
		rb.setBusivalue("1");
		rb.setRewardtype("9");
		rb.setOssrc("3");
		req.setMsgbody(rb);
		
		Smsbosynresponse rsp = this.client.smsbosyn(req);
		this.parseResponse(rsp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmsbosynTest test = new SmsbosynTest();
		test.service();
		System.exit(0);
	}

}
