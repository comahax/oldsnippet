package net.gmcc.pboss.pboss4crmservice;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XPP3Reader;

public class ReturnorderinTest extends XmlTestTemplate {
	public static void main(String[] args){
		ReturnorderinTest test = new ReturnorderinTest();
		String classPath = ReturnorderinTest.class.getClassLoader().getResource("").toString();
		classPath = classPath.substring(6);
		test.setXmlPath(classPath + "net/gmcc/pboss/pboss4crmservice/ReturnorderinTest.xml");
		test.service();
		System.exit(0);
	}

	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		Returnorderinreq request = this.parseRequest(xml);
		Returnorderinrsp response = client.returnorderin(request);
		Msgrspheader rsphead = response.getMsgrspheader();
		String rsp = "menuid:"+rsphead.getMenuid()+"\nprocess_code:"+rsphead.getProcessCode()+"\n";
		rsp += "verify_code:"+rsphead.getVerifyCode()+"\nreq_time:"+rsphead.getRespTime()+"\n";
		//rsp += "sequence.req_seq:"+rsphead.getSequence().getReqSeq()+"\nsequence.operation_seq:"+rsphead.getSequence().getOperationSeq()+"\n";
		rsp += "=======================================================\n";
		rsp += "retinfo.rettype:"+rsphead.getRetinfo().getRetype()+"\nretinfo.retcode:"+rsphead.getRetinfo().getRetcode()+"\nretinfo.msg:"+rsphead.getRetinfo().getRetmsg()+"\n";
		rsp += "=======================================================";
		return "服务"+rsphead.getProcessCode()+"响应信息：\n"+rsp;
	}

	@Override
	public Returnorderinreq parseRequest(String xml) {
		Returnorderinreq request = new Returnorderinreq();
		Msgreqheader reqheader = super.parseRequestHeader(xml);		
		request.setMsgreqheader(reqheader);
		Returnorderinreq.Msgbody body = new Returnorderinreq.Msgbody();
		request.setMsgbody(body);
		try{
			Document doc = new XPP3Reader().read(new StringReader(xml));
			Element eMessageBody = doc.getRootElement().element(MESSAGE_BODY);
			body.setBusitype(eMessageBody.elementText("busitype"));
			body.setOrderid(eMessageBody.elementText("orderid"));
			body.setBossworkfid(eMessageBody.elementText("bossworkfid"));
			body.setOrderresult(eMessageBody.elementText("orderresult"));
			body.setOrderresultinfo(eMessageBody.elementText("orderresultinfo"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return request;
	}

}
