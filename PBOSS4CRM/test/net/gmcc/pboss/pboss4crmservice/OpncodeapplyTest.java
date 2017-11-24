package net.gmcc.pboss.pboss4crmservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.gmcc.pboss.comswebservice.Opncodeapplyreq;
import net.gmcc.pboss.comswebservice.Reqheader;
import net.gmcc.pboss.comswebservice.Rspheader;
import net.gmcc.pboss.comswebservice.Opncodeapplyrsp;

public class OpncodeapplyTest extends XmlTestTemplate {

	public static void main(String[] args){
		//OpncodeapplyTest test = new OpncodeapplyTest();
		Opncodeapplyreq req = new Opncodeapplyreq();
		Reqheader rh = new Reqheader();
		rh.setPlatform("PSAG");
		rh.setProcessCode("opncodeapply");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		rh.setReqTime(sdf.format(new Date()));
		rh.setReqSeq("10008");
		rh.setTestflag(1);
		req.setReqheader(rh);
		
		Opncodeapplyreq.Reqbody rb = new Opncodeapplyreq.Reqbody();
		rb.setCityid(760);
		rb.setBusibelong("DATA");
		rb.setEnddate("20991231");
		rb.setStartdate("20120701");
		rb.setId("Id0015");
		rb.setOpnname("业务编码申请接口测试");
		rb.setParentid("0105020100000");
		req.setReqbody(rb);
		
		Opncodeapplyrsp rsp = client2.opncodeapply(req);
		Rspheader sh = rsp.getRspheader();
		Opncodeapplyrsp.Rspbody sb = rsp.getRspbody();
		String r = sh.getPlatform()+":"+sh.getProcessCode()+":"+sh.getReqSeq()+":"+sh.getRspTime()+":"
				+sb.getId()+":"+sb.getOpnid()+":"+sb.getState()+":"+sb.getParentid()+":"
				+sh.getRetinfo().getRetcode()+":"+sh.getRetinfo().getRetmsg();
		System.out.println(r);
	}
	
	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object parseRequest(String xml) {
		// TODO Auto-generated method stub
		return null;
	}

}
