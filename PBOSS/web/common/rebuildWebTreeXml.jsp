<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="com.gmcc.pboss.web.common.xtree.WebFXLoadTreeHelpBean" %><%
	try {
		//�����ϼ��ڵ�����¼�ʣ��δչʾ�ڵ�����
		String parentNodeKey = (String)request.getParameter("parentNodeKey");
		out.println(WebFXLoadTreeHelpBean.getRemainXmlStr(parentNodeKey));
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
