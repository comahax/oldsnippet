<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._se_operid', '<s:text name="operid"/>', 'c', true, '16');
            addfield('param._sk_opername', '<s:text name="opername"/>', 'c', true, '64');
            addfield('param._se_orgid', '<s:text name="orgid"/>', 'c', false, '32');
            return checkval(window);
        }
    </script>
	</head>

	<body>
		<div class="table_container">
		<s:form action="operator_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
			<aa:zone name="hiddenZone">
			<s:hidden name="param._orderby"/>
			<s:hidden name="param._desc" />
			<s:hidden name="param._pageno" />
			<s:hidden name="param._pagesize" />
			<s:hidden name="param.queryAll" />
			<input type="hidden" name="_rowcount"value="<s:property value="dp.rowCount" />"/></aa:zone>

		<div>
			<div class="table_top">
				<div class="table_topleft"></div>
				<div class="table_toparea_w">
					<s:i18n name="public">
						<span class="table_toparea"><s:text name="currentPos" /> </span>
						<span class="table_toparea_xi">></span>
						<span class="table_toparea"><s:text name="base" /> </span>
						<span class="table_toparea_xi">></span>	
					</s:i18n>
					<span class="table_toparea_h"><s:text name="titleList" />
					</span>
					<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n>
					</span>
				</div>
			</div>
		</div>
			<aa:zone name="errorZone">
			<div class="table_div">
				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>
			</div>
			</aa:zone>
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
					<tr>
						<td align="center">
							<s:text name="orgid" />
							:
						</td>
						<td align="left">
							<s:textfield class="style_input" name="param._se_orgid"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'param._se_orgid');this.value='...';" />
						</td>
						<td align="center">
							查询所有下级
							:
						</td>
						<td><s:checkbox name="param.isCheck" theme="simple"/></td>
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
									onClick="doQuery('/base/operator_list.do');">
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
								<s:i18n name="public">
								</s:i18n>
								<td>
									<j:orderByImg href="javascript:doOrderby('operid')"><s:text
											name="operid" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('opername')"><s:text
											name="opername" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('orgid')"><s:text
											name="orgid" /></j:orderByImg>
								</td>
								<td><s:text name="orgidname" /></td>
								<td>
									<j:orderByImg href="javascript:doOrderby('contactphone')"><s:text
											name="contactphone" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('opergroup')"><s:text
											name="opergroup" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('opertype')"><s:text
											name="opertype" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('operlevel')"><s:text
											name="operlevel" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('ismanager')"><s:text
											name="ismanager" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('status')"><s:text
											name="status" /></j:orderByImg>
								</td>
								<td>
									<j:orderByImg href="javascript:doOrderby('statusdate')"><s:text
											name="statusdate" /></j:orderByImg>
								</td>
							</tr>
							<s:iterator value="dp.datas">
								<tr class="table_style_content" align="center"
									onMouseMove="this.bgColor='F0F5F9'"
									onMouseOut="this.bgColor='#ffffff'">
									<%-- ?????÷?ü???°|?±?????? --%>
									<td>
										<s:property value="operid" /> 
									</td>
									<td>
										<s:property value="opername" />
									</td>
									<td>
										<s:property value="orgid" />
									</td>
									<td><j:code2Name definition="#WAYIDINFO" code="orgid" /></td>
									<td>
										<s:property value="contactphone" />
									</td>
									<td>
										<s:property value="opergroup" />
									</td>
									<td>
										<j:code2Name definition="OPERTYPE" code="opertype" />
									</td>
									<td>
										<s:property value="operlevel" />
									</td>
									<td>
										<j:code2Name definition="$IM_YESNO10" code="ismanager" />
									</td>
									<td>
										<j:code2Name definition="$CH_OPRSTATUS" code="status" />
									</td>
									<td>
										<s:date name="statusdate" format="yyyy-MM-dd"/>
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
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
	
	</body>
</html>
