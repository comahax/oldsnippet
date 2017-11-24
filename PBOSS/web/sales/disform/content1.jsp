<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/contenthead.inc"%>
<%
			response.setCharacterEncoding("GBK");
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=配送单明细导出.xls";
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
				<s:hidden name="form.paytype" />
				<s:hidden name="form.signstate" />
				<s:hidden name="form.orderinfo" />
				
				<input type="hidden" name="_rowcount"
					value="<s:property value="dp.rowCount" />" />
				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right" width="25%">
								<s:text name="recid" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recid" />
							</td>
							<td align="right" width="25%">
								<s:text name="orderid" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.orderid" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="createtime" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:date name="form.createtime" format="yyyy-MM-dd"/>
							</td>
							<td align="right" width="25%">
								<s:text name="arrivetime" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:date name="form.arrivetime" format="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="recewayid" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recewayid" />
							</td>
							<td align="right" width="25%">
								<s:text name="discomcode" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.discomcode" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="paytype" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<j:code2Name definition="$FX_PAYTYPE" code="form.paytype" />
							</td>
							<td align="right" width="25%">
								<s:text name="recamt" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recamt" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="disstate" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<j:code2Name definition="$FX_DISFORMSTATE" code="form.disstate" />
							</td>
							<td align="right" width="25%">
								<s:text name="signstate" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<j:code2Name definition="$FX_SIGNSTATE" code="form.signstate" />
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="orderinfo" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<s:property value="form.orderinfo" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="recename" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recename" />
							</td>
							<td align="right" width="25%">
								<s:text name="recetel" />
								:&nbsp
							</td>
							<td align="left" width="25%">
								<s:property value="form.recetel" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="receadd" />
								:&nbsp
							</td>
							<td align="left" width="25%" colspan="3">
								<s:property value="form.receadd" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								<s:text name="memo" />
								:&nbsp
							</td>
							<td align="left" width="25%" colspan="3">
								<s:property value="form.memo" />
							</td>
						</tr>
					</table>
				</div>
	<aa:zone name="listZone">	
    <div class="table_div">
    	<div class="table_LongTable">
        <table border=1 bordercolor=#A8A8A8 align="center">
            <tr align="center">
            				<td>序号</td>
                			<td><s:text name="detid" /></td>	
							<td><s:text name="comcategory" /></td>	
							<td><s:text name="comid" /></td>	
							<td><s:text name="comid1" /></td>	
							<td><s:text name="batchno" /></td>
							<td><s:text name="boxnum" /></td>
							<td><s:text name="comresid" /></td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                 <tr align="center">
					 <%-- 复合主键用“|”间隔开 --%>
					 		<td>
					 			 <s:text name="#state.count"/>
					 		</td>
							<td>
								<s:property value="detid" />
							</td>
							<td>
								<j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory" />
							</td>
							<td STYLE="mso-number-format:'\@';">
								<s:property value="comid" />
							</td>
							<td>
								<j:code2Name definition="#COMSYSTEM" code="comid" />
							</td>
							<td>
								<s:property value="batchno" />
							</td>
							<td>
								<s:property value="boxnum" />
							</td>
							<td STYLE="mso-number-format:'\@';">
								<s:property value="comresid" />
							</td>														
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
