<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.logid', '<s:text name="logid"/>', 'f', false, 14);
			addfield('form.optime', '<s:text name="optime"/>', 't', true, 7);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 16);
			addfield('form.oprtype', '<s:text name="oprtype"/>', 'c', true, 8);
			addfield('form.success', '<s:text name="success"/>', 'c', true, 8);
            addfield('form.id', '<s:text name="id"/>', 'f', false, 18);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
			addfield('form.restype', '<s:text name="restype"/>', 'c', true, 32);
			addfield('form.receiveway', '<s:text name="receiveway"/>', 'c', true, 18);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="resloadparamlog_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._dnm_optime"/>
    <s:hidden name="param._de_optime"/>
    <s:hidden name="param._dnl_optime"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._se_oprtype"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_restype"/>
	
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
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="16"/>
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
                <td align="right"><s:text name="id"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.id" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.id" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cityid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="restype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.restype" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="receiveway"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.receiveway" maxlength="18"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/resloadparamlog_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/resloadparamlog_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
