<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.seqid', '<s:text name="seqid"/>', 'f', false, 14);
			addfield('form.processid', '<s:text name="processid"/>', 'f', true, 14);
			addfield('form.startingdate', '<s:text name="startingdate"/>', 't', true, 7);
			addfield('form.module', '<s:text name="module"/>', 'c', true, 32);
			addfield('form.params', '<s:text name="params"/>', 'c', true, 64);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="daemon_save.do" cssStyle="formList" key="formItem"
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
			<span class="table_toparea"><s:text name="promotion"/> </span>
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
                <td align="right"><s:text name="seqid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.seqid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.seqid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="processid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.processid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="startingdate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.startingdate" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="module"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.module" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="params"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.params" maxlength="64"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/promotion/daemon_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/promotion/daemon_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
