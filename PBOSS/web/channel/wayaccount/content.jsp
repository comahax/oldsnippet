<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.accid', '<s:text name="accid"/>', 'f', false, 6);
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.chargetype', '<s:text name="chargetype"/>', 'f', true, 3);
			addfield('form.accttype', '<s:text name="accttype"/>', 'f', true, 3);
			addfield('form.acctno', '<s:text name="acctno"/>', 'c', true, 50);
			addfield('form.acctname', '<s:text name="acctname"/>', 'c', true, 128);
			addfield('form.bankname', '<s:text name="bankname"/>', 'c', true, 128);
			addfield('form.dsbank', '<s:text name="dsbank"/>', 'c', true, 128);
			addfield('form.bankaddr', '<s:text name="bankaddr"/>', 'c', true, 255);
			addfield('form.contact', '<s:text name="contact"/>', 'c', true, 128);
			addfield('form.contel', '<s:text name="contel"/>', 'c', true, 30);
			addfield('form.rectime', '<s:text name="rectime"/>', 't', true, 7);
			addfield('form.starttime', '<s:text name="starttime"/>', 't', true, 7);
			addfield('form.endtime', '<s:text name="endtime"/>', 't', true, 7);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 255);
			addfield('form.bossarea', '<s:text name="bossarea"/>', 'c', true, 14);
			addfield('form.acctfid', '<s:text name="acctfid"/>', 'c', true, 32);
			addfield('form.deacctno', '<s:text name="deacctno"/>', 'c', true, 50);
			addfield('form.deacctname', '<s:text name="deacctname"/>', 'c', true, 128);
			addfield('form.debankname', '<s:text name="debankname"/>', 'c', true, 128);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="wayaccount_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_accid"/>
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
                <td align="right"><s:text name="accid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.accid" maxlength="6"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.accid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
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
                <td align="right"><s:text name="chargetype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.chargetype" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="accttype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.accttype" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="acctno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.acctno" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="acctname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.acctname" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bankname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bankname" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="dsbank"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.dsbank" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bankaddr"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bankaddr" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="contact"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.contact" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="contel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.contel" maxlength="30"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rectime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.rectime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.starttime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="endtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.endtime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.memo" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bossarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bossarea" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="acctfid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.acctfid" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="deacctno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.deacctno" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="deacctname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.deacctname" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="debankname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.debankname" maxlength="128"/>
                </td>
            </tr>
        </table>
    </div>
	</aa:zone>

    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/wayaccount_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/wayaccount_list.do')">
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
