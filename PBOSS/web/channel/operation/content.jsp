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
            addfield('form.opnid', '<s:text name="opnid"/>', 'c', false, 18);
			addfield('form.name', '<s:text name="name"/>', 'c', true, 50);
			addfield('form.parentid', '<s:text name="parentid"/>', 'c', true, 18);
			addfield('form.remark', '<s:text name="remark"/>', 'c', true, 255);
			addfield('form.state', '<s:text name="state"/>', 'f', true, 2);
			addfield('form.startdate', '<s:text name="startdate"/>', 't', true, 7);
			addfield('form.enddate', '<s:text name="enddate"/>', 't', true, 7);
			addfield('form.isbusi', '<s:text name="isbusi"/>', 'f', true, 1);
			addfield('form.opnlevel', '<s:text name="opnlevel"/>', 'f', true, 3);
			addfield('form.busikind', '<s:text name="busikind"/>', 'f', true, 1);
			addfield('form.busibelong', '<s:text name="busibelong"/>', 'c', true, 32);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="operation_save.do" cssStyle="formList" key="formItem"
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
                <td align="right"><s:text name="opnid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.opnid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.opnid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="name"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.name" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="parentid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.parentid" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="remark"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.remark" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="state"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.state" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="startdate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.startdate" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="enddate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.enddate" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isbusi"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isbusi" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="opnlevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.opnlevel" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busikind"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.busikind" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busibelong"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.busibelong" maxlength="32"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/operation_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/operation_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
