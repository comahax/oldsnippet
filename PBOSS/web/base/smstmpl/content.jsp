<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
</head>
<body>
<div class="table_container">
<s:form action="smstmpl_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    
    <s:hidden name="form.sid"/>
    <s:hidden name="form.sname"/>
    <s:hidden name="form.stype"/>
    <s:hidden name="form.smemo"/>
	
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
                <td align="right" width="20%"><s:text name="sid"/>:&nbsp</td>
                <td align="left">
			        <s:property value="form.sid"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sname"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.sname"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="stype"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$CH_STYPE" code="form.stype"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sstate"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_VALIDFLAG" name="form.sstate"/>
					</s:if>
					<s:else>
						<j:selector definition="$CH_VALIDFLAG" name="form.sstate" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="scontent"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textarea name="form.scontent" cssStyle="style_input" rows="8" cols="80" maxlength="1024"></s:textarea>
					</s:if>
					<s:else>
						<s:textarea name="form.scontent" cssStyle="style_input" rows="8" cols="80" disabled="true"></s:textarea>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smemo"/>:&nbsp</td>
                <td align="left">
					<s:property value="form.smemo"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/smstmpl_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/smstmpl_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script language="JavaScript">
	function ev_checkval() {
		addfield('form.sid', '<s:text name="sid"/>', 'c', false, 32);
		addfield('form.sname', '<s:text name="sname"/>', 'c', true, 50);
		addfield('form.stype', '<s:text name="stype"/>', 'c', true, 32);
		addfield('form.sstate', '<s:text name="sstate"/>', 'c', true, 32);
		addfield('form.scontent', '<s:text name="scontent"/>', 'c', true, 1024);
		addfield('form.smemo', '<s:text name="smemo"/>', 'c', true, 1024);
		return checkval(window);
	}
</script>