<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="org.apache.commons.lang.StringUtils" %><%
	com.sunrise.boss.ui.cms.way.WayTreeBean wayTreeBean = new com.sunrise.boss.ui.cms.way.WayTreeBean(); 
	try {
		String childrenURL = (String)request.getParameter("childrenURL");
		String function = (String)request.getParameter("function");
		String proxy=(String)request.getParameter("orgproxy");
		String orgtype=(String)request.getParameter("orgtype");
		String times=request.getParameter("times");
		if(!StringUtils.isBlank( childrenURL ) ) 
			wayTreeBean.setChildrenURL(childrenURL);
		
		if(!StringUtils.isBlank( function ))
			wayTreeBean.setFunction(function);
			
		if(!StringUtils.isBlank( proxy ))
			wayTreeBean.setQueryText(proxy);
			
		if(!StringUtils.isBlank( times ))
			wayTreeBean.setCurrentime(times);
			
		wayTreeBean.setOrgtype(orgtype);
		out.println(wayTreeBean.outputXml(request));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
%>