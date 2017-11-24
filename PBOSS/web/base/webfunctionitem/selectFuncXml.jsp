<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="org.apache.commons.lang.StringUtils" %><%
	com.gmcc.pboss.web.base.webfunctionitem.WebfunctionitemTreeBean treeBean = new com.gmcc.pboss.web.base.webfunctionitem.WebfunctionitemTreeBean();  
	try {
		String parentid = (String)request.getParameter("parentid");
		String parentname = (String)request.getParameter("parentname");
		String childrenURL = (String)request.getParameter("childrenURL");
		String queryText = (String)request.getParameter("queryText");
		if(!StringUtils.isBlank( childrenURL ) ) 
			treeBean.setChildrenURL(childrenURL);
		if(!StringUtils.isBlank( parentid ) ) 
			treeBean.setParentid(parentid);
		if(!StringUtils.isBlank( parentname ) ) 
			treeBean.setParentname(parentname);
		if(!StringUtils.isBlank( queryText ) ) 
			treeBean.setQueryText(queryText);
		
		out.println(treeBean.outputXml(request));
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
