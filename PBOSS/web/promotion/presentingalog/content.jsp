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
            addfield('form.logid', '<s:text name="logid"/>', 'f', false, 14);
			addfield('form.optime', '<s:text name="optime"/>', 't', true, 7);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 16);
			addfield('form.oprtype', '<s:text name="oprtype"/>', 'c', true, 8);
			addfield('form.success', '<s:text name="success"/>', 'c', true, 8);
			addfield('form.ruleid', '<s:text name="ruleid"/>', 'f', true, 6);
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', true, 32);
			addfield('form.quantity', '<s:text name="quantity"/>', 'f', true, 3);
			addfield('form.pcomcategory', '<s:text name="pcomcategory"/>', 'c', true, 32);
			addfield('form.pquantity', '<s:text name="pquantity"/>', 'f', true, 3);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="presentingalog_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
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
                <td align="right"><s:text name="logid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.logid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.logid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="optime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.optime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprtype" maxlength="8"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="success"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.success" maxlength="8"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ruleid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.ruleid" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comcategory" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="quantity"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.quantity" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pcomcategory"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.pcomcategory" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pquantity"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.pquantity" maxlength="3"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/promotion/presentingalog_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/promotion/presentingalog_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
