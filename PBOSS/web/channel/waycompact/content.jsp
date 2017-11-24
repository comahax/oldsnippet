<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.compactno', '<s:text name="compactno"/>', 'c', true, 17);
			addfield('form.compactname', '<s:text name="compactname"/>', 'c', true, 255);
			addfield('form.begintime', '<s:text name="begintime"/>', 't', true, 7);
			addfield('form.endtime', '<s:text name="endtime"/>', 't', true, 7);
			addfield('form.signtime', '<s:text name="signtime"/>', 't', true, 7);
			addfield('form.coptype', '<s:text name="coptype"/>', 'f', true, 3);
			addfield('form.copbound', '<s:text name="copbound"/>', 'c', true, 40);
			addfield('form.recomrule', '<s:text name="recomrule"/>', 'c', true, 255);
			addfield('form.compact', '<s:text name="compact"/>', 'f', true, 4000);
			addfield('form.compacttype', '<s:text name="compacttype"/>', 'f', true, 2);
			addfield('form.compactpath', '<s:text name="compactpath"/>', 'c', true, 255);
			addfield('form.licenceno', '<s:text name="licenceno"/>', 'c', true, 64);
			addfield('form.licencepath', '<s:text name="licencepath"/>', 'c', true, 255);
			addfield('form.runareatype', '<s:text name="runareatype"/>', 'f', true, 2);
			addfield('form.principal', '<s:text name="principal"/>', 'c', true, 64);
			addfield('form.bail', '<s:text name="bail"/>', 'f', true, 18);
			addfield('form.bailstatus', '<s:text name="bailstatus"/>', 'f', true, 2);
			addfield('form.isb2m', '<s:text name="isb2m"/>', 'f', true, 1);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="waycompact_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
	
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
		</div>
	</div>

	<aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
	</aa:zone>
	
	<aa:zone name="contentZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="compactno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.compactno" maxlength="17"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="compactname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.compactname" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="begintime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.begintime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="endtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.endtime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="signtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.signtime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="coptype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.coptype" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="copbound"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.copbound" maxlength="40"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="recomrule"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.recomrule" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="compact"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.compact" maxlength="4000"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="compacttype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.compacttype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="compactpath"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.compactpath" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="licenceno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.licenceno" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="licencepath"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.licencepath" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="runareatype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.runareatype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="principal"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.principal" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bail"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bail" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bailstatus"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bailstatus" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isb2m"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isb2m" maxlength="1"/>
                </td>
            </tr>
        </table>
    </div>
	</aa:zone>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/waycompact_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/waycompact_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnSave");
</script>
</body>
</html>
