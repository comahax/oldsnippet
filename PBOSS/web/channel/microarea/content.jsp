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
            addfield('form.macode', '<s:text name="macode"/>', 'c', false, 14);
            addfield('form.svccode', '<s:text name="svccode"/>', 'c', false, 14);
            addfield('form.maname', '<s:text name="maname"/>', 'c', false, 64);
			addfield('form.matype', '<s:text name="matype"/>', 'f', true, 3);
			addfield('form.agent', '<s:text name="agent"/>', 'c', true, 64);
			addfield('form.billingcode', '<s:text name="billingcode"/>', 'c', true, 5);
			addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
			addfield('form.longitude', '<s:text name="longitude"/>', 'c', true, 15);
			addfield('form.latitude', '<s:text name="latitude"/>', 'c', true, 15);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="microarea_save.do" cssStyle="formList" key="formItem"
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
                <td align="right"><s:text name="macode"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.macode" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.macode" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.svccode" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.svccode" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="maname"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.maname" maxlength="64"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.maname" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="matype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.matype" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="agent"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.agent" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="billingcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.billingcode" maxlength="5"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adacode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adacode" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="longitude"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.longitude" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="latitude"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.latitude" maxlength="15"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/microarea_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/microarea_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
