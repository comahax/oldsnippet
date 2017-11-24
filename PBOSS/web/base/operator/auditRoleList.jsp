<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<base  target="_self">
	<head>
		<title><s:text name="titleList" />
		</title>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_operid', '<s:text name="operid"/>', 'c', true, '16');
            addfield('param._se_password', '<s:text name="password"/>', 'c', true, '30');
            return checkval(window);
        }
    </script>
	</head>

	<body>
		<div class="table_container">
		<s:form action="operator_auditingRoleList.do" key="formList" cssStyle="formList"
			theme="simple" onsubmit="return ev_check();">
					<s:hidden name="param._orderby" />
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="param.queryAll" />
			<input type="hidden" name="_rowcount"
				value="<s:property value="dp.rowCount" />" />

			<div class="table_div">
				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>
			</div>

			<div class="table_div">
				<table class="table_normal">
					<tr>
						<td align="center">
							<s:text name="operid" />
							:
						</td>
						<td align="left">
							<s:textfield class="style_input" name="param._se_operid" />
						</td>
						<td align="center">
							<s:text name="opername" />
							:
						</td>
						<td align="left">
							<s:textfield class="style_input" name="param._sk_opername" />
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table class="table_button_list">

					<tr>
						<td>
							<s:i18n name="public">
								<input type="button" id="btnQuery" name="btnQuery"
									class="button_Query" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" onfocus="buttonover(this)"
									onblur="buttonout(this)" value="<s:text name="button_search"/>"
									onClick="doQuery('/base/operator_auditingRoleList.do');">

								
							</s:i18n>
								
						</td>
					</tr>
				</table>
			</div>

			<aa:zone name="listZone">
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style">
							<tr class="table_style_head">
								
								<td>
									<j:orderByImg href="javascript:doOrderby('operid')"><s:text
											name="operid" />
									</j:orderByImg>
								</td>
								
								<td>
									<j:orderByImg href="javascript:doOrderby('opername')"><s:text
											name="opername" />
									</j:orderByImg>
								</td>
								
							</tr>
							<s:iterator value="dp.datas">
								<tr class="table_style_content" align="center"
									onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'"
									 ondblclick="javascript:setValue('<s:property value="operid"/>','<s:property value="opername"  />');">
									
									<td>
										 <a href='#' onclick="javascript:setValue('<s:property value="operid" />','<s:property value="opername" />')">
											<s:property value="operid" /> 
										</a>
									</td>
									
									<td>
										<s:property value="opername" />
									</td>
									
								</tr>
							</s:iterator>
						</table>
					</div>
				</div>
				<div class="table_div">
						<%@ include file="/common/pageNav.jsp"%>
   					</div>
			</aa:zone>
		</s:form>
	</div>
		<script language="javascript"> 
	function setValue(operid,opername){
		window.returnValue=operid+","+opername;
		window.close();
	}
</script>
	</body>
</html>
