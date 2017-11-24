package com.sunrise.boss.ui.cms.fdauditdef;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;

public class FdauditdefTreeBean {

	public static final String TYPE_AUDIT = "audit";

	private String childrenURL;

	private String function;

	private String showDisabled = "false";

	private String queryText;

	private String currentime;

	public String outputXml(HttpServletRequest request) throws Exception {
		User user = (User) (request.getSession()
				.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER));
		// changed by liwenjing
		// if(user == null) user = new User();

		String id = request.getParameter("parentid");
		String type = request.getParameter("parenttype");

		if (id == null)
			id = "-1";
		// throw new RuntimeException("id must be specified for xtree.");

		String xml = "";
		// 根据type的不同,使用不同的 xmlBuilder 来生成节点.
		if (TYPE_AUDIT.equals(type))
			xml = buildAudit(id, user);
		else
			xml = null;
		return xml;
	}

	private String buildAudit(String id, User user) throws Exception {
		AuditXmlBuilder builder = new AuditXmlBuilder(user);
		XTreeNode node = new XTreeNode(id, id, "Root", TYPE_AUDIT);
		if (!StringUtils.isEmpty(function))
			node.setFunction(function);
		if (!StringUtils.isEmpty(childrenURL))
			node.setChildrenURL(childrenURL);
		builder.setAudittype(queryText);
		builder.setCurrentime(currentime);
		builder.setParentname(this.showDisabled);
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

	public String getQueryText() {
		return queryText;
	}

	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}

	public String getCurrentime() {
		return currentime;
	}

	public void setCurrentime(String currentime) {
		this.currentime = currentime;
	}

}
