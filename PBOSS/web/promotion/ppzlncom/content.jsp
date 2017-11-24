<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script language="JavaScript">
        function ev_checkval() {
        	addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 32);
            return checkval(window);
        }
        function doReturn(str){
        	formItem.action = "<%=contextPath%>/promotion/ppzlncom_list.do?param._pk="+str;
        	formItem.submit();
        }
    </script>
	</head>
	<body>
		<div class="table_container">
			<s:form action="ppzlncom_save.do" cssStyle="formList" key="formItem"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="form.pid" />

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
							<td align="right" width="25%">
								������Ʒ����:&nbsp
							</td>
							<td aligh="left">
								<s:if test="CMD == WEB_CMD_NEW">
								<j:selector definition="$IM_FXCOMCATEGORY" mode="picker"
									name="form.comcategory" cssStyle="style_input" />
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<j:selector definition="$IM_FXCOMCATEGORY" mode="picker"
									name="form.comcategory" cssStyle="style_input" disabled="true"/>
								<font color=red>*</font>
								</s:elseif>
								<s:else>
									<j:selector definition="$IM_FXCOMCATEGORY" mode="picker"
									name="form.comcategory" cssStyle="style_input" disabled="true"/>
								<font color=red>*</font>
								</s:else>
							</td>
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
										onclick="doSave('/promotion/ppzlncom_save.do')" 
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
										/>
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn(document.all['form.pid'].value)">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
