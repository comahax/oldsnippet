<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<html>
<head>
	<title>�쳣��ʾ</title>
	<link href="<%=contextPath%>/css/baocuo.css" rel="stylesheet" type="text/css" />
</head>
<base target="_self"/>
<body>
<div>
<sj:dialog id="mydialog" title="��¼����!" modal="true" width="800" height="300" resizable="false" draggable="false">
	<div class="bao"></div>
	<div class="baocuo_right">
	<div class="baocuo_dazi">
	  <a href="#" target="_parent" style="font-size:14px;font-weight:100;color:#0A5192;">��������½</a>
	</div>
	<hr noshade style="border:#C0D2EC solid 1px;height:1px;">
	<div class="baocuo_xiaozi">
	  			  �𾴵��û������ã� ����û�е�½�������ӳ�ʱ�� �����µ�¼�� лл!
	</div>
	</div>
</sj:dialog>
</div>
</body>
</html>
