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
            addfield('form.systemid', '<s:text name="systemid"/>', 'f', false, 14);
            addfield('form.paramtype', '<s:text name="paramtype"/>', 'c', false, 16);
			addfield('form.begintime', '<s:text name="begintime"/>', 't', false, 7);
			addfield('form.endtime', '<s:text name="endtime"/>', 't', false, 7);
			addfield('form.paramname', '<s:text name="paramname"/>', 'c', false, 32);
			addfield('form.paramvalue', '<s:text name="paramvalue"/>', 'c', false, 256);
			addfield('form.memo', '<s:text name="memo"/>', 'c', false, 256);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="sysparam_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_systemid"/>
    <s:hidden name="param._se_paramtype"/>
    <s:hidden name="param._sk_paramname"/>
	
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
                <td align="right"><s:text name="systemid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.systemid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.systemid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paramtype"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <j:selector name="form.paramtype" definition="$CH_PARAMTYPE"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<j:selector name="form.paramtype" definition="$CH_PARAMTYPE" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="begintime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
                	<s:i18n name="public">
					<input class="style_input" name="form.begintime" value="<s:property value="form.begintime!=null?
								getText('format.date',{form.begintime}):''"/>"" maxlength="10" onclick="selectDate()"/>
					</s:i18n>
					<font color=red>*</font>
					</s:if>
					<s:else>
					<s:i18n name="public">
					<s:textfield cssStyle="style_input" name="form.begintime" value="%{getText('format.date',{form.begintime})}" disabled="true" onclick="selectDate()"/>
					</s:i18n>
					<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="endtime"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
                	<s:i18n name="public">
					<input class="style_input" name="form.endtime" value="<s:property value="form.endtime!=null?
								getText('format.date',{form.endtime}):''"/>"" maxlength="10" onclick="selectDate()"/>
					</s:i18n>
					</s:if>
					<s:else>
					<s:i18n name="public">
					<s:textfield cssStyle="style_input" name="form.endtime" value="%{getText('format.date',{form.endtime})}" disabled="true" onclick="selectDate();"/>
					</s:i18n>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paramname"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.paramname" maxlength="32"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.paramname" maxlength="32" disabled="true"/>
				</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paramvalue"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.paramvalue" maxlength="256"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.paramvalue" maxlength="256" disabled="true"/>
				</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textarea name="form.memo" maxlength="256" cols="50" rows="8"></s:textarea>
				</s:if>
				<s:else>
					<s:textarea name="form.memo" maxlength="256" disabled="true" cols="50" rows="8"></s:textarea>
				</s:else>
					<font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/sysparam_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled="true"</s:if>/>
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/sysparam_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
