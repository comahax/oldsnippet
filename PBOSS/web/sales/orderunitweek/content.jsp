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
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 10);
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
			addfield('form.unitage1', '<s:text name="unitage1"/>', 'l', false, 4, '', '', 1);
			addfield('form.unitage2', '<s:text name="unitage2"/>', 'l', false, 4, '', '', 1);
			addfield('form.unitage3', '<s:text name="unitage3"/>', 'l', false, 4, '', '', 1);
			addfield('form.unitage4', '<s:text name="unitage4"/>', 'l', false, 4, '', '', 1);
			addfield('form.unitage5', '<s:text name="unitage5"/>', 'l', false, 4, '', '', 1);
			addfield('form.unitage6', '<s:text name="unitage6"/>', 'l', false, 4, '', '', 1);
			addfield('form.unitage7', '<s:text name="unitage7"/>', 'l', false, 4, '', '', 1);
			
            return checkval(window);
        }
        
        $(document).ready(function(){
			var value = $("#cityidHid").val();
			if(value!="")
			{
				$("#cityid").val(value);
			}
		});
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="orderunitweek_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
	<input type="hidden" id="cityidHid" value="${cityid}">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_comcategory"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
					<font color=red>*</font>
					<s:text name="label1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="city"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CITYCOMPANY" mode="selector" id="cityid" name="form.cityid" condition="citycompid:${cityid}" value="${cityid}" disabled="true"/>
						<font color=red>*</font>
						<s:text name="label2"/>
					</s:if>
					<s:else>
						<j:selector definition="#CITYCOMPANY" mode="selector" id="cityid" name="form.cityid" condition="citycompid:${cityid}" value="${cityid}" disabled="true"/>
						<font color=red>*</font>
						<s:text name="label2"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage1"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage1" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage1" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage2"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage2" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage2" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage3"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage3" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage3" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage4"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage4" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage4" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage5"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage5" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage5" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage6"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage6" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage6" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="unitage7"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.unitage7" maxlength="4"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.unitage7" disabled="true"/>
						<font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/orderunitweek_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/orderunitweek_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
