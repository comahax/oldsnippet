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
            addfield('form.logid', '<s:text name="logid"/>', 'f', false, 14);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 32);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
			addfield('form.logintime', '<s:text name="logintime"/>', 't', true, 7);
			addfield('form.clientname', '<s:text name="clientname"/>', 'c', true, 32);
			addfield('form.macaddress', '<s:text name="macaddress"/>', 'c', true, 32);
			addfield('form.ipaddress', '<s:text name="ipaddress"/>', 'c', true, 32);
			addfield('form.logintype', '<s:text name="logintype"/>', 'c', true, 32);
			addfield('form.issuccess', '<s:text name="issuccess"/>', 'f', true, 3);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 512);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="loginlog_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_logid"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_cityid"/>
	
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
                <td align="right"><s:text name="logid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.logid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.logid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.logid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.oprcode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
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
                <td align="right"><s:text name="logintime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.logintime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.logintime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="clientname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.clientname" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.clientname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="macaddress"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.macaddress" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.macaddress" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ipaddress"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.ipaddress" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.ipaddress" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="logintype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.logintype" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.logintype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="issuccess"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.issuccess" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.issuccess" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.memo" maxlength="512"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.memo" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/loginlog_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/loginlog_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
