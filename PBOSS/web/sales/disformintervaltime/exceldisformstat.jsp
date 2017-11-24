<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/contenthead.inc"%>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=配送单超时预警统计导出.xls";
			response.setHeader("Content-Disposition", new String(
					fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("application/x-msdownload");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String nowDate = format.format(new Date());
%>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script language="JavaScript">
    </script>
<style>
td {
	border:#a8a8a8 soild 1px;
	color:#000;
	font-size:12px;
	text-align:center;
	background:#FFFFFF;
	mso-number-format:"\@";
}
</style>
	</head>
	<body>
		<div class="table_container">
			<s:form action="disformintervaltime_disformstat.do" cssStyle="formList" key="formList"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._pk" />
				
				<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />" />
	<table>
	<tr><td align="center" colspan="5"> 配送单超时预警统计导出  </td></tr>
 	<tr><td align="left" colspan="5"> 导出工号：${USER.oprcode}</td></tr>
 	<tr><td align="left" colspan="5"> 导出时间：<%=nowDate%></td></tr>
 	<tr><td align="left" colspan="5"> 统计区间：<s:property value="param._dnl_createtime"/>至<s:property value="param._dnm_createtime"/></td></tr>
 	</table>
	<aa:zone name="listZone">	
    <div class="table_div">
    	<div class="table_LongTable">
        <table border=1 bordercolor=#A8A8A8 align="center">
            <tr align="center">
                			<td><s:text name="countyid"/></td>
                			<td><s:text name="mareacode"/></td>
                			<td><s:text name="starlevel"/></td>
			                <td>订单总数</td>
			                <td>超时订单数</td>							
            </tr>
            <s:iterator value="dp.datas" status="state">
				<tr class="table_style_content" align="center">
					 <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><j:code2Name definition="$CH_STARLEVEL" code="starlevel"/></td>
                     <td><s:property value="totalorder" /></td>
                     <td><s:property value="totalovertime" /></td>
				</tr>
			</s:iterator>
        </table>
        </div>
    </div>
   	 </aa:zone>
			</s:form>
		</div>
	</body>
</html>
