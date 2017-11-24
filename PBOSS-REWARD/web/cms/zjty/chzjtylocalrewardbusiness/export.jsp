<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=计件酬金分项业务量数据.xls";
	response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
	response.setContentType("application/x-msdownload");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String nowDate = format.format(new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
	<table>
	 	<tr><td colspan="5">导出工号：<c:out value="${_USER.opercode}"/></td></tr>
	 	<tr><td colspan="5">导出时间：<%=nowDate%></td></tr>
 	</table>
    <table border="1" bordercolor="#A8A8A8">
        <tr>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="recid"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="cityid"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="qqtxzfh"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="yffzqqt"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="dgddtkxs"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="szxtkxs"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="czyw"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="dzzd"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="zhyw"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="zzyw"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="dgddwlk"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="jtkdkh"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="sjyw"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="jtyw"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="dsgsyxzdlyw"/></td>
            <td><bean:message bundle="chzjtylocalrewardbusiness" key="total"/></td>
        </tr>
        <c:forEach var="item" items="${requestScope.LIST.datas}">
             <tr align="center">
                 <td><c:out value="${item.recid}"/></td>
                 <td><c:out value="${item.cityid}"/></td>
                 <td><c:out value="${item.qqtxzfh}"/></td>
                 <td><c:out value="${item.yffzqqt}"/></td>
                 <td><c:out value="${item.dgddtkxs}"/></td>
                 <td><c:out value="${item.szxtkxs}"/></td>
                 <td><c:out value="${item.czyw}"/></td>
                 <td><c:out value="${item.dzzd}"/></td>
                 <td><c:out value="${item.zhyw}"/></td>
                 <td><c:out value="${item.zzyw}"/></td>
                 <td><c:out value="${item.dgddwlk}"/></td>
                 <td><c:out value="${item.jtkdkh}"/></td>
                 <td><c:out value="${item.sjyw}"/></td>
                 <td><c:out value="${item.jtyw}"/></td>
                 <td><c:out value="${item.dsgsyxzdlyw}"/></td>
                 <td><c:out value="${item.total}"/></td>
             </tr>
         </c:forEach>
     	<tr align="center">
             <td colspan="2">合计</td>
             <td><c:out value="${queryTotal[0]}"/></td>
             <td><c:out value="${queryTotal[1]}"/></td>
             <td><c:out value="${queryTotal[2]}"/></td>
             <td><c:out value="${queryTotal[3]}"/></td>
             <td><c:out value="${queryTotal[4]}"/></td>
             <td><c:out value="${queryTotal[5]}"/></td>
             <td><c:out value="${queryTotal[6]}"/></td>
             <td><c:out value="${queryTotal[7]}"/></td>
             <td><c:out value="${queryTotal[8]}"/></td>
             <td><c:out value="${queryTotal[9]}"/></td>
             <td><c:out value="${queryTotal[10]}"/></td>
             <td><c:out value="${queryTotal[11]}"/></td>
             <td><c:out value="${queryTotal[12]}"/></td>
             <td><c:out value="${queryTotal[13]}"/></td>
         </tr>
    </table>
  </body>
</html>
