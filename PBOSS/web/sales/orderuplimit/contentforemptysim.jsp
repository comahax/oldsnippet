<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
	<head>
		<title><s:text name="titleUpdate4" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, '14');
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);			
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 50);
			addfield('form.maxstock', '<s:text name="maxstock"/>', 'l', false, 10,0,0,1);
			addfield('form.redalarm', '<s:text name="redalarm"/>', 'l', false, 10,0,0,1);
			addfield('form.yellowalarm', '<s:text name="yellowalarm"/>', 'l', false, 10,0,0,1);
            return checkval(window) && checkMaxStock();
        }
		function checkMaxStock() {
			if(Number($("#maxstock").val()) < Number($("#redalarm").val()) 
					|| Number($("#maxstock").val()) < Number($("#yellowalarm").val())) {
				var alertstr = '<span class=\'errorkey\'>'
							 	+'<span style=\'color:#F00; font-size:12px;\'>[<s:text name="maxstock"/>]</span>'
							 	+'不能小于<span style=\'color:#F00; font-size:12px;\'>[<s:text name="redalarm"/>]</span>'
							 	+'或<span style=\'color:#F00; font-size:12px;\'>[<s:text name="yellowalarm"/>]</span>'
							 	+'</span>';
				errorMessageShow(alertstr);
				return false;
			}
			return true;
		}
    </script>
	</head>
	<body>
		<div class="table_container">
			<s:form action="orderuplimit_save.do" cssStyle="formList" key="formItem"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._se_cityid" />
				<s:hidden name="param._se_countyid" />
				<s:hidden name="param._se_cooptype" />
				<s:hidden name="param._ne_starlevel" />
				<s:hidden name="param._se_brand" />
				<s:hidden name="form.recid" />
				<s:hidden name="form.limitmode" value="STOCKALARM" />
				<s:hidden name="form.sysparamflag" />

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList4" />
						</span>
						<!--
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
			-->
					</div>
				</div>

				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right">
								<s:text name="cityid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="#CITYCOMPANY" name="form.cityid"
										mode="selector" condition="citycompid:${dBAccessUser.cityid }"
										value="${dBAccessUser.cityid}" disabled="true" />
								</s:if>
								<s:else>
									<j:selector definition="#CITYCOMPANY" name="form.cityid"
										mode="selector" condition="citycompid:${dBAccessUser.cityid }"
										value="${dBAccessUser.cityid}" disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="countyid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="#CNTYCOMPANY"
										condition="citycompid:${USER.cityid}" name="form.countyid"
										mode="selector" readonly="true" />
									<font color=red>*</font>
								</s:if>
								<s:else>
									<j:selector definition="#CNTYCOMPANY"
										condition="citycompid:${USER.cityid}" name="form.countyid"
										mode="selector" disabled="true" />
									<font color=red>*</font>
								</s:else>
							</td>
						</tr>

						<tr>
							<td align="right">
								<s:text name="starlevel" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector name="form.starlevel" definition="$CH_STARLEVEL" />
								</s:if>
								<s:else>
									<j:selector name="form.starlevel" definition="$CH_STARLEVEL"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
			            <tr>
			                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
			                <td align="left">
						        <s:if test="CMD != WEB_CMD_SAVE">
			                        <j:selector name="form.comcategory" definition="$IM_FXCOMCATEGORY" mode="picker" readonly="true"/>
			                        <font color=red>*</font>
						        </s:if>
						        <s:else>
									<s:textfield cssStyle="style_input" name="form.comcategory" disabled="true"/>
									<font color=red>*</font>
						        </s:else>
			                </td>
			            </tr>
						<tr>
							<td align="right">
								<s:text name="maxstock" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.maxstock"
										id="maxstock" maxlength="10" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.maxstock"
										id="maxstock" disabled="true" />
								</s:else>
								<font color=red>*</font>
								<s:text name="unit" />
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="redalarm" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.redalarm"
										id="redalarm" maxlength="10" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.redalarm"
										id="redalarm" disabled="true" />
								</s:else>
								<font color=red>*</font>
								<s:text name="unit" />
								,
								<s:text name="lowthenalarm" />
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="yellowalarm" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.yellowalarm"
										id="yellowalarm" maxlength="10" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.yellowalarm"
										id="yellowalarm" disabled="true" />
								</s:else>
								<font color=red>*</font>
								<s:text name="unit" />
								,
								<s:text name="lowthenalarm" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<input type="button" id="btnSave" name="btnSave"
										class="button_Save" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_save"/>"
										onclick="doSave('/sales/orderuplimit_saveforemptysim.do')"
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn('/sales/orderuplimit_listforemptysim.do')">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
