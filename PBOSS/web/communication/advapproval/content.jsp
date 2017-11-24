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
            addfield('form.approvalid', '<s:text name="approvalid"/>', 'f', false, 14);
			addfield('form.advinfoid', '<s:text name="advinfoid"/>', 'f', true, 14);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 18);
			addfield('form.content', '<s:text name="content"/>', 'c', true, 128);
			addfield('form.state', '<s:text name="state"/>', 'f', true, 3);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="advapproval_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_approvalid"/>
    <s:hidden name="param._ne_advinfoid"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._ne_state"/>
	
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
                <td align="right"><s:text name="approvalid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.approvalid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.approvalid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="advinfoid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.advinfoid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="content"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.content" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="state"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.state" maxlength="3"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/communication/advapproval_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/communication/advapproval_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
