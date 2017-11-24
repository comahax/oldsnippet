package com.sunrise.boss.ui.cms.opntree;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;

public class OpnTreeBean {

	private String childrenURL;
	private String function;
	private String showDisabled = "";
	private String _sk_name;
	private String _ne_opnid;
	private String isLeaf;
	private String currentime;
	
	public String getCurrentime() {
		return currentime;
	}
	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}
	public String outputXml(HttpServletRequest request) throws Exception {
		User user = (User)(request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER));
		System.out.println(showDisabled);
		String id = request.getParameter("parentid");
		String treetype = request.getParameter("parenttype");
		return this.buildOperation(id, treetype , user);
	}
	private String buildOperation(String id, String treetype, User user) throws Exception {
		OpnTreeXmlBuilder builder = new OpnTreeXmlBuilder(user);
		XTreeNode node=new XTreeNode(id,id,"Root",treetype);

		if(!StringUtils.isEmpty(function)) node.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) node.setChildrenURL( childrenURL );
		
		if(!StringUtils.isEmpty(_sk_name)) builder.set_sk_opname(_sk_name);
		if(!StringUtils.isEmpty(_ne_opnid)) builder.set_ne_opnid(_ne_opnid);
		builder.setIsLeaf(isLeaf);
		builder.setShowdisable(showDisabled);
		builder.setCurrentime(currentime);
		String xml = builder.getXml(node);
		return xml;
	}
	
	public String getChildrenURL() {
		return childrenURL;
	}
	public void setChildrenURL(String childrenURL) {
		this.childrenURL = childrenURL;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getShowDisabled() {
		return showDisabled;
	}
	public void setShowDisabled(String showDisabled) {
		this.showDisabled = showDisabled;
	}
	public String get_sk_name() {
		return _sk_name;
	}
	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}
	public String get_ne_opnid() {
		return _ne_opnid;
	}
	public void set_ne_opnid(String _ne_opnid) {
		this._ne_opnid = _ne_opnid;
	}
	public String getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	
}
