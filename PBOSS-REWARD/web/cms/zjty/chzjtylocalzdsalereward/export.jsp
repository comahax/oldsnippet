<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=终端销量及酬金.xls";
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
            <td><bean:message bundle="chzjtylocalzdsalereward" key="recid"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="cityid"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxlhyj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxllhy"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxllj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdxlhj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxlhyj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxllhy"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxllj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdxlhj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjhyj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjlhy"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjlj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="dzzdcjhj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjhyj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjlhy"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjlj"/></td>
            <td><bean:message bundle="chzjtylocalzdsalereward" key="ysrgdzzdcjhj"/></td>
        </tr>
		<c:forEach var="item" items="${requestScope.LIST.datas}">
            <tr align="center">
                <td><c:out value="${item.recid}"/></td>
                <td><c:out value="${item.cityid}"/></td>
                <td><c:out value="${item.dzzdxlhyj}"/></td>
                <td><c:out value="${item.dzzdxllhy}"/></td>
                <td><c:out value="${item.dzzdxllj}"/></td>
                <td><c:out value="${item.dzzdxlhj}"/></td>
                <td><c:out value="${item.ysrgdzzdxlhyj}"/></td>
                <td><c:out value="${item.ysrgdzzdxllhy}"/></td>
                <td><c:out value="${item.ysrgdzzdxllj}"/></td>
                <td><c:out value="${item.ysrgdzzdxlhj}"/></td>
                <td><c:out value="${item.dzzdcjhyj}"/></td>
                <td><c:out value="${item.dzzdcjlhy}"/></td>
                <td><c:out value="${item.dzzdcjlj}"/></td>
                <td><c:out value="${item.dzzdcjhj}"/></td>
                <td><c:out value="${item.ysrgdzzdcjhyj}"/></td>
                <td><c:out value="${item.ysrgdzzdcjlhy}"/></td>
                <td><c:out value="${item.ysrgdzzdcjlj}"/></td>
                <td><c:out value="${item.ysrgdzzdcjhj}"/></td>
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
            <td><c:out value="${queryTotal[15]}"/></td>
		</tr>
    </table>
  </body>
</html>
