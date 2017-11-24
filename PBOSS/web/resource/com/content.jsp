<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.comid', '<s:text name="comid"/>', 'f', false, 18);
			addfield('form.comprice', '<s:text name="comprice"/>', 'f', true, 14);
			addfield('form.comclassid', '<s:text name="comclassid"/>', 'f', true, 6);
			addfield('form.comtype', '<s:text name="comtype"/>', 'f', true, 6);
			addfield('form.comfreeze', '<s:text name="comfreeze"/>', 't', true, 7);
			addfield('form.comkeep', '<s:text name="comkeep"/>', 'f', true, 6);
			addfield('form.comvalid', '<s:text name="comvalid"/>', 't', true, 7);
			addfield('form.comname', '<s:text name="comname"/>', 'c', true, 128);
			addfield('form.comsource', '<s:text name="comsource"/>', 'c', true, 30);
			addfield('form.colordes', '<s:text name="colordes"/>', 'c', true, 40);
			addfield('form.accessory', '<s:text name="accessory"/>', 'c', true, 40);
			addfield('form.presentdes', '<s:text name="presentdes"/>', 'c', true, 40);
			addfield('form.active', '<s:text name="active"/>', 'f', true, 3);
			addfield('form.comlength', '<s:text name="comlength"/>', 'f', true, 3);
			addfield('form.item', '<s:text name="item"/>', 'c', true, 20);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
			addfield('form.comcode', '<s:text name="comcode"/>', 'c', true, 40);
			addfield('form.comstate', '<s:text name="comstate"/>', 'f', true, 6);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="com_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_comid"/>
    <s:hidden name="param._ne_comclassid"/>
    <s:hidden name="param._ne_comtype"/>
    <s:hidden name="param._se_comname"/>
	
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
                <td align="right"><s:text name="comid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.comid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.comid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comprice"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comprice" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comclassid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comclassid" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comtype" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comfreeze"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comfreeze" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comkeep"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comkeep" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comvalid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comvalid" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comname" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comsource"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comsource" maxlength="30"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="colordes"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.colordes" maxlength="40"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="accessory"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.accessory" maxlength="40"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="presentdes"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.presentdes" maxlength="40"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="active"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.active" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comlength"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comlength" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="item"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.item" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cityid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comcode" maxlength="40"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comstate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comstate" maxlength="6"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/com_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/com_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
