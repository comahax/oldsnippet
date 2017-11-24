<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.cooperauid', '<s:text name="cooperauid"/>', 'c', false, 50);
			addfield('form.cooperaname', '<s:text name="cooperaname"/>', 'c', true, 256);
			addfield('form.cpabbrname', '<s:text name="cpabbrname"/>', 'c', true, 256);
			addfield('form.cocheckname', '<s:text name="cocheckname"/>', 'c', true, 128);
			addfield('form.servman', '<s:text name="servman"/>', 'c', true, 20);
			addfield('form.cooperadel', '<s:text name="cooperadel"/>', 'c', true, 32);
			addfield('form.postaddr', '<s:text name="postaddr"/>', 'c', true, 128);
			addfield('form.zipcode', '<s:text name="zipcode"/>', 'c', true, 6);
			addfield('form.conntel', '<s:text name="conntel"/>', 'c', true, 15);
			addfield('form.connfaxno', '<s:text name="connfaxno"/>', 'c', true, 128);
			addfield('form.usremail', '<s:text name="usremail"/>', 'c', true, 64);
			addfield('form.area', '<s:text name="area"/>', 'f', true, 16);
			addfield('form.licenceid', '<s:text name="licenceid"/>', 'c', true, 30);
			addfield('form.licvalidate', '<s:text name="licvalidate"/>', 't', true, 7);
			addfield('form.connpers', '<s:text name="connpers"/>', 'c', true, 32);
			addfield('form.busconntel', '<s:text name="busconntel"/>', 'c', true, 15);
			addfield('form.sendaddr', '<s:text name="sendaddr"/>', 'c', true, 128);
			addfield('form.recpers', '<s:text name="recpers"/>', 'c', true, 32);
			addfield('form.recconntel', '<s:text name="recconntel"/>', 'c', true, 15);
			addfield('form.reccertno', '<s:text name="reccertno"/>', 'c', true, 20);
			addfield('form.smsmobileno', '<s:text name="smsmobileno"/>', 'c', true, 12);
			addfield('form.bankname', '<s:text name="bankname"/>', 'c', true, 128);
			addfield('form.acctno', '<s:text name="acctno"/>', 'c', true, 30);
			addfield('form.districtid', '<s:text name="districtid"/>', 'c', true, 32);
			addfield('form.intime', '<s:text name="intime"/>', 't', true, 7);
			addfield('form.custmanager', '<s:text name="custmanager"/>', 'c', true, 15);
			addfield('form.starttime', '<s:text name="starttime"/>', 't', true, 7);
			addfield('form.servpwd', '<s:text name="servpwd"/>', 'c', true, 20);
			addfield('form.state', '<s:text name="state"/>', 'f', true, 3);
			addfield('form.oldcoopera', '<s:text name="oldcoopera"/>', 'c', true, 20);
			addfield('form.baillwrlmt', '<s:text name="baillwrlmt"/>', 'f', true, 16);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 255);
			addfield('form.waysubtype', '<s:text name="waysubtype"/>', 'c', true, 4);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 14);
			addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
			addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
			addfield('form.cashdeposit', '<s:text name="cashdeposit"/>', 'f', true, 16);
			addfield('form.cdradix', '<s:text name="cdradix"/>', 'f', true, 16);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="cooperator_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cooperauid"/>
    <s:hidden name="param._se_cooperaname"/>
	
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
                <td align="right"><s:text name="cooperauid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.cooperauid" maxlength="50"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.cooperauid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.cooperauid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cooperaname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cooperaname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cooperaname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cpabbrname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cpabbrname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cpabbrname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cocheckname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cocheckname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cocheckname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="servman"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.servman" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.servman" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cooperadel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cooperadel" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cooperadel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="postaddr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.postaddr" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.postaddr" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zipcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.zipcode" maxlength="6"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.zipcode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="conntel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.conntel" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.conntel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="connfaxno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.connfaxno" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.connfaxno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="usremail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.usremail" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.usremail" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="area"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.area" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.area" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="licenceid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.licenceid" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.licenceid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="licvalidate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.licvalidate" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.licvalidate" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="connpers"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.connpers" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.connpers" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busconntel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.busconntel" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.busconntel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sendaddr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.sendaddr" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.sendaddr" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="recpers"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recpers" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recpers" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="recconntel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.recconntel" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.recconntel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="reccertno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.reccertno" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.reccertno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsmobileno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.smsmobileno" maxlength="12"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.smsmobileno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bankname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.bankname" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.bankname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="acctno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.acctno" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.acctno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="districtid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.districtid" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.districtid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="intime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.intime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.intime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="custmanager"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.custmanager" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.custmanager" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.starttime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.starttime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="servpwd"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.servpwd" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.servpwd" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="state"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.state" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.state" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oldcoopera"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.oldcoopera" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.oldcoopera" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="baillwrlmt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.baillwrlmt" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.baillwrlmt" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.memo" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.memo" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waysubtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.waysubtype" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.waysubtype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cityid" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cityid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.countyid" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.svccode" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.svccode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.mareacode" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.mareacode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cashdeposit"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cashdeposit" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cashdeposit" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cdradix"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cdradix" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cdradix" disabled="true"/>
					</s:else>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/cooperator_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/cooperator_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
