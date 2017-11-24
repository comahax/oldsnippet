<%@ page language="java" import="com.gmcc.pboss.common.batch.download.*"%>
<%
com.gmcc.pboss.common.batch.download.SmartUpload upload=new com.gmcc.pboss.common.batch.download.SmartUpload();
//System.out.println("---------"+request.getParameter("filename"));
	String filename = new String(request.getParameter("filename").getBytes("ISO-8859-1"), "GBK");   
  //System.out.println("---------"+filename);
  if(filename==null || "".equals(filename)){
   filename=(String)request.getAttribute("filename");
  }
  upload.initialize(pageContext);
  upload.setContentDisposition(null);
  upload.downloadFile(filename);
  out.clear(); 
  out = pageContext.pushBody(); 
%>

