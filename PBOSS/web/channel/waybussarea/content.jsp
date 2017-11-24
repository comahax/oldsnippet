<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.totalarea', '<s:text name="totalarea"/>', 'f', true, 16);
			addfield('form.consultarea', '<s:text name="consultarea"/>', 'f', true, 16);
			addfield('form.busarea', '<s:text name="busarea"/>', 'f', true, 16);
			addfield('form.newbusarea', '<s:text name="newbusarea"/>', 'f', true, 16);
			addfield('form.termarea', '<s:text name="termarea"/>', 'f', true, 16);
			addfield('form.selfservarea', '<s:text name="selfservarea"/>', 'f', true, 16);
			addfield('form.custarea', '<s:text name="custarea"/>', 'f', true, 16);
			addfield('form.viparea', '<s:text name="viparea"/>', 'f', true, 16);
			addfield('form.bgdarea', '<s:text name="bgdarea"/>', 'f', true, 16);
			addfield('form.bossarea', '<s:text name="bossarea"/>', 'c', true, 14);
			addfield('form.publisharea', '<s:text name="publisharea"/>', 'f', true, 10);
			addfield('form.shopwinarea', '<s:text name="shopwinarea"/>', 'f', true, 10);
			addfield('form.doorheight', '<s:text name="doorheight"/>', 'f', true, 12);
			addfield('form.doorlength', '<s:text name="doorlength"/>', 'f', true, 12);
			addfield('form.backheight', '<s:text name="backheight"/>', 'f', true, 12);
			addfield('form.backlength', '<s:text name="backlength"/>', 'f', true, 12);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="waybussarea_save.do" cssStyle="formList" key="formItem"
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
                <td align="right"><s:text name="totalarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.totalarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="consultarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.consultarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.busarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="newbusarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.newbusarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="termarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.termarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="selfservarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.selfservarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="custarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.custarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="viparea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.viparea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bgdarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bgdarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bossarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bossarea" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="publisharea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.publisharea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="shopwinarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.shopwinarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="doorheight"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.doorheight" maxlength="12"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="doorlength"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.doorlength" maxlength="12"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="backheight"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.backheight" maxlength="12"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="backlength"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.backlength" maxlength="12"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/waybussarea_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/waybussarea_list.do')">
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
