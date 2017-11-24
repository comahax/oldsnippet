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
            addfield('form.rewardid', '<s:text name="rewardid"/>', 'f', false, 14);
			addfield('form.rewardmonth', '<s:text name="rewardmonth"/>', 'c', true, 6);
			addfield('form.rpttype', '<s:text name="rpttype"/>', 'c', true, 32);
			addfield('form.cityname', '<s:text name="cityname"/>', 'c', true, 256);
			addfield('form.localname', '<s:text name="localname"/>', 'c', true, 256);
			addfield('form.wayidCus', '<s:text name="wayidCus"/>', 'c', true, 18);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('form.wayname', '<s:text name="wayname"/>', 'c', true, 256);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', true, 2);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="rewardlocal_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_rewardid"/>
    <s:hidden name="param._se_rewardmonth"/>
    <s:hidden name="param._se_rpttype"/>
    <s:hidden name="param._sk_cityname"/>
    <s:hidden name="param._se_wayidCus"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._ne_starlevel"/>
	
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
                <td align="right"><s:text name="rewardid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.rewardid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.rewardid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.rewardid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rewardmonth"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.rewardmonth" maxlength="6"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.rewardmonth" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rpttype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.rpttype" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.rpttype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cityname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cityname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="localname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.localname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.localname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayidCus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayidCus" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayidCus" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.starlevel" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.starlevel" disabled="true"/>
					</s:else>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/reward/rewardlocal_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/reward/rewardlocal_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
