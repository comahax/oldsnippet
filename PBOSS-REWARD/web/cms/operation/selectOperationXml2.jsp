<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="org.apache.commons.lang.StringUtils" %><%
	com.sunrise.boss.ui.cms.operation.OperationTreeBean wayTreeBean = new com.sunrise.boss.ui.cms.operation.OperationTreeBean(); 
	try {
		String childrenURL = (String)request.getParameter("childrenURL");
		String function = (String)request.getParameter("function");
		String showdisable=(String)request.getParameter("showdisable");
		String opntype=(String)request.getParameter("opntype");
		String times=request.getParameter("times");
		String name=(String)request.getSession().getAttribute("_sk_name");
		String opnid=(String)request.getSession().getAttribute("_ne_opnid");
		if(!StringUtils.isBlank( childrenURL ) ) 
			wayTreeBean.setChildrenURL(childrenURL);
		
		if(!StringUtils.isBlank( function ))
			wayTreeBean.setFunction(function);
			
			
		if(!StringUtils.isBlank( times ))
			wayTreeBean.setCurrentime(times);
			
		wayTreeBean.setOpntype(opntype);
		if(!StringUtils.isEmpty( opnid ))
		wayTreeBean.set_ne_opnid(opnid);
		if(!StringUtils.isEmpty( name ))
		wayTreeBean.set_sk_name(name);
		wayTreeBean.setShowDisabled(showdisable);
		out.println(wayTreeBean.outputXml(request));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
