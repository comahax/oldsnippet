<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/contenthead.inc"%>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=配送单状态统计导出.xls";
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
        function ev_checkval() {
			addfield('form.recename', '<s:text name="recename"/>', 'c', true, 32);
			addfield('form.recetel', '<s:text name="recetel"/>', 'c', true, 12);
			addfield('form.receadd', '<s:text name="receadd"/>', 'c', true, 256);
			addfield('form.discomcode', '<s:text name="discomcode"/>', 'c', true, 18);
			addfield('form.disstate', '<s:text name="disstate"/>', 'c', true, 16);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 256);
            return checkval(window);
        }
    </script>
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
                			<td><s:text name="countyid" /></td>
                			<td><s:text name="svccode" /></td>
							<td><s:text name="mareacode" /></td>
							<td><s:text name="disstate" /></td>
							<td><s:text name="num" /></td>
							<td><s:text name="signnum" /></td>
							<td><s:text name="unsignnum" /></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
										<tr class="table_style_content" align="center">
										<td>
					 			 			<s:text name="#state.count"/>
					 					</td>
										<td>
											<j:code2Name definition="#CNTYCOMPANY" code="countyid" />
										</td>
										<td>
											<j:code2Name code="svccode" definition="#SERVCENT" />
										</td>
										<td>
											<j:code2Name code="mareacode" definition="#MICROAREA" />
										</td>
										<td>
											<j:code2Name definition="$FX_DISFORMSTATE" code="disstate" />
										</td>										
										<td>
											<s:property value="num" />
										</td>
										<td>
											<s:property value="signnum" />
										</td>
										<td>
											<s:property value="unsignnum" />
										</td>
									</tr>
								</s:iterator>
								<tr class="table_style_content" align="center">
									<td>
										合计
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
										<s:property value="form.totaldisformnum" />
									</td>
									<td>
										<s:property value="form.totalsignnum" />
									</td>
									<td>
										<s:property value="form.totalunsignnum" />
									</td>
								</tr>
        </table>
        </div>
    </div>
   	 </aa:zone>
			</s:form>
		</div>
	</body>
</html>
