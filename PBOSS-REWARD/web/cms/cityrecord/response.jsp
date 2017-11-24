<%@ page language="java" import="java.util.*"%>
<%@page
	import="com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean"%>
<%
try{
    int i=0;
	String beanname=request.getParameter("beanname");
	HashMap beanMap=(HashMap)session.getAttribute("beanMap");
	if(beanMap==null){
	  out.print("-1|-1|-1|-1|-1"+"|1"+beanname);
	  return;
	}
	BaseBatchTaskBean task=(BaseBatchTaskBean)beanMap.get(beanname);
	if(task==null){
	  out.print("-1|-1|-1|-1|-1"+"|2"+beanname);
	  return ;
	}
	if(task.getPercent()<100){
		out.print(task.getPercent()+"|"+task.getCountrecord()+"|"+task.getOk()+"|"+task.getFail()+"|"+task.getResultFile()+"|"+task.getCheckFile());
		return;
	}
	if(task.getPercent()==100){
	    out.print("100|"+task.getCountrecord()+"|"+task.getOk()+"|"+task.getFail()+"|"+task.getResultFile()+"|"+task.getCheckFile());
		 beanMap.remove(beanname);
		return;
	}
}catch(Exception ex){
  	ex.printStackTrace();
}
%>
