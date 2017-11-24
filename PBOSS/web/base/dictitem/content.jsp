<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<% String ID_ADD = "CH_PW_SYSTEMROLE"; %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.dictid', '<s:text name="dictid"/>', 'c', false, 32);
			addfield('form.dictname', '<s:text name="dictname"/>', 'c', true, 64);
            addfield('form.groupid', '<s:text name="groupid"/>', 'c', false, 32);
			addfield('form.sortorder', '<s:text name="sortorder"/>', 'f', true, 3);
			addfield('form.status', '<s:text name="status"/>', 'f', true, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', true, 25);
			addfield('form.description', '<s:text name="description"/>', 'c', true, 128);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="dictitem_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_dictid"/>
    <s:hidden name="param._se_dictname"/>
    <s:hidden name="param._se_groupid"/>
	
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
                <td align="right"><s:text name="dictid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.dictid" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.dictid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="dictname"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.dictname" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.dictname" maxlength="64" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="groupid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.groupid" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.groupid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sortorder"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.sortorder" maxlength="3"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.sortorder" maxlength="3" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="statusdate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
                	<s:i18n name="public">
					<input class="style_input" name="form.statusdate" value="<s:property value="form.statusdate!=null?
								getText('format.date',{form.statusdate}):''"/>"" maxlength="10" onclick="selectDate()"/>
					</s:i18n>
				</s:if>
				<s:else>
					<s:i18n name="public">
					<s:textfield cssStyle="style_input" name="form.statusdate" value="%{getText('format.date',{form.statusdate})}" disabled="true"/>
					</s:i18n>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="description"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.description" maxlength="128"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.description" maxlength="128" disabled="true"/>
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
                   	<j:purChk permid="<%=ID_ADD%>">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/base/dictitem_save.do')" 
                           <s:if test="CMD == WEB_CMD_SAVE">disabled="true"</s:if>/>
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/dictitem_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
