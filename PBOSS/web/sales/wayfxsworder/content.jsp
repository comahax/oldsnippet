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
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 14);
		addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
		addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
		addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', true, 2);
		addfield('form.paytype', '<s:text name="paytype"/>', 'c', true, 16);
		return checkval(window);
	}
</script>
</head>
<body>
<div class="table_container">
<s:form action="wayfxsworder_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_svccode"/>
    <s:hidden name="param._se_mareacode"/>
    <s:hidden name="param._ne_starlevel"/>
    <s:hidden name="param._se_orderstate"/>
    <s:hidden name="param._dnm_recordtime"/>
    <s:hidden name="param._dnl_recordtime"/>
	
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
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.countyid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <%-- 
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
            --%>
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
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.starlevel" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.starlevel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paytype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.paytype" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.paytype" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/wayfxsworder_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/wayfxsworder_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>