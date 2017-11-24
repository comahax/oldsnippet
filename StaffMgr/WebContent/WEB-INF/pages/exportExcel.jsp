<%@ page language="java" contentType="application/vnd.ms-excel;charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String fileName = (String)request.getAttribute("fileName");
response.setHeader("Content-Disposition","inline;filename=\"" + 
                       new String(fileName.getBytes("GB2312"), "ISO-8859-1") + "\"");
%>
<html xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:x="urn:schemas-microsoft-com:office:excel"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<meta name="ProgId" content="Excel.Sheet">
<meta name="Generator" content="Microsoft Excel 11">
<link rel="File-List" href="Page.files/filelist.xml">
<style>
TABLE {
	border-collapse: collapse;;
	cursor: default;
}

.table_view {
	width: 100%;
	font-size: 12px;
	color: #000;
	background: #F8F8F7;
	border-bottom: #CECECE solid 1px;
	border-collapse: collapse;
}

.table_title td{
	font-size: 16px;
	color: #ff0000;
	padding-top: 0px;
	padding-bottom: 0px;
	border: #CECECE solid 1px;
}

.table_title{
	height: 30px;
	background-color: #fff !important;
}

.table_view tr {
	height: 20px;
}

.table_view th {
	padding-top: 0px;
	padding-bottom: 0px;
	background-color: #ddeeff;
	border: #CECECE solid 1px;
	color: #000000;
}

.table_view td {
	padding-top: 0px;
	padding-bottom: 0px;
	border: #CECECE solid 1px;
}

</style>
</head>

<body>
<!--[if !excel]>　　<![endif]-->
<!--下列信息由 Microsoft Office Excel 的“发布为网页”向导生成。-->
<!--如果同一条目从 Excel 中重新发布，则所有位于 DIV 标记之间的信息均将被替换。-->
<!----------------------------->
<!--“从 EXCEL 发布网页”向导开始-->
<!----------------------------->
<c:if test="${not empty printData}">
<div id="内容" align="center" x:publishsource="Excel">
<c:if test="${not empty printData.title}">
	<h4>${printData.title}</h4>
</c:if>
<c:forEach items="${printData.tables}" var="table">
<table class="table_view" style="width: 100%;">
		<c:if test="${not empty table.title }">
			<tr class="table_title"><td colspan="${fn:length(table.theads)}" x:str="${table.title}"></td></tr>
		</c:if>

		<tr align="center">
			<c:forEach items="${table.theads}" var="thead">
			<th>${thead}</th>
			</c:forEach>
		</tr>

		<c:forEach items="${table.items}" var="item">
			<tr>
			<c:forEach var="col" items="${item}">
					<td x:str="${col}"></td>
			</c:forEach>
			</tr>
		</c:forEach> 
</table>
<table  style="width: 100%;">
			<tr>
					<td x:str=""></td>
					<td x:str=""></td>
			</tr>
</table>
</c:forEach>

</div>
</c:if>
<c:if test="${empty printData}">
	<h3>no data</h3>
</c:if>

<!----------------------------->
<!--“从 EXCEL 发布网页”向导结束-->
<!----------------------------->
</body>

</html>