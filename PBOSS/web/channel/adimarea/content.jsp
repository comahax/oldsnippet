<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.adacode', '<s:text name="adacode"/>', 'c', false, 18);
			addfield('form.adaname', '<s:text name="adaname"/>', 'c', true, 64);
			addfield('form.adatype', '<s:text name="adatype"/>', 'f', true, 2);
			addfield('form.adalevel', '<s:text name="adalevel"/>', 'f', true, 2);
			addfield('form.uppercode', '<s:text name="uppercode"/>', 'c', true, 18);
			addfield('form.datayear', '<s:text name="datayear"/>', 'c', true, 5);
			addfield('form.status', '<s:text name="status"/>', 'f', true, 1);
			addfield('form.totalppn', '<s:text name="totalppn"/>', 'f', true, 10);
			addfield('form.resippn', '<s:text name="resippn"/>', 'f', true, 10);
			addfield('form.nonresippn', '<s:text name="nonresippn"/>', 'f', true, 10);
			addfield('form.adarea', '<s:text name="adarea"/>', 'f', true, 16);
			addfield('form.avgincome', '<s:text name="avgincome"/>', 'f', true, 10);
			addfield('form.gmccusers', '<s:text name="gmccusers"/>', 'f', true, 10);
			addfield('form.cucusers', '<s:text name="cucusers"/>', 'f', true, 10);
			addfield('form.ctcusers', '<s:text name="ctcusers"/>', 'f', true, 10);
			addfield('form.handphones', '<s:text name="handphones"/>', 'f', true, 10);
			addfield('form.orgcode', '<s:text name="orgcode"/>', 'c', true, 14);
			addfield('form.orgtype', '<s:text name="orgtype"/>', 'f', true, 2);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="adimarea_save.do" cssStyle="formList" key="formItem"
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
                <td align="right"><s:text name="adacode"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.adacode" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.adacode" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adaname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adaname" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adatype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adatype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adalevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adalevel" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="uppercode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.uppercode" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="datayear"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.datayear" maxlength="5"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="totalppn"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.totalppn" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="resippn"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.resippn" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="nonresippn"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.nonresippn" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adarea" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="avgincome"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.avgincome" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="gmccusers"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.gmccusers" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cucusers"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cucusers" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ctcusers"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.ctcusers" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="handphones"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.handphones" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="orgcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.orgcode" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="orgtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.orgtype" maxlength="2"/>
                </td>
            </tr>
        </table>
    </div>
	</aa:zone>

    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/adimarea_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/adimarea_list.do')">
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
