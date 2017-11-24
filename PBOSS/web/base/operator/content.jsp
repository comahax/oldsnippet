<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.operid', '<s:text name="operid"/>', 'c', false, 16);
			addfield('form.region', '<s:text name="region"/>', 'f', true, 5);
			addfield('form.opername', '<s:text name="opername"/>', 'c', true, 64);
			addfield('form.password', '<s:text name="password"/>', 'c', true, 30);
			addfield('form.passchgdate', '<s:text name="passchgdate"/>', 't', true, 7);
			addfield('form.opergroup', '<s:text name="opergroup"/>', 'c', true, 16);
			addfield('form.opertype', '<s:text name="opertype"/>', 'c', true, 16);
			addfield('form.operlevel', '<s:text name="operlevel"/>', 'c', true, 16);
			addfield('form.ismanager', '<s:text name="ismanager"/>', 'f', true, 1);
			addfield('form.contactphone', '<s:text name="contactphone"/>', 'c', true, 20);
			addfield('form.orgid', '<s:text name="orgid"/>', 'c', true, 32);
			addfield('form.isrestrict', '<s:text name="isrestrict"/>', 'f', true, 1);
			addfield('form.starttime', '<s:text name="starttime"/>', 't', true, 2);
			addfield('form.endtime', '<s:text name="endtime"/>', 't', true, 2);
			addfield('form.enablegprs', '<s:text name="enablegprs"/>', 'f', true, 1);
			addfield('form.gprsstarttime', '<s:text name="gprsstarttime"/>', 'f', true, 2);
			addfield('form.gprsendtime', '<s:text name="gprsendtime"/>', 'f', true, 2);
			addfield('form.ischkmac', '<s:text name="ischkmac"/>', 'f', true, 1);
			addfield('form.mac', '<s:text name="mac"/>', 'c', true, 32);
			addfield('form.notes', '<s:text name="notes"/>', 'c', true, 256);
			addfield('form.createdate', '<s:text name="createdate"/>', 't', true, 7);
			addfield('form.status', '<s:text name="status"/>', 'f', true, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', true, 7);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="operator_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_operid"/>
    <s:hidden name="param._se_password"/>
    <s:hidden name="param._se_orgid"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/></span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="base"/></span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="operid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.operid" maxlength="16"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.operid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="region"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.region" maxlength="5"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.region" maxlength="5" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="opername"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.opername" maxlength="64"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.opername" maxlength="64" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="password"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.password" maxlength="30"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.password" maxlength="30" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="passchgdate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.passchgdate" maxlength="7"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.passchgdate" maxlength="7" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="opergroup"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.opergroup" maxlength="16"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.opergroup" maxlength="16" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="opertype"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.opertype" maxlength="16"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.opertype" maxlength="16" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="operlevel"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.operlevel" maxlength="16"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.operlevel" maxlength="16" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ismanager"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.ismanager" maxlength="1"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.ismanager" maxlength="1" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="contactphone"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.contactphone" maxlength="20"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.contactphone" maxlength="20" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="orgid"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.orgid" maxlength="32"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.orgid" maxlength="32" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isrestrict"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.isrestrict" maxlength="1"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.isrestrict" maxlength="1" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.starttime" maxlength="2"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.starttime" maxlength="2" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="endtime"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.endtime" maxlength="2"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.endtime" maxlength="2" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="enablegprs"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.enablegprs" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="gprsstarttime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.gprsstarttime" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="gprsendtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.gprsendtime" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ischkmac"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.ischkmac" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mac"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.mac" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="notes"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.notes" maxlength="256"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="createdate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.createdate" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="statusdate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.statusdate" maxlength="7"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/operator_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/operator_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnSave");
</script>
</body>
</html>
