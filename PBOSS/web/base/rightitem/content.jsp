<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.rightid', '<s:text name="rightid"/>', 'c', false, 32);
			addfield('form.region', '<s:text name="region"/>', 'f', true, 5);
			addfield('form.rightname', '<s:text name="rightname"/>', 'c', true, 64);
			addfield('form.rightgroup', '<s:text name="rightgroup"/>', 'c', true, 32);
			addfield('form.ispublic', '<s:text name="ispublic"/>', 'f', true, 1);
			addfield('form.notes', '<s:text name="notes"/>', 'c', true, 256);
			addfield('form.orgid', '<s:text name="orgid"/>', 'c', true, 32);
			addfield('form.operid', '<s:text name="operid"/>', 'c', true, 32);
			addfield('form.createdate', '<s:text name="createdate"/>', 't', true, 7);
			addfield('form.status', '<s:text name="status"/>', 'f', true, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', true, 7);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="rightitem_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_rightid"/>
	
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
                <td align="right"><s:text name="rightid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.rightid" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.rightid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="region"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.region" maxlength="5"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.region" maxlength="5" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rightname"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.rightname" maxlength="64"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.rightname" maxlength="64" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rightgroup"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.rightgroup" maxlength="32"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.rightgroup" maxlength="32" disabled="true" />
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ispublic"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.ispublic" maxlength="1"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.ispublic" maxlength="1" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="notes"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.notes" maxlength="256"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.notes" maxlength="256" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="orgid"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.orgid" maxlength="32"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.orgid" maxlength="32" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="operid"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.operid" maxlength="32"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.operid" maxlength="32" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="createdate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.createdate" maxlength="7"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.createdate" maxlength="7" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.status" maxlength="1" disabled="true"/>
				</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="statusdate"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.statusdate" maxlength="7"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.statusdate" maxlength="7" disabled="true"/>
				</s:else>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/rightitem_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled="true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/rightitem_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnSave");
</script>
</body>
</html>
