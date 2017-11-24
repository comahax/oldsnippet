<%@ page language="java" contentType="text/xml;charset=GBK"%><%@ page import="org.apache.commons.lang.StringUtils" %><%
	com.gmcc.pboss.web.channel.way.tree.WayTreeBean wayTreeBean = new com.gmcc.pboss.web.channel.way.tree.WayTreeBean(); 
	try {
		String path="[\u4e00-\u9fa5]";
		java.util.regex.Pattern pattern=java.util.regex.Pattern.compile(path);
		String childrenURL = (String)request.getParameter("childrenURL");
		String function = (String)request.getParameter("function");
		String showDisabled = (String)request.getParameter("showDisabled");
		String queryText = ((String)request.getParameter("queryText"));
		//queryText = (String)request.getSession().getAttribute("selectwaytree_queryText" );
		String waytype=request.getParameter("waytype");
		String waysubtype=request.getParameter("waysubtype");
		String time=request.getParameter("time");
		String runmode=request.getParameter("runmode");
		String layer=request.getParameter("layer");
		if(!StringUtils.isBlank( childrenURL ) ) 
			wayTreeBean.setChildrenURL(childrenURL);
		
		if(!StringUtils.isBlank( function ))
			wayTreeBean.setFunction(function);
		
		if(StringUtils.isNotBlank(showDisabled))
			wayTreeBean.setShowDisabled(showDisabled);
		
		if(StringUtils.isNotBlank(queryText)){
			java.util.regex.Matcher matcher=pattern.matcher(queryText);
			if(matcher.find()){
			wayTreeBean.setQueryText(queryText); 
			}else{
			wayTreeBean.setQueryText(new String(queryText.getBytes("iso8859-1"),"gbk")); 
			}
			System.out.println("***************"+System.getProperty("file.encoding"));
			}
			
		if(StringUtils.isNotBlank(waytype))
			wayTreeBean.setWaytype(waytype);
			
		if(StringUtils.isNotBlank(waysubtype))
			wayTreeBean.setWaysubtype(waysubtype);
			
	    if(StringUtils.isNotEmpty(runmode))
	       wayTreeBean.setRunmode(runmode);
		if(StringUtils.isNotEmpty(layer))
			wayTreeBean.setLayer(layer);
			
		wayTreeBean.setCurrentime(time);
		out.println(wayTreeBean.outputXml(request));
		
	}catch(Exception e) {
		e.printStackTrace();
	}
%>
