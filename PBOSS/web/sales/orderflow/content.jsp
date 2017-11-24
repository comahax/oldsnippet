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
			addfield('form.flowname', '<s:text name="flowname"/>', 'c', false, 100);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
			addfield('form.orderave', '<s:text name="orderave"/>', 'c', false, 16);
			addfield('form.paytype', '<s:text name="paytype"/>', 'c', false, 16);
			addfield('form.delitype', '<s:text name="delitype"/>', 'c', false, 16);
			addfield('form.effective', '<s:text name="effective"/>', 'f', false, 3);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 256);
            return checkval(window);
        }
 
    </script>
</head>
<body>
<div class="table_container">
<s:form action="orderflow_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_flowname"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_orderave"/>
    <s:hidden name="param._se_paytype"/>
    <s:hidden name="param._se_delitype"/>
    <s:hidden name="param._ne_effective"/>
	
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
                <td align="right"><s:text name="flowid"/>:&nbsp</td>
                <td align="left">
						<s:textfield cssStyle="style_input" name="form.flowid" disabled="true"/>
						<font color=red>*</font>系统自动生成
                </td>
                <td align="right"><s:text name="flowname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.flowname" maxlength="100"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.flowname" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">					
						<j:selector definition="#CITYCOMPANY" name="form.cityid" condition="citycompid:${dBAccessUser.cityid }"   mode="selector" disabled="true" readonly="true"/>					
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="orderave"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_ORDERAVE" name="form.orderave" mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="$FX_ORDERAVE" name="form.orderave" mode="selector" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="paytype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_PAYTYPE" name="form.paytype" mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="$FX_PAYTYPE" name="form.paytype" mode="selector" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="delitype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_DELITYPE" name="form.delitype" mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="$FX_DELITYPE" name="form.delitype" mode="selector" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="effective"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_VALIDFLAG" condition="dictid:0,1" name="form.effective" mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="$CH_VALIDFLAG" name="form.effective" mode="selector" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.memo" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.memo" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/orderflow_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/orderflow_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
<iframe id="orderproce" src="/sales/orderproce_listByFlow.do?param._ne_flowid=<s:property value="form.flowid"/>" width="100%" framespacing="0" frameborder="NO" class="IFRM_MAIN_on" height="100%" scrolling="auto"></iframe>


</body>
</html>
