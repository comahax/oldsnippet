<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=计件酬金分项汇总.xls";
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
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="recid"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="cityid"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="qqtxzfhcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="yffzqqtcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dgddtkxscj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="szxtkxscj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="czywcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dzzdcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="zhywcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="zzywcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dgddwlk"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="jtkdkhcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="sjywcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="jtywcj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="dsgsyxzd"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="qqtffcjkj"/></td>
            <td><bean:message bundle="chzjtylocaljjrewardtotal" key="total"/></td>
        </tr>
		<c:forEach var="item" items="${requestScope.LIST.datas}">
			<tr align="center">
				<td><c:out value="${item.recid}"/></td>
				<td><c:out value="${item.cityid}"/></td>
				<td><c:out value="${item.qqtxzfhcj}"/></td>
				<td><c:out value="${item.yffzqqtcj}"/></td>
				<td><c:out value="${item.dgddtkxscj}"/></td>
				<td><c:out value="${item.szxtkxscj}"/></td>
				<td><c:out value="${item.czywcj}"/></td>
				<td><c:out value="${item.dzzdcj}"/></td>
				<td><c:out value="${item.zhywcj}"/></td>
				<td><c:out value="${item.zzywcj}"/></td>
				<td><c:out value="${item.dgddwlk}"/></td>
				<td><c:out value="${item.jtkdkhcj}"/></td>
				<td><c:out value="${item.sjywcj}"/></td>
				<td><c:out value="${item.jtywcj}"/></td>
				<td><c:out value="${item.dsgsyxzd}"/></td>
				<td><c:out value="${item.qqtffcjkj}"/></td>
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
			<td><c:out value="${queryTotal[14]}"/></td>
		</tr>
    </table>
  </body>
</html>
