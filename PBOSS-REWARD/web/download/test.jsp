<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ page import="com.sunrise.boss.ui.commons.ftp.FtpAccess" %>
<%@ page import="com.sunrise.boss.ui.commons.ftp.FtpInfo" %>
<%
try{//以防ftp服务出错影响记录日志
   	FtpAccess ftp = new FtpAccess(FtpInfo.getInstance());
   	String filename="C:/good.txt";
   	if(request.getParameter("filename")!=null){
   		filename=request.getParameter("filename").trim();
   	}
   	String result = ftp.uploadFile(filename, "testcode", false);
    if (result == null) {
      	out.println("上传文件出错");
	}else{
		out.println("哈哈，ftp服务正常，测试成功");
	}
}catch(Exception e){
	out.println(e.getMessage());
	e.printStackTrace();
}
 %>
<html>
<head>
</head>
<body>
<br/>
<br/>由于发现经常遗漏新建web/download/目录
<br/>新建此文件目的在于新建web/download/目录,另外用于测试ftp是否正常。
<br/>注意：sysinfo.properties 生产环境设置
ftp.address= 10.243.212.40
ftp.port=21
ftp.user= cxbak
ftp.password= cxbak123
ftp.workdir= cxbak

</body>
</html>
