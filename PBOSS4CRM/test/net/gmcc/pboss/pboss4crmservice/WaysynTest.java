package net.gmcc.pboss.pboss4crmservice;

import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.XPP3Reader;

public class WaysynTest extends XmlTestTemplate {
	public static void main(String[] args){
		WaysynTest test = new WaysynTest();
		String classPath = WaysynTest.class.getClassLoader().getResource("").toString();
		classPath = classPath.substring(6);
		test.setXmlPath(classPath + "net/gmcc/pboss/pboss4crmservice/WaysynTest.xml");
		test.service();
		System.exit(0);
	}
	
	@Override
	public String doService(PBOSSServicePort client, String xml) {
		// TODO Auto-generated method stub
		Waysynreq requerst = this.parseRequest(xml);
		Waysynrsp response = client.waysyn(requerst);
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
	public Waysynreq parseRequest(String xml) {
		// TODO Auto-generated method stub
		Waysynreq request = new Waysynreq();
		Msgreqheader reqheader = super.parseRequestHeader(xml);		
		request.setMsgreqheader(reqheader);
		Waysynreq.Msgbody body = new Waysynreq.Msgbody();
		Waysynreq.Msgbody.Wayinfo wayinfo = new Waysynreq.Msgbody.Wayinfo();
		try{
			Document doc = new XPP3Reader().read(new StringReader(xml));
			//Element eBody = doc.getRootElement().element(MESSAGE_BODY);
			//Element eWayinfo = eBody.element("wayinfo");
			Element eWayinfo = doc.getRootElement().element(MESSAGE_BODY).element("wayinfo");
			wayinfo.setOprtype(eWayinfo.elementText("oprtype"));
			wayinfo.setWayid(eWayinfo.elementText("wayid"));
			wayinfo.setShortname(eWayinfo.elementText("shortname"));
			wayinfo.setSvbrchcode(eWayinfo.elementText("svbrchcode"));
			wayinfo.setSvccode(eWayinfo.elementText("svccode"));
			wayinfo.setMareacode(eWayinfo.elementText("mareacode"));
			wayinfo.setBuztypecode(eWayinfo.elementText("buztypecode"));
			wayinfo.setAdtypecode(eWayinfo.elementText("adtypecode"));
			wayinfo.setAddress(eWayinfo.elementText("address"));
			wayinfo.setLogiscode(eWayinfo.elementText("logiscode"));
			wayinfo.setLatitude(eWayinfo.elementText("latitude"));
			wayinfo.setLongtitude(eWayinfo.elementText("longtitude"));
			wayinfo.setAdacode(eWayinfo.elementText("adacode"));
			wayinfo.setWaymagcode(eWayinfo.elementText("waymagcode"));
			wayinfo.setCatetype(eWayinfo.elementText("catetype"));
			wayinfo.setFormtype(eWayinfo.elementText("formtype"));
			wayinfo.setStarttime(eWayinfo.elementText("starttime"));
			wayinfo.setBuzarea(eWayinfo.elementText("buzarea"));
			wayinfo.setMainlayer(eWayinfo.elementText("mainlayer"));
			wayinfo.setSublayer(eWayinfo.elementText("sublayer"));
			wayinfo.setBuzphoneno(eWayinfo.elementText("buzphoneno"));
			wayinfo.setWayname(eWayinfo.elementText("wayname"));
			wayinfo.setCooperator(eWayinfo.elementText("cooperator"));
			wayinfo.setWaytype(eWayinfo.elementText("waytype"));
			wayinfo.setWaysubtype(eWayinfo.elementText("waysubtype"));
			wayinfo.setCusttype(eWayinfo.elementText("custtype"));
			wayinfo.setUpperwayid(eWayinfo.elementText("upperwayid"));
			wayinfo.setBusicode(eWayinfo.elementText("busicode"));
			wayinfo.setCountyid(eWayinfo.elementText("countyid"));
			wayinfo.setCityid(eWayinfo.elementText("cityid"));
			wayinfo.setCenterid(eWayinfo.elementText("centerid"));
			wayinfo.setCitylevel(eWayinfo.elementText("citylevel"));
			wayinfo.setWaylevel(eWayinfo.elementText("waylevel"));
			wayinfo.setBchlevel(eWayinfo.elementText("bchlevel"));
			wayinfo.setFunction(eWayinfo.elementText("function"));
			wayinfo.setMiscode(eWayinfo.elementText("miscode"));
			wayinfo.setCreatetime(eWayinfo.elementText("createtime"));
			wayinfo.setDisabletime(eWayinfo.elementText("disabletime"));
			wayinfo.setWaystate(eWayinfo.elementText("waystate"));
			wayinfo.setRunbyself(eWayinfo.elementText("runbyself"));
			wayinfo.setDepotdet(eWayinfo.elementText("depotdet"));
			wayinfo.setIsshare(eWayinfo.elementText("isshare"));
			wayinfo.setAlarmbizamount(eWayinfo.elementText("alarmbizamount"));
			wayinfo.setPrtsource(eWayinfo.elementText("prtsource"));
			wayinfo.setIsconnected(eWayinfo.elementText("isconnected"));
			wayinfo.setConnecttype(eWayinfo.elementText("connecttype"));
			wayinfo.setRunmode(eWayinfo.elementText("runmode"));
			wayinfo.setIscoreway(eWayinfo.elementText("iscoreway"));
			wayinfo.setStarlevel(eWayinfo.elementText("starlevel"));
			wayinfo.setPt(eWayinfo.elementText("pt"));
			wayinfo.setChainhead(eWayinfo.elementText("chainhead"));
			wayinfo.setSignstatus(eWayinfo.elementText("signstatus"));
			wayinfo.setEmpnumber(eWayinfo.elementText("empnumber"));
			wayinfo.setMagnumber(eWayinfo.elementText("magnumber"));
			wayinfo.setTerminumber(eWayinfo.elementText("terminumber"));
			wayinfo.setUpdatedate(eWayinfo.elementText("updatedate"));
			wayinfo.setIsstraitprd(eWayinfo.elementText("isstraitprd"));
			wayinfo.setTaxtype(eWayinfo.elementText("taxtype"));
			wayinfo.setIstietong(eWayinfo.elementText("istietong"));
			wayinfo.setRivltype(eWayinfo.elementText("rivltype"));
			wayinfo.setIskzcz(eWayinfo.elementText("iskzcz"));
			wayinfo.setDistype(eWayinfo.elementText("distype"));
			wayinfo.setCalcumode(eWayinfo.elementText("calcumode"));
			wayinfo.setUniformtime(eWayinfo.elementText("uniformtime"));
			wayinfo.setChecked(eWayinfo.elementText("checked"));
			wayinfo.setBuzmanager(eWayinfo.elementText("buzmanager"));
			wayinfo.setSubrunmode(eWayinfo.elementText("subrunmode"));
			body.setWayinfo(wayinfo);
			request.setMsgbody(body);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return request;
	}

}
