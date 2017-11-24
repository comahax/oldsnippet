package net.gmcc.pboss.pboss4crmservice;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XPP3Reader;

public class OprsynTest extends XmlTestTemplate {
	public static void main(String[] args){
		OprsynTest test = new OprsynTest();
		String classPath = OprsynTest.class.getClassLoader().getResource("").toString();
		classPath = classPath.substring(6);
		test.setXmlPath(classPath + "net/gmcc/pboss/pboss4crmservice/OprsynTest.xml");
		test.service();
		System.exit(0);
	}

	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		Oprsynreq request = this.parseRequest(xml);
		Oprsynrsp response = client.oprsyn(request);
		Msgrspheader rsphead = response.getMsgrspheader();
		String rsp = "menuid:"+rsphead.getMenuid()+"\nprocess_code:"+rsphead.getProcessCode()+"\n";
		rsp += "verify_code:"+rsphead.getVerifyCode()+"\nreq_time:"+rsphead.getRespTime()+"\n";
		rsp += "sequence.req_seq:"+rsphead.getSequence().getReqSeq()+"\nsequence.operation_seq:"+rsphead.getSequence().getOperationSeq()+"\n";
		rsp += "=======================================================\n";
		rsp += "retinfo.rettype:"+rsphead.getRetinfo().getRetype()+"\nretinfo.retcode:"+rsphead.getRetinfo().getRetcode()+"\nretinfo.msg:"+rsphead.getRetinfo().getRetmsg()+"\n";
		rsp += "=======================================================";
		return "服务"+rsphead.getProcessCode()+"响应信息：\n"+rsp;
	}

	@Override
	public Oprsynreq parseRequest(String xml) {
		// TODO Auto-generated method stub
		Oprsynreq request = new Oprsynreq();
		Msgreqheader reqheader = super.parseRequestHeader(xml);		
		request.setMsgreqheader(reqheader);
		Oprsynreq.Msgbody body = new Oprsynreq.Msgbody();
		Oprsynreq.Msgbody.Oprinfo oprinfo = new Oprsynreq.Msgbody.Oprinfo();
		body.setOprinfo(oprinfo);
		request.setMsgbody(body);
		try{
			Document doc = new XPP3Reader().read(new StringReader(xml));
//			Element eMessageBody = doc.getRootElement().element(MESSAGE_BODY);
			Element eOprinfo = doc.getRootElement().element(MESSAGE_BODY).element("oprinfo");
			oprinfo.setOptime(eOprinfo.elementText("optime"));
			oprinfo.setOprcode(eOprinfo.elementText("oprcode"));
			oprinfo.setOprtype(eOprinfo.elementText("oprtype"));
			oprinfo.setOperid(eOprinfo.elementText("operid"));
			oprinfo.setRegion(eOprinfo.elementText("region"));
			oprinfo.setOpername(eOprinfo.elementText("opername"));
			oprinfo.setPassword(eOprinfo.elementText("password"));
			oprinfo.setPasschgdate(eOprinfo.elementText("passchgdate"));
			oprinfo.setOpergroup(eOprinfo.elementText("opergroup"));
			oprinfo.setOpertype(eOprinfo.elementText("opertype"));
			oprinfo.setOperlevel(eOprinfo.elementText("operlevel"));
			oprinfo.setIsmanager(eOprinfo.elementText("ismanager"));
			oprinfo.setContactphone(eOprinfo.elementText("contactphone"));
			oprinfo.setOrgid(eOprinfo.elementText("orgid"));
			oprinfo.setIsrestrict(eOprinfo.elementText("isrestrict"));
			oprinfo.setStarttime(eOprinfo.elementText("starttime"));
			oprinfo.setEndtime(eOprinfo.elementText("endtime"));
			oprinfo.setEnablegprs(eOprinfo.elementText("enablegprs"));
			oprinfo.setGprsstarttime(eOprinfo.elementText("gprsstarttime"));
			oprinfo.setGprsendtime(eOprinfo.elementText("gprsendtime"));
			oprinfo.setIschkmac(eOprinfo.elementText("ischkmac"));
			oprinfo.setMac(eOprinfo.elementText("mac"));
			oprinfo.setNotes(eOprinfo.elementText("notes"));
			oprinfo.setCreatedate(eOprinfo.elementText("createdate"));
			oprinfo.setStatus(eOprinfo.elementText("status"));
			oprinfo.setStatusdate(eOprinfo.elementText("statusdate"));
			oprinfo.setReleStaffId(eOprinfo.elementText("rele_staff_id"));
			oprinfo.setStartUsingTime(eOprinfo.elementText("start_using_time"));
			oprinfo.setEndUsingTime(eOprinfo.elementText("end_using_time"));
			oprinfo.setLogintype(eOprinfo.elementText("logintype"));
			oprinfo.setSmnotityflag(eOprinfo.elementText("smnotityflag"));			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return request;
	}

}
