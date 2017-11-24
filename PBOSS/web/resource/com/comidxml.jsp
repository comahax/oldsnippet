<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="org.apache.commons.lang.StringUtils" %><%
com.gmcc.pboss.web.resource.common.ComidTreeBean comidTreeBean = new com.gmcc.pboss.web.resource.common.ComidTreeBean(); 
	try {
		String childrenURL = (String)request.getParameter("childrenURL");
		String function = (String)request.getParameter("function");
		String condition = request.getParameter("condition");
		String filterFlag = request.getParameter("filterFlag");
		if(!StringUtils.isBlank( childrenURL ) ) 
			comidTreeBean.setChildrenURL(childrenURL);
		
		if(!StringUtils.isBlank( function ))
			comidTreeBean.setFunction(function);
		
		if(!StringUtils.isBlank( condition )){
			comidTreeBean.setCondition(condition);
		}
		if(!StringUtils.isBlank( filterFlag )){
			//filterFlag = new String(filterFlag.getBytes("ISO-8859-1"));
			comidTreeBean.setFilterFlag(filterFlag);
		}
		out.println(comidTreeBean.outputXml(request));
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
