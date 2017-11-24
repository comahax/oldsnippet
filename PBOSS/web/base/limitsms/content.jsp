<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_EDIT = "CH_CTI_CONFIGURE_IMPORT";
%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
	function ev_checkval() {
		addfield('form.seq', '<s:text name="seq"/>', 'f', true, 14);
		addfield('form.sms', '<s:text name="sms"/>', 'c', false, 250);
		return checkval(window);
	}
</script>
</head>
<body>
<div class="table_container">
<s:form action="limitsms_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	
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
			    <s:if test="CMD == WEB_CMD_NEW">
			        
			    </s:if>
			    <s:elseif test="CMD == WEB_CMD_EDIT">
			        <td align="right"><s:text name="seq"/>:&nbsp</td>
                	<td align="left">
			        	<s:textfield cssStyle="style_input" name="form.seq" disabled="true"/>
						<font color=red>*</font>
					</td>
				</s:elseif>
			    <s:else>
			        <td align="right"><s:text name="seq"/>:&nbsp</td>
                	<td align="left">
						<s:textfield cssStyle="style_input" name="form.seq" disabled="true"/>
						<font color=red>*</font>
					</td>
			    </s:else>
            </tr>
            <tr>
                <td align="right"><s:text name="sms"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textarea cssStyle="style_input" name="form.sms" maxlength="250" cols="64" rows="5"/>
						<font color=red>*</font>
					</s:if>
					<s:else>						
						<s:textarea cssStyle="style_input" name="form.sms" disabled="true" cols="64" rows="5"/>
						<font color=red>*</font>
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
                   	<j:purChk permid="<%=ID_EDIT%>">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/base/limitsms_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/limitsms_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>