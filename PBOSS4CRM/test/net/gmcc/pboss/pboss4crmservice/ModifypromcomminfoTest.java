package net.gmcc.pboss.pboss4crmservice;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XPP3Reader;

public class ModifypromcomminfoTest extends XmlTestTemplate {
	public static void main(String[] args){
		ModifypromcomminfoTest test = new ModifypromcomminfoTest();
		String classPath = ModifypromcomminfoTest.class.getClassLoader().getResource("").toString();
		classPath = classPath.substring(6);
		test.setXmlPath(classPath + "net/gmcc/pboss/pboss4crmservice/ModifypromcomminfoTest.xml");
		test.service();
		System.exit(0);
	}

	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		Modifypromcomminforeq request = this.parseRequest(xml);
		Modifypromcomminforsp response = client.modifypromcomminfo(request);
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
	public Modifypromcomminforeq parseRequest(String xml) {
		// TODO Auto-generated method stub
		Modifypromcomminforeq request = new Modifypromcomminforeq();
		Msgreqheader reqheader = super.parseRequestHeader(xml);		
		request.setMsgreqheader(reqheader);
		Modifypromcomminforeq.Msgbody body = new Modifypromcomminforeq.Msgbody();
		request.setMsgbody(body);
		try{
			Document doc = new XPP3Reader().read(new StringReader(xml));
			Element info = doc.getRootElement().element(MESSAGE_BODY);
			body.setMobileno(info.elementText("mobileno"));
			body.setCompanycode(info.elementText("companycode"));
			body.setCommissionercode(info.elementText("commissionercode"));
			body.setAgentcode(info.elementText("agentcode"));
			body.setStaffname(info.elementText("staffname"));
			body.setStaffcode(info.elementText("staffcode"));
			body.setPersonid(info.elementText("personid"));
			body.setEmail(info.elementText("email"));
			body.setRegisterdate(info.elementText("registerdate"));
			body.setEnabledate(info.elementText("enabledate"));
			body.setStopdate(info.elementText("stopdate"));
			body.setStatus(info.elementText("status"));
			body.setOercode(info.elementText("oercode"));
			body.setIstenseed(info.elementText("istenseed"));
			body.setIsinternal(info.elementText("isinternal"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return request;
	}

}
