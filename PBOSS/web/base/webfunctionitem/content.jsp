<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<% String ID_ADD = "CH_PW_SYSTEMROLE"; %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.funcid', '<s:text name="funcid"/>', 'c', false, 32);
			addfield('form.funcname', '<s:text name="funcname"/>', 'c', false, 64);
			addfield('form.parentid', '<s:text name="parentid"/>', 'c', false, 32);
			addfield('form.guiobject', '<s:text name="guiobject"/>', 'c', true, 256);
			addfield('form.sortorder', '<s:text name="sortorder"/>', 'f', true, 4);
			addfield('form.status', '<s:text name="status"/>', 'f', false, 1);
            return checkval(window);
        }
        
       function doSave(cmdSave) {
    var ret = ev_checkval();   
    if ( ret ) {
        enable();
        formItem.action = contextPath + cmdSave;
        formItem.submit();
        parent.leftFrame.location.reload();
    }
    return false;
}
    </script>
</head>
<body>
<div class="table_container" >
<s:form action="webfunctionitem_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="param._se_parentid"/>
	<s:hidden name="form.type"/>
	<input type="hidden" name="form.statusdate" value="<s:date name="form.statusdate" format="yyyy-MM-dd" />"/>
	
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

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
	<aa:zone name="contentZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="funcid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			        	<s:if test="form.parentid == 0">
	                        <j:selector definition="$MODULE" name="form.funcid" readonly="true" cssStyle="style_input" />
	                        <font color=red>*</font>
                        </s:if>
                        <s:else>
                        	<s:textfield cssStyle="style_input" name="form.funcid" maxlength="32" disabled="true"/>
	                        <font color=red>*</font>
                        </s:else>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.funcid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="parentid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.parentid" maxlength="32" disabled="true"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="funcname"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.funcname" maxlength="32"/>
					<font color=red>*</font>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.funcname" maxlength="32" disabled="true"/>
					<font color=red>*</font>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="guiobject"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.guiobject" maxlength="256"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.guiobject" maxlength="256" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
                	<j:selector name="form.status" definition="$YesOrNo" />
                	<font color=red>*</font>
				</s:if>
				<s:else>
					<j:selector name="form.status" definition="$YesOrNo" disabled="true"/>
					<font color=red>*</font>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sortorder"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.sortorder" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.sortorder" maxlength="4" disabled="true"/>
					</s:else>
                </td>
            </tr>
        </table>
    </div>
	</aa:zone>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="right">
                   	<s:i18n name="public">
                    <j:purChk permid="<%=ID_ADD%>">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/base/webfunctionitem_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/webfunctionitem_doListByParent.do?param._se_parentid=<s:property value="param._se_parentid"/>')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>