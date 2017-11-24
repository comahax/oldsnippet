<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.cntstarttime', '<s:text name="cntstarttime"/>', 't', true, 7);
			addfield('form.runstatus', '<s:text name="runstatus"/>', 'f', true, 2);
			addfield('form.completetime', '<s:text name="completetime"/>', 't', true, 7);
			addfield('form.runtime', '<s:text name="runtime"/>', 't', true, 7);
			addfield('form.closestarttime', '<s:text name="closestarttime"/>', 't', true, 7);
			addfield('form.closestoptime', '<s:text name="closestoptime"/>', 't', true, 7);
			addfield('form.closetime', '<s:text name="closetime"/>', 't', true, 7);
			addfield('form.staffstd', '<s:text name="staffstd"/>', 'f', true, 6);
			addfield('form.cntarea', '<s:text name="cntarea"/>', 'f', true, 10);
			addfield('form.bizarea', '<s:text name="bizarea"/>', 'f', true, 10);
			addfield('form.doorarea', '<s:text name="doorarea"/>', 'f', true, 10);
			addfield('form.windowarea', '<s:text name="windowarea"/>', 'f', true, 10);
			addfield('form.seatnum', '<s:text name="seatnum"/>', 'f', true, 6);
			addfield('form.actseatnum', '<s:text name="actseatnum"/>', 'f', true, 6);
			addfield('form.flexseatnum', '<s:text name="flexseatnum"/>', 'f', true, 6);
			addfield('form.cntcontractpath', '<s:text name="cntcontractpath"/>', 'c', true, 255);
			addfield('form.datatablepath', '<s:text name="datatablepath"/>', 'c', true, 255);
			addfield('form.dataarea', '<s:text name="dataarea"/>', 'f', true, 10);
			addfield('form.datanum', '<s:text name="datanum"/>', 'f', true, 16);
			addfield('form.datacost', '<s:text name="datacost"/>', 'f', true, 16);
			addfield('form.signcost', '<s:text name="signcost"/>', 'f', true, 16);
			addfield('form.signarea', '<s:text name="signarea"/>', 'f', true, 10);
			addfield('form.backarea', '<s:text name="backarea"/>', 'f', true, 10);
			addfield('form.backcost', '<s:text name="backcost"/>', 'f', true, 16);
			addfield('form.lampcost', '<s:text name="lampcost"/>', 'f', true, 16);
			addfield('form.vicost', '<s:text name="vicost"/>', 'f', true, 16);
			addfield('form.waytype', '<s:text name="waytype"/>', 'c', true, 4);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="svwaycnstr_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._de_runtime"/>
    <s:hidden name="param._se_waytype"/>
	
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
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cntstarttime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cntstarttime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="runstatus"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.runstatus" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="completetime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.completetime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="runtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.runtime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="closestarttime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.closestarttime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="closestoptime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.closestoptime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="closetime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.closetime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="staffstd"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.staffstd" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cntarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cntarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bizarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bizarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="doorarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.doorarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="windowarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.windowarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="seatnum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.seatnum" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actseatnum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.actseatnum" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="flexseatnum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.flexseatnum" maxlength="6"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cntcontractpath"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cntcontractpath" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="datatablepath"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.datatablepath" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="dataarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.dataarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="datanum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.datanum" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="datacost"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.datacost" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="signcost"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.signcost" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="signarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.signarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="backarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.backarea" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="backcost"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.backcost" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="lampcost"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.lampcost" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="vicost"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.vicost" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waytype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waytype" maxlength="4"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/svwaycnstr_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/svwaycnstr_list.do')">
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
