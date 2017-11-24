<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.logid', '<s:text name="logid"/>', 'f', false, 14);
			addfield('form.optime', '<s:text name="optime"/>', 't', true, 7);
			addfield('form.oprcode2', '<s:text name="oprcode2"/>', 'c', true, 16);
			addfield('form.oprtype', '<s:text name="oprtype"/>', 'c', true, 8);
			addfield('form.success', '<s:text name="success"/>', 'c', true, 8);
			addfield('form.emptyno', '<s:text name="emptyno"/>', 'c', true, 21);
			addfield('form.cardmill', '<s:text name="cardmill"/>', 'f', true, 6);
			addfield('form.iccid', '<s:text name="iccid"/>', 'c', true, 21);
			addfield('form.pukno', '<s:text name="pukno"/>', 'c', true, 8);
			addfield('form.begintime', '<s:text name="begintime"/>', 't', true, 7);
			addfield('form.stoptime', '<s:text name="stoptime"/>', 't', true, 7);
			addfield('form.intime', '<s:text name="intime"/>', 't', true, 7);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 15);
			addfield('form.simtype', '<s:text name="simtype"/>', 'f', true, 6);
			addfield('form.usestate', '<s:text name="usestate"/>', 'f', true, 3);
			addfield('form.backup', '<s:text name="backup"/>', 'f', true, 3);
			addfield('form.entertime', '<s:text name="entertime"/>', 't', true, 7);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="emptysimlog_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._dnm_optime"/>
    <s:hidden name="param._de_optime"/>
    <s:hidden name="param._dnl_optime"/>
    <s:hidden name="param._se_oprcode2"/>
    <s:hidden name="param._se_oprtype"/>
    <s:hidden name="param._snm_emptyno"/>
    <s:hidden name="param._snl_emptyno"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._ne_simtype"/>
    <s:hidden name="param._ne_usestate"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="right"><s:text name="logid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.logid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.logid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="optime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.optime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode2"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode2" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprtype" maxlength="8"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="success"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.success" maxlength="8"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="emptyno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.emptyno" maxlength="21"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cardmill"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cardmill" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="iccid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.iccid" maxlength="21"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pukno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.pukno" maxlength="8"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="begintime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.begintime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="stoptime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.stoptime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="intime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.intime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="simtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.simtype" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="usestate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.usestate" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="backup"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.backup" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="entertime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.entertime" maxlength="7"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/emptysimlog_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/emptysimlog_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
