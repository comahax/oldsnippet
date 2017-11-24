<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.centerid', '<s:text name="centerid"/>', 'c', false, 14);
			addfield('form.centername', '<s:text name="centername"/>', 'c', true, 64);
			addfield('form.areatype', '<s:text name="areatype"/>', 'f', true, 3);
			addfield('form.agent', '<s:text name="agent"/>', 'c', true, 64);
			addfield('form.billingcode', '<s:text name="billingcode"/>', 'c', true, 5);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="areacenter_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_centername"/>
    <s:hidden name="param._ne_areatype"/>
    <s:hidden name="param._se_agent"/>
	
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
                <td align="right"><s:text name="centerid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.centerid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.centerid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="centername"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.centername" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="areatype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.areatype" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="agent"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.agent" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="billingcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.billingcode" maxlength="5"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/areacenter_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/areacenter_list.do')">
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
