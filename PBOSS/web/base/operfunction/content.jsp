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
            addfield('form.operid', '<s:text name="operid"/>', 'c', false, 16);
            addfield('form.functionid', '<s:text name="functionid"/>', 'c', false, 32);
			//addfield('form.createdate', '<s:text name="createdate"/>', 't', true, 7);
			addfield('form.status', '<s:text name="status"/>', 'f', false, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', false, 7);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="operfunction_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.createdate"/>
	
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
                <td align="right"><s:text name="operid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			        	<j:selector definition="#OPERATOR" name="form.operid" condition='region:${dBAccessUser.hwcityid };status:1' mode="picker" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<j:selector definition="#OPERATOR" name="form.operid" condition='region:${dBAccessUser.hwcityid };status:1' mode="picker" disabled="true"/>
						<font color=red>*</font>
			        </s:elseif>
			        <s:else>
			        	<j:selector definition="#OPERATOR" name="form.operid" condition='region:${dBAccessUser.hwcityid };status:1' mode="picker" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="functionid"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD == WEB_CMD_NEW">
			        	<j:selector definition="#FUNCTIONITEM" name="form.functionid" condition="_snn_guiobject:notnull" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<j:selector definition="#FUNCTIONITEM" name="form.functionid" condition="_snn_guiobject:notnull" disabled="true"/>
						<font color=red>*</font>
			        </s:elseif>
			        <s:else>
			        	<j:selector definition="#FUNCTIONITEM" name="form.functionid" condition="_snn_guiobject:notnull" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<j:selector name="form.status" definition="$CH_OPRSTATUS" />
					<font color=red>*</font>
				</s:if>
				<s:else>
					<j:selector name="form.status" definition="$CH_OPRSTATUS" disabled="true"/>
					<font color=red>*</font>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="statusdate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
                	<sj:datepicker name="form.statusdate" />
				</s:if>
				<s:else>
					<sj:datepicker name="form.statusdate" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/operfunction_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled="true"</s:if>/>
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/operfunction_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
