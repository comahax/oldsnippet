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
			addfield('form.objectcode', '<s:text name="objectcode"/>', 'c', false, 18);
			addfield('form.maxtimes', '<s:text name="maxtimes"/>', 'i', false, 4);
			addfield('form.isurgent', '<s:text name="isurgent"/>', 'i', false, 3);
			return checkval(window);
		}
</script>
</head>
<body>
<div class="table_container">
<s:form action="ordertimes_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_recid"/>
    <s:hidden name="param._se_objtype"/>
    <s:hidden name="param._se_objectcode"/>
    <s:hidden name="param._nnm_maxtimes"/>
    <s:hidden name="param._ne_maxtimes"/>
    <s:hidden name="param._nnl_maxtimes"/>
    <s:hidden name="param._nnl_maxtimes"/>
    <s:hidden name="param._ne_isurgent"/>
    <s:hidden name="otlimitType" value="APPSTAR"/>
    <s:hidden name="form.objtype" value="APPSTAR"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
			        <s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
                    <font color=red>*</font>
                    <s:text name="label"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="objectcode1"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.objectcode" definition="$CH_STARLEVEL"/>
					</s:if>
					<s:else>
						<j:selector name="form.objectcode" definition="$CH_STARLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="maxtimes"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.maxtimes" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.maxtimes" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isurgent"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.isurgent" definition="$IM_YESNO10"/>
					</s:if>
					<s:else>
						<j:selector name="form.isurgent" definition="$IM_YESNO10" disabled="true"/>
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
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/ordertimes_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/ordertimes_list.do?otlimitType=APPSTAR')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
