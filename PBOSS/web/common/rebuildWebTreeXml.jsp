<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="com.gmcc.pboss.web.common.xtree.WebFXLoadTreeHelpBean" %><%
	try {
		//根据上级节点查找下级剩余未展示节点数据
		String parentNodeKey = (String)request.getParameter("parentNodeKey");
		out.println(WebFXLoadTreeHelpBean.getRemainXmlStr(parentNodeKey));
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
