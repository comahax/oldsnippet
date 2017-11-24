package net.gmcc.pboss.pboss4crmservice;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XPP3Reader;

public class EmpsynTest extends XmlTestTemplate {
	
	public static void main(String[] args){
		EmpsynTest test = new EmpsynTest();
		String classPath = EmpsynTest.class.getClassLoader().getResource("").toString();
		classPath = classPath.substring(6);
		test.setXmlPath(classPath + "net/gmcc/pboss/pboss4crmservice/EmpsynTest.xml");
		test.service();
		System.exit(0);
	}
	
	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		Empsynreq request = this.parseRequest(xml);
		Empsynrsp response = client.empsyn(request);
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
	public Empsynreq parseRequest(String xml) {
		// TODO Auto-generated method stub
		Empsynreq request = new Empsynreq();
		Msgreqheader reqheader = super.parseRequestHeader(xml);		
		request.setMsgreqheader(reqheader);
		Empsynreq.Msgbody body = new Empsynreq.Msgbody();
		Empsynreq.Msgbody.Empinfo empinfo = new Empsynreq.Msgbody.Empinfo();
		body.setEmpinfo(empinfo);
		request.setMsgbody(body);
		try{
			Document doc = new XPP3Reader().read(new StringReader(xml));
			//Element eBody = doc.getRootElement().element(MESSAGE_BODY);
			//Element eWayinfo = eBody.element("wayinfo");
			Element eEmpinfo = doc.getRootElement().element(MESSAGE_BODY).element("empinfo");
			empinfo.setOprtype(eEmpinfo.elementText("oprtype"));
			empinfo.setEmployeeid(eEmpinfo.elementText("employeeid"));
			empinfo.setOprcode(eEmpinfo.elementText("oprcode"));
			empinfo.setEmployeename(eEmpinfo.elementText("employeename"));
			empinfo.setBirthday(eEmpinfo.elementText("birthday"));
			empinfo.setSex(eEmpinfo.elementText("sex"));
			empinfo.setEdulevel(eEmpinfo.elementText("edulevel"));
			empinfo.setNativehome(eEmpinfo.elementText("nativehome"));
			empinfo.setPolivisage(eEmpinfo.elementText("polivisage"));
			empinfo.setDepartment(eEmpinfo.elementText("department"));
			empinfo.setServoffice(eEmpinfo.elementText("servoffice"));
			empinfo.setStation(eEmpinfo.elementText("station"));
			empinfo.setJoblevel(eEmpinfo.elementText("joblevel"));
			empinfo.setIntime(eEmpinfo.elementText("intime"));
			empinfo.setWorktime(eEmpinfo.elementText("worktime"));
			empinfo.setHereworktime(eEmpinfo.elementText("hereworktime"));
			empinfo.setEmploytype(eEmpinfo.elementText("employtype"));
			empinfo.setCompany(eEmpinfo.elementText("company"));
			empinfo.setTelephone(eEmpinfo.elementText("telephone"));
			empinfo.setOfficetel(eEmpinfo.elementText("officetel"));
			empinfo.setOuttime(eEmpinfo.elementText("outtime"));
			empinfo.setOutresult(eEmpinfo.elementText("outresult"));
			empinfo.setHomeaddr(eEmpinfo.elementText("homeaddr"));
			empinfo.setCardid(eEmpinfo.elementText("cardid"));
			empinfo.setWayid(eEmpinfo.elementText("wayid"));
			empinfo.setWaytype(eEmpinfo.elementText("waytype"));
			empinfo.setPvtemail(eEmpinfo.elementText("pvtemail"));
			empinfo.setOfcphone(eEmpinfo.elementText("ofcphone"));
			empinfo.setOfcemail(eEmpinfo.elementText("ofcemail"));
			empinfo.setSpeciality(eEmpinfo.elementText("speciality"));
			empinfo.setCityid(eEmpinfo.elementText("cityid"));
			empinfo.setCountyid(eEmpinfo.elementText("countyid"));
			empinfo.setSvccode(eEmpinfo.elementText("svccode"));
			empinfo.setPosittype(eEmpinfo.elementText("posittype"));
			empinfo.setContacttype(eEmpinfo.elementText("contacttype"));
			empinfo.setEmpstatus(eEmpinfo.elementText("empstatus"));
			empinfo.setActbank(eEmpinfo.elementText("actbank"));
			empinfo.setActno(eEmpinfo.elementText("actno"));
			empinfo.setActname(eEmpinfo.elementText("actname"));
			empinfo.setActpid(eEmpinfo.elementText("actpid"));
			empinfo.setBail(eEmpinfo.elementText("bail"));
			empinfo.setGradschool(eEmpinfo.elementText("gradschool"));
			empinfo.setGradtime(eEmpinfo.elementText("gradtime"));
			empinfo.setIsmarried(eEmpinfo.elementText("ismarried"));
			empinfo.setOutreason(eEmpinfo.elementText("outreason"));
			empinfo.setTrainlevel(eEmpinfo.elementText("trainlevel"));
			empinfo.setHobby(eEmpinfo.elementText("hobby"));
			empinfo.setCharacter(eEmpinfo.elementText("character"));
			empinfo.setAsses(eEmpinfo.elementText("asses"));
			empinfo.setWorkhistry(eEmpinfo.elementText("workhistry"));
			empinfo.setPrizeorpunish(eEmpinfo.elementText("prizeorpunish"));
			empinfo.setEmpass(eEmpinfo.elementText("empass"));
			empinfo.setRight(eEmpinfo.elementText("right"));
			empinfo.setIsnet(eEmpinfo.elementText("isnet"));
			empinfo.setNetpass(eEmpinfo.elementText("netpass"));
			empinfo.setIsopen(eEmpinfo.elementText("isopen"));
			empinfo.setSelectmobile(eEmpinfo.elementText("selectmobile"));
			empinfo.setSubname(eEmpinfo.elementText("subname"));
			empinfo.setRegdate(eEmpinfo.elementText("regdate"));
			empinfo.setEmpattr(eEmpinfo.elementText("empattr"));
			empinfo.setEmpattrmemo(eEmpinfo.elementText("empattrmemo"));
			empinfo.setIstenseed(eEmpinfo.elementText("istenseed"));
			empinfo.setIsinternal(eEmpinfo.elementText("isinternal"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
		return request;
	}

}
