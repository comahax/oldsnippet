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
        	if(document.all("form.mobileno").value!="" && document.all("form.mobileno").value.length!=11)
        	{
        	  alert("手机号码必须为11位!");
        	  return false;
        	}
            addfield('form.recid', '<s:text name="recid"/>', 'f', true, 14);
			addfield('form.mobileno', '<s:text name="mobileno"/>', 'i', false, 11);
			addfield('form.activedate', '<s:text name="activedate"/>', 't', false, 7);
			addfield('form.cause', '<s:text name="cause"/>', 'c', false, 256);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="actrepair_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_mobileno"/>
    <s:hidden name="param._dnm_activedate"/>
    <s:hidden name="param._dnl_activedate"/>
    <s:hidden name="param._dnm_repairtime"/>
    <s:hidden name="param._dnl_repairtime"/>
    <s:hidden name="param._se_oprcode"/>
	<s:hidden name="param.repairtime" />
	<s:hidden name="param.oprcode" />
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
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.recid" readonly="true" maxlength="14"/>
                        <font color=red>&nbsp;*</font>
                        <s:text name="auto"/> 
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
						<font color=red>&nbsp;*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mobileno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.mobileno" maxlength="11"/>
						<font color=red>&nbsp;*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.mobileno" disabled="true"/>
						<font color=red>&nbsp;*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="activedate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					<input class="style_input" name="form.activedate" value="<s:property value="form.activedate!=null?getText('format.date',{form.activedate}):''"/>" onclick="selectDate();"/>
						<font color=red>&nbsp;*</font>
					</s:if>
					<s:else>
					<input class="style_input" name="form.activedate" value="<s:property value="form.activedate!=null?getText('format.date',{form.activedate}):''"/>" disabled="true" />
						<font color=red>&nbsp;*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cause"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cause" maxlength="256"/>
						<font color=red>&nbsp;*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cause" disabled="true"/>
						<font color=red>&nbsp;*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/actrepair_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/actrepair_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
