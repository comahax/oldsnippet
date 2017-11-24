<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.canorder', '<s:text name="canorder"/>', 'f', false, 3);
			addfield('form.printinvoice', '<s:text name="printinvoice"/>', 'f', false, 3);
			addfield('form.paytype', '<s:text name="paytype"/>', 'c', false, 16);
			addfield('form.delitype', '<s:text name="delitype"/>', 'c', false, 16);
			addfield('form.orderbetterno', '<s:text name="orderbetterno"/>', 'f', false, 3);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="wayassistant_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._ne_canorder"/>
    <s:hidden name="param._ne_printinvoice"/>
    <s:hidden name="param._se_paytype"/>
    <s:hidden name="param._se_delitype"/>
    <s:hidden name="param._ne_orderbetterno"/>
	
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
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" readonly="true" name="form.wayid" maxlength="18"/><input type="button" value="..." class="picker_button" 
                        	onclick="pshowSelectWay3(this,'form.wayid','','','AG');this.value='...';" />
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/><input type="button" value="..." class="picker_button" 
                        	onclick="pshowSelectWay3(this,'form.wayid');this.value='...';" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/><input type="button" value="..." class="picker_button" 
                        	onclick="pshowSelectWay3(this,'form.wayid');this.value='...';" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="canorder"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.canorder" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.canorder" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="printinvoice"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.printinvoice" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.printinvoice" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paytype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.paytype" definition="$FX_PAYTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.paytype" definition="$FX_PAYTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="delitype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.delitype" definition="$FX_DELITYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.delitype" definition="$FX_DELITYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="orderbetterno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.orderbetterno" definition="$IM_YESNO10" />
					</s:if>
					<s:else>
						<j:selector name="form.orderbetterno" definition="$IM_YESNO10" disabled="true"/>
					</s:else>
					<font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/wayassistant_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/wayassistant_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
