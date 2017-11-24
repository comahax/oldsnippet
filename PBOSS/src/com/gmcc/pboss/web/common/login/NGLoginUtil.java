package com.gmcc.pboss.web.common.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class NGLoginUtil {
	public static final Logger log = Logger.getLogger(LoginAction.LOGIN_LOGGER_NAME);
	public static String buildRequestText(int step,String logintype, String validcode1, String validcode2){
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("operation_request").addElement("msgbody");
		root.addElement("step").addText(""+step);
		root.addElement("logintype").addText(logintype==null?"":logintype);
		Element validinfo = root.addElement("validinfo");
		validinfo.addElement("validcode1").addText(validcode1==null?"":validcode1);		
//		if(validcode2!=null && validcode2.contains("<![CDATA[")){
//			validcode2 = validcode2.replaceAll("]]>", "]]]]><![CDATA[>");
//		}
		validinfo.addElement("validcode2").addCDATA(validcode2==null?"":validcode2);		
		String reqstr = doc.asXML();
		//System.out.println("请求报文:"+reqstr);
		log.info("请求报文:"+reqstr);
		return reqstr;
	}
	
	public static void parseResponseXML(String rspstr, NGResult ngresult) throws DocumentException{
		//System.out.println("响应报文:"+rspstr);
		log.info("响应报文:"+rspstr);
		Document doc = DocumentHelper.parseText(rspstr);
		Element root = doc.getRootElement().element("msgbody");
		ngresult.setCode(root.elementTextTrim("code"));
		ngresult.setAuthresult(root.elementTextTrim("authresult"));		
	}
}
