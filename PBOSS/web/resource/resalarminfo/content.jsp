<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
</head>
<body>
<div class="table_container">
<s:form action="resalarminfo_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._dnm_alarmdate"/>
    <s:hidden name="param._dnl_alarmdate"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_comcategory"/>
    <s:hidden name="param._se_alarmsignal"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="base"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.recid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="alarmdate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.alarmdate" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.alarmdate" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.countyid" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.comcategory" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.comcategory" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="stockamt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.stockamt" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.stockamt" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="saledamt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.saledamt" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.saledamt" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actedamt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actedamt" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actedamt" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actrate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actrate" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actrate" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="alarmsignal"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.alarmsignal" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.alarmsignal" disabled="true"/>
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
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/resalarminfo_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/resalarminfo_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script language="JavaScript">
	function ev_checkval() {
		addfield('form.recid', '<s:text name="recid"/>', 'f', false, 14);
		addfield('form.alarmdate', '<s:text name="alarmdate"/>', 't', true, 7);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 14);
		addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', true, 20);
		addfield('form.stockamt', '<s:text name="stockamt"/>', 'f', true, 10);
		addfield('form.saledamt', '<s:text name="saledamt"/>', 'f', true, 10);
		addfield('form.actedamt', '<s:text name="actedamt"/>', 'f', true, 10);
		addfield('form.actrate', '<s:text name="actrate"/>', 'f', true, 16);
		addfield('form.alarmsignal', '<s:text name="alarmsignal"/>', 'c', true, 20);
		return checkval(window);
	}
</script>