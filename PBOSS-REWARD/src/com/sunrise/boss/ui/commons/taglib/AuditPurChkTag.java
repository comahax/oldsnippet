/**
 * 
 */
package com.sunrise.boss.ui.commons.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;
import org.apache.struts.taglib.TagUtils;

import com.sunrise.boss.delegate.admin.purview.PurviewDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * <p>
 * Description: BUSINESS OPERATION SURPORTING SYSTEM 1.5
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * 
 * @author Hanny Yeung
 * @since 2006-10-27
 * @version 1.0
 */

/**
 * 稽核专用权限标签
 */
public class AuditPurChkTag extends BodyTagSupport {
	
	private static Logger log = Logger.getRootLogger();
	
	private PurviewDelegate delegate;

	private String controlid;

	private String type;

	public AuditPurChkTag() throws Exception {
		delegate = new PurviewDelegate();
	}

	public String getControlid() {
		return controlid;
	}

	public void setControlid(String controlid) {
		this.controlid = controlid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PurviewDelegate getDelegate() {
		return delegate;
	}

	public void setDelegate(PurviewDelegate delegate) {
		this.delegate = delegate;
	}

	public int doStartTag() {
		return EVAL_BODY_BUFFERED;
	}

	public int doEndTag() throws JspTagException {
		return SKIP_BODY;
	}

	public int doAfterBody() {
		try {
			BodyContent bc = getBodyContent();
			JspWriter out = bc.getEnclosingWriter();
			String bodyStr = bc.getString();
			User user = (User) pageContext.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			char purview = checkAuditPurview(user.getOpercode());
			return printElement(out, bodyStr, user, purview);
		} catch (Exception ex) {
			ex.printStackTrace();
			return (SKIP_BODY);
		}
	}

	private int printElement(JspWriter out, String bodyStr, User user,
			char purview) throws IOException {
		try {
			bodyStr = bodyStr.trim();
			String[] code = this.controlid.split("_");
			String[] tmpArray = bodyStr.split(" ");
			String elementType = "";
			String elementName = "";
			for (int i = 0; i < tmpArray.length; i++) {
				elementType = tmpArray[i].trim();
				if (elementType.indexOf("type") != -1) {
					elementType = elementType.substring(6,
							elementType.length() - 1);
					break;
				}
			}

			for (int i = 0; i < tmpArray.length; i++) {
				elementName = tmpArray[i].trim();
				if (elementName.indexOf("name") != -1) {
					elementName = elementName.substring(6,
							elementName.length() - 1);
					break;
				}
			}

			if (code[1].equalsIgnoreCase("INPUTOBJRGT")) {// 录入对象控制
				if (purview == 'A') {
					;
				}else if(purview=='B'){
					if(!elementType.equalsIgnoreCase("button")){
						bodyStr = bodyStr.replaceFirst(" ", " disabled ");
					}
				}else{
					if(this.type!=null&&this.type.equalsIgnoreCase("HREF")){
						bodyStr = bodyStr.replaceAll("(<[a|A](.*)[^a|A]>)|(</[a|A]>)","");
					}else{
						bodyStr = bodyStr.replaceFirst(" ", " disabled ");
					}
				}
			} else if (code[1].equalsIgnoreCase("INPUTCRTRGT")) {// 工号渠道录入控制
				if(type.equalsIgnoreCase("LEVEL")){
					bodyStr = bodyStr.replaceFirst(" ", " value='"+purview+"' ");
				}
				else{
					if (purview == 'A') {
						if(this.type.equalsIgnoreCase("WAY")){
							bodyStr = bodyStr += "<input type='button' name='wayBtn' class='clickbutton' value='...' onClick='javascript:showSelectWay(document.all."
								+ elementName
								+ ");document.all."
								+ elementName
								+ ".focus();'/>";
						}
					} else if (purview == 'B') {
						if(this.type.equalsIgnoreCase("WAY")){
							bodyStr = bodyStr.replaceFirst(" ", " onClick='alert(\"您没有权限选择渠道！\");' readonly ");
						}
					} else if(this.type.equalsIgnoreCase("HID")){
						bodyStr = bodyStr.replaceFirst(" ", " value='"+purview+"' ");
					}else{
						bodyStr = bodyStr.replaceFirst(" ", " readonly ");
					}
				}
				
			} else if (code[1].equalsIgnoreCase("OPCODERGT") && purview > 'A') {// 其他工号交接记录控制
				bodyStr = bodyStr.replaceFirst(" ", " readonly ");
			} else if (code[1].equalsIgnoreCase("JHQUERYRGT")) {// 工号渠道查询控制
				if (this.type.equalsIgnoreCase("WAY")) {
					String isChecked =null;
					try{
						isChecked = (String) TagUtils.getInstance().lookup(pageContext, "org.apache.struts.taglib.html.BEAN",
							"isSubWay", null);
					}catch(Exception ex){
						//ex.printStackTrace();
					}
					if (isChecked == null) {
						isChecked = " ";
					} else {
						isChecked = isChecked.trim().equals("1") ? " checked ": " ";
					}
					if (purview == 'A') {
						bodyStr += "<input type='button' name='wayBtn' class='clickbutton' value='...' onClick='javascript:showSelectWay(document.all."
								+ elementName
								+ ");document.all."
								+ elementName
								+ ".focus();'/><br/><input type='checkbox' name='isSubWay' value='1' class='table_checkbox' "+ isChecked +"/>是否查询子渠道";
					} else if (purview == 'C') {
						bodyStr = bodyStr.replaceFirst(" ", " readonly ");
						bodyStr += "<input type='button' name='wayBtn' class='clickbutton' value='...' onClick='javascript:showSelectWay(document.all."
								+ elementName
								+ ");document.all."
								+ elementName
								+ ".focus();'/><br/><input type='checkbox' name='isSubWay'  value='1' class='table_checkbox' "+ isChecked +"/>是否查询子渠道";
						// bodyStr += "<input type='checkbox' name='wayChk'
						// class='table_checkbox' title='打勾则查询该渠道下所有子渠道记录！'/>";
					} else if (purview == 'D'){
						bodyStr = bodyStr.replaceFirst(" ", " onClick='alert(\"您没有权限选择渠道！\");' readonly ");
						bodyStr += "<br/><input type='checkbox' name='isSubWay' disabled class='table_checkbox'/>是否查询子渠道";
					}else if(purview == 'E'){
						bodyStr = bodyStr.replaceFirst(" ", " onClick='alert(\"您没有权限选择渠道！\");' readonly ");
						bodyStr += "<br/><input type='checkbox' name='isSubWay' disabled class='table_checkbox'/>是否查询子渠道";
					}
				}else if(this.type.equalsIgnoreCase("OPR")){
					if(purview=='E'){
						bodyStr = bodyStr.replaceFirst(" ", " readonly ");
					}
				}else if(this.type.equalsIgnoreCase("SLT")){
					if(purview=='E'){
						bodyStr = bodyStr.replaceFirst(" ", " disabled ");
					}
				}else if (this.type.equalsIgnoreCase("WAY1")) {
					String isChecked =null;
					try{
						isChecked = (String) TagUtils.getInstance().lookup(pageContext, "org.apache.struts.taglib.html.BEAN",
							"isSubWay", null);
					}catch(Exception ex){
						//ex.printStackTrace();
					}
					if (isChecked == null) {
						isChecked = " ";
					} else {
						isChecked = isChecked.trim().equals("1") ? " checked ": " ";
					}
					bodyStr += "<input type='button' name='wayBtn' class='clickbutton' value='...' onClick='javascript:showSelectWay(document.all."
								+ elementName
								+ ");document.all."
								+ elementName
								+ ".focus();'/>";
					
				}
			}

			out.println(bodyStr);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IOException();
		}
		return (SKIP_BODY);
	}

	/*
	 * 返回稽核各标识符权限等级，分别为ABCD四等级
	 */
	private char checkAuditPurview(String oprcode) throws Exception {
		String[] identifiers = { "INPUTOBJRGT", "INPUTCRTRGT", "OPCODERGT",
				"JHQUERYRGT" };
		String letter = "";
		boolean state = false;
		int a = 'A';
		int n = 5;
		for (int j = 0; j < n; j++) {
			letter = (char) (a + j) + "";
			String tmp = this.controlid + "_" + letter;
			state = delegate.checkPurview(oprcode, tmp);
			if (state) {
				break;
			}
		}
		if(log.isInfoEnabled()){
			log.info("====================oprcode:"+oprcode+";purview:"+letter+"==========================");
		}
		return letter.charAt(0);
	}

}