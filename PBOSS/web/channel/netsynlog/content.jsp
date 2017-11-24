<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.itemid', '<s:text name="itemid"/>', 'f', false, 14);
			addfield('form.mobile', '<s:text name="mobile"/>', 'c', true, 12);
			addfield('form.opract', '<s:text name="opract"/>', 'f', true, 3);
			addfield('form.synstate', '<s:text name="synstate"/>', 'f', true, 3);
			addfield('form.synmemo', '<s:text name="synmemo"/>', 'c', true, 255);
			addfield('form.isopen', '<s:text name="isopen"/>', 'f', true, 2);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 16);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="netsynlog_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_itemid"/>
	
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
                <td align="right"><s:text name="itemid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.itemid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.itemid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mobile"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.mobile" maxlength="12"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="opract"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.opract" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="synstate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.synstate" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="synmemo"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.synmemo" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isopen"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isopen" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="16"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/netsynlog_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/netsynlog_list.do')">
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
