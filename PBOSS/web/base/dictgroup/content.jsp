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
            addfield('form.groupid', '<s:text name="groupid"/>', 'c', false, 32);
			addfield('form.groupname', '<s:text name="groupname"/>', 'c', true, 64);
			addfield('form.grouptype', '<s:text name="grouptype"/>', 'c', true, 32);
			addfield('form.managable', '<s:text name="managable"/>', 'f', true, 1);
			addfield('form.status', '<s:text name="status"/>', 'f', true, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', true, 7);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="dictgroup_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_groupid"/>
    <s:hidden name="param._se_groupname"/>
    <s:hidden name="param._se_grouptype"/>
	
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
                <td align="right"><s:text name="groupid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.groupid" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.groupid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="groupname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.groupname" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="grouptype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.grouptype" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="managable"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.managable" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="statusdate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.statusdate" maxlength="7"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/dictgroup_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/dictgroup_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
