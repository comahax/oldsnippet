<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ page import="com.sunrise.boss.ui.commons.ftp.FtpAccess" %>
<%@ page import="com.sunrise.boss.ui.commons.ftp.FtpInfo" %>
<%
try{//�Է�ftp�������Ӱ���¼��־
   	FtpAccess ftp = new FtpAccess(FtpInfo.getInstance());
   	String filename="C:/good.txt";
   	if(request.getParameter("filename")!=null){
   		filename=request.getParameter("filename").trim();
   	}
   	String result = ftp.uploadFile(filename, "testcode", false);
    if (result == null) {
      	out.println("�ϴ��ļ�����");
	}else{
		out.println("������ftp�������������Գɹ�");
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
<br/>���ڷ��־�����©�½�web/download/Ŀ¼
<br/>�½����ļ�Ŀ�������½�web/download/Ŀ¼,�������ڲ���ftp�Ƿ�������
<br/>ע�⣺sysinfo.properties ������������
ftp.address= 10.243.212.40
ftp.port=21
ftp.user= cxbak
ftp.password= cxbak123
ftp.workdir= cxbak

</body>
</html>
