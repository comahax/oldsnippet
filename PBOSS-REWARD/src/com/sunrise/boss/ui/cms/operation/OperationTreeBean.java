package com.sunrise.boss.ui.cms.operation;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;
import com.sunrise.boss.ui.commons.xtree.XmlBuilder;

public class OperationTreeBean {
	private String childrenURL;
	private String function;
	private String showDisabled = "false";
	private String _sk_name;
	private String _ne_opnid;
	private String orgtype;
	private String opntype;
	private String currentime;
	public OperationTreeBean() {
		// TODO Auto-generated constructor stub
	}
	public String outputXml(HttpServletRequest request) throws Exception {
		User user = (User)(request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER));
		//changed by liwenjing
		//if(user == null) user = new User();
		
		String id = request.getParameter("parentid");
		return this.buildOperation(id, user);
	}
	private String buildOperation(String id,User user) throws Exception {
		OperationXmlBuilder builder = new OperationXmlBuilder(user);
		XTreeNode node=new XTreeNode(id,id,"Root","operation");

		if(!StringUtils.isEmpty(function)) node.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) node.setChildrenURL( childrenURL );
		
		if(!StringUtils.isEmpty(_sk_name)) builder.set_sk_opname(_sk_name);
		if(!StringUtils.isEmpty(_ne_opnid)) builder.set_ne_opnid(_ne_opnid);
		builder.setOpntype(opntype);
		builder.setCurrentime(currentime);
		builder.setShowdisable(showDisabled);
		String xml = builder.getXml(node);
		return xml;
	}
	public String getChildrenURL() {
		return childrenURL;
	}
	public void setChildrenURL(String childrenURL) {
		this.childrenURL = childrenURL;
	}
	public String getCurrentime() {
		return currentime;
	}
	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getOpntype() {
		return opntype;
	}
	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	
	public String getShowDisabled() {
		return showDisabled;
	}
	public void setShowDisabled(String showDisabled) {
		this.showDisabled = showDisabled;
	}
	public String get_ne_opnid() {
		return _ne_opnid;
	}
	public void set_ne_opnid(String _ne_opnid) {
		this._ne_opnid = _ne_opnid;
	}
	public String get_sk_name() {
		return _sk_name;
	}
	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}
	
}
