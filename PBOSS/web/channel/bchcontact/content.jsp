<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.principal', '<s:text name="principal"/>', 'c', true, 64);
			addfield('form.principaltel', '<s:text name="principaltel"/>', 'c', true, 20);
			addfield('form.principalemail', '<s:text name="principalemail"/>', 'c', true, 128);
			addfield('form.principalphone', '<s:text name="principalphone"/>', 'c', true, 20);
			addfield('form.linkman', '<s:text name="linkman"/>', 'c', true, 64);
			addfield('form.linkmantel', '<s:text name="linkmantel"/>', 'c', true, 20);
			addfield('form.linkmanemail', '<s:text name="linkmanemail"/>', 'c', true, 128);
			addfield('form.hotline', '<s:text name="hotline"/>', 'c', true, 20);
			addfield('form.fax', '<s:text name="fax"/>', 'c', true, 20);
			addfield('form.address', '<s:text name="address"/>', 'c', true, 128);
			addfield('form.zipcode', '<s:text name="zipcode"/>', 'c', true, 10);
			addfield('form.bailtype', '<s:text name="bailtype"/>', 'f', true, 2);
			addfield('form.servbound', '<s:text name="servbound"/>', 'f', true, 3);
			addfield('form.coplevel', '<s:text name="coplevel"/>', 'f', true, 3);
			addfield('form.busnum', '<s:text name="busnum"/>', 'c', true, 30);
			addfield('form.certitype', '<s:text name="certitype"/>', 'f', true, 3);
			addfield('form.certinum', '<s:text name="certinum"/>', 'c', true, 30);
			addfield('form.regadress', '<s:text name="regadress"/>', 'c', true, 128);
			addfield('form.regcapital', '<s:text name="regcapital"/>', 'f', true, 16);
			addfield('form.company', '<s:text name="company"/>', 'c', true, 60);
			addfield('form.provcode', '<s:text name="provcode"/>', 'c', true, 18);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="bchcontact_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
	
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
                <td align="right"><s:text name="principal"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.principal" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="principaltel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.principaltel" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="principalemail"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.principalemail" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="principalphone"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.principalphone" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="linkman"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.linkman" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="linkmantel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.linkmantel" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="linkmanemail"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.linkmanemail" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="hotline"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.hotline" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="fax"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.fax" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="address"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.address" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="zipcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.zipcode" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bailtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bailtype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="servbound"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.servbound" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="coplevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.coplevel" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busnum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.busnum" maxlength="30"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="certitype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.certitype" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="certinum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.certinum" maxlength="30"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="regadress"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.regadress" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="regcapital"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.regcapital" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="company"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.company" maxlength="60"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="provcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.provcode" maxlength="18"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/bchcontact_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/bchcontact_list.do')">
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
