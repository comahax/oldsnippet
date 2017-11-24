<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.itemid', '<s:text name="itemid"/>', 'f', false, 14);
			addfield('form.opract', '<s:text name="opract"/>', 'f', true, 3);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 16);
			addfield('form.oprtype', '<s:text name="oprtype"/>', 'c', true, 8);
			addfield('form.oprtime', '<s:text name="oprtime"/>', 't', true, 7);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('form.wayname', '<s:text name="wayname"/>', 'c', true, 256);
			addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', true, 18);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
			addfield('form.waytype', '<s:text name="waytype"/>', 'c', true, 4);
			addfield('form.waystate', '<s:text name="waystate"/>', 'f', true, 3);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="waysyn_save.do" cssStyle="formList" key="formItem"
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
                <td align="right"><s:text name="opract"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.opract" maxlength="3"/>
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
                <td align="right"><s:text name="oprtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprtime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="upperwayid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.upperwayid" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cityid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waytype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waytype" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waystate" maxlength="3"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/waysyn_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/waysyn_list.do')">
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
