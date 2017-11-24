<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="org.apache.commons.lang.StringUtils"%><%com.sunrise.boss.ui.cms.opntree.OpnTreeBean treeBean = new com.sunrise.boss.ui.cms.opntree.OpnTreeBean(); 
	try {
		String childrenURL = (String)request.getParameter("childrenURL");
		String function = (String)request.getParameter("function");
		
		String isLeaf=(String)request.getParameter("isLeaf");
		String times = (String)request.getParameter("times");
		
		String _sk_name=(String)request.getSession().getAttribute("_sk_name");
		String _ne_opnid=(String)request.getSession().getAttribute("_ne_opnid");
		String showdisabled=(String)request.getSession().getAttribute("showDisabled");
		
		if(!StringUtils.isBlank( childrenURL ) ) 
			treeBean.setChildrenURL(childrenURL);
		if(!StringUtils.isBlank( function ))
			treeBean.setFunction(function);
		treeBean.setIsLeaf(isLeaf);
		if(!StringUtils.isEmpty( _ne_opnid ))
			treeBean.set_ne_opnid(_ne_opnid);
		if(!StringUtils.isEmpty( _sk_name ))
			treeBean.set_sk_name(_sk_name);
		if(!StringUtils.isEmpty( showdisabled )){
			treeBean.setShowDisabled(showdisabled);
		}else{
			treeBean.setShowDisabled("false");
		}
		if(!StringUtils.isEmpty( times )){
			treeBean.setCurrentime(times);
		}
		out.println(treeBean.outputXml(request));
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
