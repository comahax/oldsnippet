<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
			addfield('form.tmplname', '<s:text name="tmplname"/>', 'c', false, 50);
			addfield('form.gatheringmode', '<s:text name="gatheringmode"/>', 'c', false, 32);
			addfield('form.columnsinfo', '<s:text name="columnsinfo"/>', 'c', false, 64);
			addfield('form.gatheringlogic', '<s:text name="gatheringlogic"/>', 'c', false, 1024);
			addfield('form.state', '<s:text name="state"/>', 'c', false, 32);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 512);
            return checkval(window);
        }
    </script>
	</head>
	<body>
		<div class="table_container">
			<s:form action="elmttmpl_save.do" cssStyle="formList" key="formItem"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="form.tmplid" />


				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="promotion" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n>
						</span>
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
								<s:text name="tmplname" />:
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textfield cssStyle="style_input" name="form.tmplname"
										maxlength="50" />
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textfield cssStyle="style_input" name="form.tmplname"
										maxlength="50" />
									<font color=red>*</font>
								</s:elseif>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.tmplname"
										maxlength="50" disabled="true" />
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="state" />:
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<j:selector definition="$CH_KHSTATE" name="form.state"
										cssStyle="select" value="1" />
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<j:selector definition="$CH_KHSTATE" name="form.state"
										cssStyle="select" value="1" />
								</s:elseif>
								<s:else>
									<j:selector definition="$CH_KHSTATE" name="form.state"
										cssStyle="select" value="1" disabled="true" />
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="gatheringmode" />:
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<j:selector definition="$CH_GATHERINGMODE"
										name="form.gatheringmode" cssStyle="select" />
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<j:selector definition="$CH_GATHERINGMODE"
										name="form.gatheringmode" cssStyle="select" />
									<font color=red>*</font>
								</s:elseif>
								<s:else>
									<j:selector definition="$CH_GATHERINGMODE"
										name="form.gatheringmode" cssStyle="select"
										disabled="true" />
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="columnsinfo" />:
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textfield cssStyle="width:581px" name="form.columnsinfo"
										maxlength="64" />
									<font color=red>*</font><br>
									注:多个字段以"半角竖线[ | ]"分隔, 并以"半角竖线[ | ]"结束
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textfield cssStyle="width:581px" name="form.columnsinfo"
										maxlength="64" />
									<font color=red>*</font><br>
									注:多个字段以"半角竖线[ | ]"分隔, 并以"半角竖线[ | ]"结束
								</s:elseif>
								<s:else>
									<s:textfield cssStyle="width:581px" name="form.columnsinfo"
										maxlength="64"  disabled="true" />
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="gatheringlogic" />:
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textarea cssStyle="style_input" name="form.gatheringlogic"
										maxlength="1024" cols="80" rows="9" />
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textarea cssStyle="style_input" name="form.gatheringlogic"
										maxlength="1024" cols="80" rows="9" />
									<font color=red>*</font>
								</s:elseif>
								<s:else>
									<s:textarea cssStyle="style_input" name="form.gatheringlogic"
										maxlength="1024" cols="80" rows="9" disabled="true" />
								</s:else>
							</td>
						</tr>

						<tr>
							<td align="right">
								<s:text name="memo" />:
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textarea cssStyle="style_input" name="form.memo"
										maxlength="512" cols="80" rows="5" />
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textarea cssStyle="style_input" name="form.memo"
										maxlength="512" cols="80" rows="5" />
								</s:elseif>
								<s:else>
									<s:textarea cssStyle="style_input" name="form.memo"
										maxlength="512" cols="80" rows="5" disabled="true" />
								</s:else>
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
										onclick="doSave('/promotion/elmttmpl_save.do')"
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn('/promotion/elmttmpl_list.do')">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
