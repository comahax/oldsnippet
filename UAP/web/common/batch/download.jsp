<%@ page language="java" import="com.sunrise.boss.web.common.batch.download.*"%>
<jsp:useBean id="upload" scope="page" class="com.sunrise.boss.web.common.batch.download.SmartUpload" />
<%
  String filename=request.getParameter("filename");
  if(filename==null || "".equals(filename)){
   filename=(String)request.getAttribute("filename");
  }
  upload.initialize(pageContext);
  upload.setContentDisposition(null);
  upload.downloadFile(filename);
  out.clear(); 
  out = pageContext.pushBody(); 
%>

