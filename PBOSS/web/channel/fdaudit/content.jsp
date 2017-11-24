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
            addfield('form.recno', '<s:text name="recno"/>', 'f', false, 18);
			addfield('form.tablename', '<s:text name="tablename"/>', 'c', true, 32);
			addfield('form.typename', '<s:text name="typename"/>', 'c', true, 32);
			addfield('form.pkvalue', '<s:text name="pkvalue"/>', 'c', true, 64);
			addfield('form.pkvalue2', '<s:text name="pkvalue2"/>', 'c', true, 64);
			addfield('form.field', '<s:text name="field"/>', 'c', true, 32);
			addfield('form.fieldvalue', '<s:text name="fieldvalue"/>', 'c', true, 255);
			addfield('form.operid', '<s:text name="operid"/>', 'c', true, 18);
			addfield('form.optime', '<s:text name="optime"/>', 't', true, 7);
			addfield('form.auditstatus', '<s:text name="auditstatus"/>', 'f', true, 2);
			addfield('form.auditoperid', '<s:text name="auditoperid"/>', 'c', true, 18);
			addfield('form.audittime', '<s:text name="audittime"/>', 't', true, 7);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="fdaudit_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_tablename"/>
    <s:hidden name="param._se_typename"/>
    <s:hidden name="param._se_pkvalue"/>
    <s:hidden name="param._ne_auditstatus"/>
	
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
                <td align="right"><s:text name="recno"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.recno" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recno" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recno" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="tablename"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.tablename" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.tablename" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="typename"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.typename" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.typename" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pkvalue"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.pkvalue" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.pkvalue" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pkvalue2"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.pkvalue2" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.pkvalue2" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="field"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.field" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.field" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="fieldvalue"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.fieldvalue" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.fieldvalue" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="operid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.operid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.operid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="optime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.optime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.optime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="auditstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.auditstatus" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.auditstatus" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="auditoperid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.auditoperid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.auditoperid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="audittime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.audittime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.audittime" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/fdaudit_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/fdaudit_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
