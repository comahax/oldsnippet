<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.postid', '<s:text name="postid"/>', 'f', false, 14);
			addfield('form.postname', '<s:text name="postname"/>', 'c', true, 50);
			addfield('form.postkind', '<s:text name="postkind"/>', 'f', true, 3);
			addfield('form.parentpost', '<s:text name="parentpost"/>', 'f', true, 14);
			addfield('form.way', '<s:text name="way"/>', 'c', true, 18);
			addfield('form.waykind', '<s:text name="waykind"/>', 'c', true, 4);
			addfield('form.startime', '<s:text name="startime"/>', 't', true, 7);
			addfield('form.overtime', '<s:text name="overtime"/>', 't', true, 7);
			addfield('form.status', '<s:text name="status"/>', 'f', true, 3);
			addfield('form.workkind', '<s:text name="workkind"/>', 'f', true, 3);
			addfield('form.purviewmemo', '<s:text name="purviewmemo"/>', 'c', true, 255);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="postinfo_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_postid"/>
	
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
		</div>
	</div>

	<aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
	</aa:zone>
	
	<aa:zone name="contentZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="postid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.postid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.postid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="postname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.postname" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="postkind"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.postkind" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="parentpost"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.parentpost" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="way"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.way" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waykind"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waykind" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="startime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.startime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="overtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.overtime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.status" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="workkind"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.workkind" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="purviewmemo"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.purviewmemo" maxlength="255"/>
                </td>
            </tr>
        </table>
    </div>
	</aa:zone>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/postinfo_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/postinfo_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnSave");
</script>
</body>
</html>
