package com.gmcc.pboss.web.base.functionitem;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.web.common.xtree.XTreeNode;
import com.gmcc.pboss.web.common.xtree.XmlBuilder;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * WayTreeBean
 * <br> Description: class WayTreeBean
 * <br> Company: Maywide,Guangzhou</br>
 * @author Canigar
 * @since 1.0
 * @version 1.0
 * 2006-8-28
 */
public class FunctionitemTreeBean {	
	
	private String childrenURL;
	private String parentid;
	private String parentname;
	private String queryText;


	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String outputXml(HttpServletRequest request) throws Exception{
		User user = (User)request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		return buildXml(parentid,parentname,user,queryText);
	}
	
	private String buildXml(String parentId,String parentName,User user,String queryText) throws Exception{
		XmlBuilder builder = new FunctionitemXmlBuilder(parentId,parentName,user,queryText);
		XTreeNode xtreeNode = new XTreeNode(parentId ,parentId,"Root",null);
		if(!StringUtils.isEmpty(childrenURL)) xtreeNode.setChildrenURL( childrenURL ); 
		String xml = builder.getXml(xtreeNode);
		return xml;
	}
	
	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getParentname() {
		return parentname;
	}

	public void setParentname(String parentname) {
		this.parentname = parentname;
	}

	public String getChildrenURL() {
		return childrenURL;
	}

	public void setChildrenURL(String childrenURL) {
		this.childrenURL = childrenURL;
	}
	
}
