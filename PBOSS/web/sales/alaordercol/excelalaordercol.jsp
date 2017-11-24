<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/contenthead.inc"%>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=预警分配单汇总导出.xls";
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
		
	</head>
	<body>
		<div class="table_container">
			<s:form action="disform_edit.do" cssStyle="formList" key="formList"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._pk" />
				
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
	<table>
 	<tr><td colspan="5"> 导出工号：${USER.oprcode}</td></tr>
 	<tr><td colspan="5"> 导出时间：<%=nowDate%></td></tr>
 	</table>
	<aa:zone name="listZone">	
    <div class="table_div">
    	<div class="table_LongTable">
        <table border=1 bordercolor=#A8A8A8 align="center">
            <tr align="center">
            	<td>序号</td>
                <td><s:text name="countyid"/></td>
                <td><s:text name="svccode"/></td>
                <td><s:text name="macode"/></td>
                <td><s:text name="starlevel"/></td>
                <td><s:text name="alarmlevel"/></td>
                <td><s:text name="brand"/></td>
                <td><s:text name="amount"/></td>
                <td><s:text name="orderamt"/></td>
                <td><s:text name="cancelamt"/></td>
                <td><s:text name="overamt"/></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
				<tr class="table_style_content" align="center">
					 <td><s:text name="#state.count"/></td>
					 <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name code="svccode" definition="#SERVCENT" /></td>
                     <td><j:code2Name code="macode" definition="#MICROAREA" /></td>
                     <td><j:code2Name code="starlevel" definition="$CH_STARLEVEL" /></td>
                     <td><j:code2Name definition="$FX_STOCKALARMLEVEL" code="alarmlevel"/></td>
                     <td><j:code2Name definition="$FX_SMPBRAND" code="brand"/></td>
                     <td><s:property value="amount" /></td>
                     <td><s:property value="orderamt" /></td>
                     <td><s:property value="cancelamt" /></td>
                     <td><s:property value="overamt" /></td>
				</tr>
			</s:iterator>
				<tr class="table_style_content" align="center">
									<td>
										合计
									</td>
									<td ></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td ></td>
             <td><s:property value="form.totalAmount"/></td>
             <td><s:property value="form.totalOrderamt"/></td>
             <td><s:property value="form.totalCancelamt"/></td>
             <td><s:property value="form.totalOveramt"/></td>
								</tr>
        </table>
        </div>
    </div>
   	 </aa:zone>
			</s:form>
		</div>
	</body>
</html>
