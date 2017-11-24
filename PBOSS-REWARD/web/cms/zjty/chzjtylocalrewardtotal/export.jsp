<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=酬金汇总.xls";
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
            <td><bean:message bundle="chzjtylocalrewardtotal" key="recid"/></td>
            <td><bean:message bundle="chzjtylocalrewardtotal" key="cityid"/></td>
            <td><bean:message bundle="chzjtylocalrewardtotal" key="gdreward"/></td>
            <td><bean:message bundle="chzjtylocalrewardtotal" key="jjreward"/></td>
            <td><bean:message bundle="chzjtylocalrewardtotal" key="cereward"/></td>
            <td><bean:message bundle="chzjtylocalrewardtotal" key="ywkj"/></td>
            <td><bean:message bundle="chzjtylocalrewardtotal" key="total"/></td>
        </tr>
		<c:forEach var="item" items="${requestScope.LIST.datas}">
            <tr align="center">
                <td><c:out value="${item.recid}"/></td>
                <td><c:out value="${item.cityid}"/></td>
                <td><c:out value="${item.gdreward}"/></td>
                <td><c:out value="${item.jjreward}"/></td>
                <td><c:out value="${item.cereward}"/></td>
                <td><c:out value="${item.ywkj}"/></td>
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
        </tr>
    </table>
  </body>
</html>
