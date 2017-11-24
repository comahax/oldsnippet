package com.gmcc.pboss.web.resource.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;
import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.gmcc.pboss.web.common.xtree.XmlBuilder;

public class ComidTreeBean {
	
	private final static String TOP_ID = "top";
	
	private final static String TOP_PARENTTYPE = "top";
	
	private String childrenURL;

	private String function;
	
	private String condition;
	
	private String filterFlag;

	public String getFilterFlag() {
		return filterFlag;
	}

	public void setFilterFlag(String filterFlag) {
		this.filterFlag = filterFlag;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	public String outputXml(HttpServletRequest request) throws Exception{
		User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);

		
		String parentId = request.getParameter("parentid");
		String id = "";
		String parentType = request.getParameter("parenttype");
		if (parentId == null || parentId.trim().length() < 1){
			id = parentId =  TOP_ID;
		}
		if (parentType == null || parentType.trim().length() < 1){
			parentType =  TOP_PARENTTYPE;
		}
		
		String xml = "";
		xml = buildXml(parentType,parentId,id,user);
		
		return xml;
	}
	
	private String buildXml(String parentType,String parentId,String id,User user) throws Exception{
		XmlBuilder builder = new ComidXmlBuilder(user,condition,filterFlag);
		XTreeNode xtreeNode = new XTreeNode(id ,parentId,"Root",parentType);
		if(!StringUtils.isEmpty(function)) xtreeNode.setFunction( function );	
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL ); 
		String xml = builder.getXml(xtreeNode);
		return xml;
	}
}
